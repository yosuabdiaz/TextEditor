/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package text_editor;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.text.StyledDocument;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import utils.StyledDocumentManager;

/**
 *
 * @author  Mariana Bustos V.
 */
public class JSON implements IFile{
    
    FileOutputStream OutF;
    FileInputStream InputF;
    String message;
        
    public String OpenFile(File path) throws FileNotFoundException, IOException, ParseException{
        String doc="";
        JSONParser parser = new JSONParser();
        System.out.println(doc);        
        try{
            Object obj = parser.parse(new FileReader(path));
            JSONObject jsonObject = (JSONObject) obj;
            
            JSONArray parag = (JSONArray) jsonObject.get("Paragraph");
            
            for(int i = 0 ; i < parag.size() ; i++) {
                doc = doc + parag.get(i);
                doc = doc + "\n";
            }
            
                        
            JSONArray col = (JSONArray) jsonObject.get("Color:");
            doc = doc + "\nColor:";
            for(int i = 0 ; i < col.size() ; i++) {
                doc = doc + col.get(i);
                doc = doc + ",";
            }          
            System.out.println(doc);
        }catch (Exception e){
            
        }
        return doc;
    }
    
    @Override
    public StyledDocument loadFile(File path) {   
        String text = "";

        try {
            
            message = OpenFile(path);
            
                        
            String[] textmesage = message.split("\nColors:");
               
            text = textmesage[0];               
            System.out.println("Text: \n"+text + "\n");
            System.out.println("textmesage[1]: \n"+textmesage[1] + "\n");
            
            textmesage = textmesage[1].split(",");
            System.out.println("Prueba ----------------- \n");
            
            System.out.println("textmesage[1]: \n"+textmesage + "\n");
            
            int[] colors = new int[text.length()];

            for (int i = 0; i<textmesage.length; i++) {
                int myNumber = Integer.parseInt(textmesage[i]);
                colors[i] = myNumber;
            }

            for (int i = 0; i<textmesage.length; i++) {
                System.out.println(colors);
            }

            StyledDocument x = StyledDocumentManager.getStyledDocument(text, colors);
            return x;
            
        } catch (IOException ex) {
            Logger.getLogger(JSON.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(JSON.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public void saveFile(File path, String text, int[] colors) {
        String[] textmesage = text.split("\n");
        
        JSONObject obj = new JSONObject();
        
        JSONArray  paragraph = new JSONArray() ;
        for (int i = 0; i<textmesage.length; i++) {
            paragraph.add(textmesage[i]);
            
        }
        obj.put("Paragraph",paragraph);
        
        JSONArray  colorsList = new JSONArray() ;
        for (int i = 0; i<colors.length; i++) {
            colorsList.add(colors[i]);
        }
        obj.put("Color:",colorsList);
  
        try {
            Files.write(Paths.get(path.getName()), obj.toJSONString().getBytes());

	} catch (IOException e) {
	
	}        
        
        System.out.print(obj);
    }
   
}
