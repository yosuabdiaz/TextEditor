/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package text_editor;

import java.util.ArrayList;
import javax.swing.JTextPane;
import javax.swing.text.AttributeSet;
import javax.swing.text.StyledDocument;

/**
 *
 * @author Yosua Blanco Diaz
 */
public class CutCommand extends Command{

    public CutCommand(JTextPane Pane) {
        super(Pane);
    }
    @Override
    public void execute(){
        System.out.println("I'm cut");
        setText(this.myPane.getSelectedText());
        int bengining = this.myPane.getSelectionStart();
        int end = this.myPane.getSelectionEnd();
        StyledDocument doc = this.myPane.getStyledDocument();
        ArrayList<AttributeSet> atrr = new ArrayList<>();
        for (int i = bengining; i <= end; i++){
            atrr.add(doc.getCharacterElement(i).getAttributes());
            
        }
        setAtrributes(atrr);
        this.myPane.cut();
    }
   
}

