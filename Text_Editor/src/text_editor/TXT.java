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
    @Override
    public StyledDocument loadFile(File path) {   
        String text = "";
        String message;
        String doc="";
        try{
            FileInputStream InputF;
            InputF = new FileInputStream(path);
            int ascci;
            while ((ascci = InputF.read())!=-1){
                char caracter = (char)ascci;
                doc += caracter;
            }
        }catch (Exception e){
            
        }
        message = doc;
          
        String[] textmesage = message.split("\nColors:");
               
        text = textmesage[0];               
        textmesage = textmesage[1].split(",");
        int[] colors = new int[text.length()];
        
        for (int i = 0; i<textmesage.length; i++) {
            int myNumber = Integer.parseInt(textmesage[i]);
            colors[i] = myNumber;
        }
               
        StyledDocument x = StyledDocumentManager.getStyledDocument(text, colors);
        return x;
    }
    
    @Override
    public void saveFile(File path, String text, int[] colors) {
        text = text + "\n\nColors:";
        
        for(int i=0; i<colors.length;i++){
            text = text +colors[i] + "," ; 
        }
        String message;  
        String mensaje = null;
        try{
            FileOutputStream OutF;
            OutF = new FileOutputStream(path);
            byte[] bytxt = text.getBytes();
            OutF.write(bytxt);
            mensaje = "Archivo Guardado";
                        
        }catch (Exception e){
            
        }
        message = mensaje;
    }
    
}