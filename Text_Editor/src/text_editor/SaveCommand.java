/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package text_editor;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.Style;
import javax.swing.text.StyledDocument;

/**
 *
 * @author Yosua Blanco Diaz
 */
public class SaveCommand extends Command {

    public SaveCommand(JTextPane Pane, StyledDocument doc, Style style, String name) {
        super(Pane, doc, style, name );
    }

    @Override
    public void execute() {
        System.out.println("I'm save");
        
        IFile file = FileFactory.getFile(docType.XML);
        System.out.println(getName());
        try {
            System.out.println(doc.getText(0, doc.getLength()));
            //file.saveFile("", doc);
        } catch (BadLocationException ex) {
            Logger.getLogger(SaveCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
      
    }
}
