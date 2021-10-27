/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package text_editor;

import java.awt.Color;
import javax.swing.JColorChooser;
import javax.swing.JTextPane;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

/**
 *
 * @author Yosua Blanco Diaz
 */
public class ColorCommand extends Command{

    public ColorCommand(JTextPane Pane, StyledDocument doc,Style style ) {
        super(Pane,doc,style);
    }
    @Override
    public void execute(){
        System.out.println("I'm color");
        try {

            StyleConstants.setBackground(style,
                    JColorChooser.showDialog(myPane,"Seleccione Color", Color.yellow)
            );

            doc.setCharacterAttributes(myPane.getSelectionStart(),
                    myPane.getSelectionEnd() - myPane.getSelectionStart(),
                    myPane.getStyle("miEstilo"),
                true);
        } catch (Exception ex) {
        }
    }
}
