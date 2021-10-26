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
public class CutCommand extends Command{

    public CutCommand(JTextPane Pane) {
        super(Pane);
    }
    @Override
    public void execute(){
        System.out.println("I'm cut");
        setText(this.myPane.getSelectedText());
        this.myPane.cut();
    }
   
}

