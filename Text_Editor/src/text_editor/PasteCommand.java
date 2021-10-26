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
public class PasteCommand extends Command{
    String myText="";
    public PasteCommand(JTextPane Pane,String text) {
        super(Pane);
        this.myText = text;
    }
    @Override
    public void execute(){
        System.out.println("I'm paste");
        
        this.myPane.setText(this.myPane.getText() +  myText);
    }
}
