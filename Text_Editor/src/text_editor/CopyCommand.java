/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package text_editor;

import javax.swing.JTextPane;

/**
 *
 * @author Yosua Blanco Diaz
 */
public class CopyCommand extends Command{
    public CopyCommand(JTextPane Pane) {
        super(Pane);
    }
  
    public void execute(){
        System.out.println("I'm copy");
        setText(this.myPane.getSelectedText());
        
    }
}
