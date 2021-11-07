/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package text_editor;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import javax.swing.text.StyledDocument;
import utils.StyledDocumentManager;

/**
 *
 * @author Mariana Bustos V.
 */
public class TXT implements IFile{

    FileOutputStream OutF;
    FileInputStream InputF;
    String message;
    
    public String OpenFile(File path){
        String doc="";
        try{
            InputF = new FileInputStream(path);
            int ascci;
            while ((ascci = InputF.read())!=-1){
                char caracter = (char)ascci;
                doc += caracter;
            }
        }catch (Exception e){
            
        }
        return doc;
    }
    
    @Override
    public StyledDocument loadFile(File path) {   
        String text = "";
        message = OpenFile(path);
          
        String[] textmesage = message.split("\nColors:");
               
        text = textmesage[0];               
        textmesage = textmesage[1].split(",");
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
    }

        public String SaveInfo(File path, String text){
        String mensaje = null;
        try{
            OutF = new FileOutputStream(path);
            byte[] bytxt = text.getBytes();
            OutF.write(bytxt);
            mensaje = "Archivo Guardado";
                        
        }catch (Exception e){
            
        }
        return mensaje;
    }
    
    @Override
    public void saveFile(File path, String text, int[] colors) {
        text = text + "\n\nColors:";
        
        for(int i=0; i<colors.length;i++){
            text = text +colors[i] + "," ; 
        }
            
        message = SaveInfo(path,text);
    }
    
}