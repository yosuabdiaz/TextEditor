/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package text_editor;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextPane;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;

/**
 *
 * @author Yosua Blanco Diaz
 */
public class PasteCommand extends Command{
    String myText="";
    public PasteCommand(JTextPane Pane,String text, ArrayList attributes) {
        super(Pane);
        this.myText = text;
        this.attributes = attributes;
        this.doc = myPane.getStyledDocument();
    }
    @Override
    public void execute(){
        System.out.println("I'm paste");
        
        //this.myPane.setText(this.myPane.getText() +  myText);
        int beggining = this.myPane.getCaretPosition();
        SimpleAttributeSet simpleAtrribute = new SimpleAttributeSet();
        try {
            this.myPane.getStyledDocument().insertString(beggining, myText, simpleAtrribute);
        } catch (BadLocationException ex) {
            Logger.getLogger(PasteCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
        ArrayList<AttributeSet> atributes = getAtrributes();
        for (int i = beggining; i < (myText.length()+ beggining); i++){
            if(atributes != null){
                System.out.println(doc);
                doc.setCharacterAttributes(i, 1, atributes.get(i - beggining), true);
            }
        }
    }
}
