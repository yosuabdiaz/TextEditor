/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package text_editor;

import java.awt.Color;
import java.io.File;
import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.StyledDocument;

/**
 *
 * @author Yosua Blanco Diaz
 */
public class XML implements IFile{

    @Override
    public StyledDocument loadFile(File path) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void saveFile(File path, String text, int[] colors) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /*@Override
    public void saveFile(String path, StyledDocument doc) {
        String text = "";
        System.out.println(doc);
        try {
            text = doc.getText(0, doc.getLength());
        } catch (BadLocationException ex) {
            Logger.getLogger(XML.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        for(int i = 0; i< text.length(); i++){
            AttributeSet chatacterAtributes = doc.getCharacterElement(i).getAttributes();
            Enumeration<?> atributes = chatacterAtributes.getAttributeNames();
            System.out.println("Char: " + text.charAt(i));
            int c = 0;
            while(atributes.hasMoreElements()){
                Object s = chatacterAtributes.getAttribute(atributes.nextElement());
                if(s.getClass() == Color.class){
                    Color color = (Color)s;
                    c = color.getRGB();
                  
                    Color color2 = new Color(0);
                    //System.out.println(color2);
                }
                //System.out.println(chatacterAtributes.getAttribute(atributes.nextElement()).getClass());
                //System.out.println(atributes.nextElement().toString());
            }
            System.out.println("Color: " + c);
        }*/

  

    /*@Override
    public void saveFile(String path, String text, int[] colors) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/
    
}
