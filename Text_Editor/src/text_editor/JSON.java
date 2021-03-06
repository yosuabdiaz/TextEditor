/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package text_editor;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import javax.swing.text.StyledDocument;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import utils.StyledDocumentManager;

/**
 *
 * @author Mariana Bustos V.
 */
public class JSON implements IFile {

    @Override
    public StyledDocument loadFile(File path) {
        String text = "";

        String message;
        String doc = "";
        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(new FileReader(path));
            JSONObject jsonObject = (JSONObject) obj;
            
            JSONArray parag = (JSONArray) jsonObject.get("Paragraph");
            
            for (int i = 0; i < parag.size(); i++) {
                doc = doc + parag.get(i);
                doc = doc + "\n";
            }
            
            JSONArray col = (JSONArray) jsonObject.get("Color:");
            doc = doc + "\nColor:";
            for (int i = 0; i < col.size(); i++) {
                doc = doc + col.get(i);
                doc = doc + ",";
            }
        } catch (Exception e) {
            
        }
        message = doc;
       
        String[] textmesage = message.split("\nColor:");
        
        text = textmesage[0];
        textmesage = textmesage[1].split(",");
        int[] colors = new int[text.length()];
        for (int i = 0; i < textmesage.length; i++) {
            int myNumber = Integer.parseInt(textmesage[i]);
            colors[i] = myNumber;
        }
        
        StyledDocument x = StyledDocumentManager.getStyledDocument(text, colors);
        return x;
    }

    @Override
    public void saveFile(File path, String text, int[] colors) {
        String[] textmesage = text.split("\n");

        JSONObject obj = new JSONObject();

        JSONArray paragraph = new JSONArray();
        for (int i = 0; i < textmesage.length; i++) {
            paragraph.add(textmesage[i]);

        }
        obj.put("Paragraph", paragraph);

        JSONArray colorsList = new JSONArray();
        for (int i = 0; i < colors.length; i++) {
            colorsList.add(colors[i]);
        }
        obj.put("Color:", colorsList);

        try {
            Files.write(Paths.get(path.getName()), obj.toJSONString().getBytes());

        } catch (IOException e) {

        }
    }

}
