/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package text_editor;

import javax.swing.JTextPane;
import javax.swing.text.Style;
import javax.swing.text.StyledDocument;

/**
 *
 * @author Yosua Blanco Diaz
 */
public class SaveAsCommand extends Command{

    public SaveAsCommand(JTextPane Pane, StyledDocument doc, Style style, String name) {
        super(Pane, doc, style, name );
    }
    @Override
    public void execute(){
        System.out.println("I'm save as ");
        
    }
}
