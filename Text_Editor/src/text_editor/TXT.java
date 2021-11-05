/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package text_editor;

import java.io.File;
import java.io.FileOutputStream;
import javax.swing.text.StyledDocument;

/**
 *
 * @author Yosua Blanco Diaz - Mariana Bustos V.
 */
public class TXT implements IFile{

    FileOutputStream OutF;
    String message;
    
    @Override
    public StyledDocument loadFile(File path) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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