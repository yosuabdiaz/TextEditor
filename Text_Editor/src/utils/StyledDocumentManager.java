/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.awt.Color;
import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

/**
 *
 * @author lalem
 */
public class StyledDocumentManager {

    static public int[] getBackgroundColors(StyledDocument doc) {
        String text = "";

        try {
            text = doc.getText(0, doc.getLength());
        } catch (BadLocationException ex) {
            Logger.getLogger(StyledDocumentManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        int[] colors = new int[text.length()];

        for (int i = 0; i < text.length(); i++) {
            AttributeSet chatacterAtributes = doc.getCharacterElement(i).getAttributes();
            Enumeration<?> atributes = chatacterAtributes.getAttributeNames();
            System.out.println("Char: " + text.charAt(i));
            int colorNumber = -1;
            while (atributes.hasMoreElements()) {
                Object s = chatacterAtributes.getAttribute(atributes.nextElement());
                if (s.getClass() == Color.class) {
                    Color color = (Color) s;
                    if (color.getRGB() == 0) {
                        colorNumber = -1;
                    } else {
                        colorNumber = color.getRGB();
                    }
                }
            }
            colors[i] = colorNumber;

        }
        return colors;
    }

    static public StyledDocument getStyledDocument(String text, int[] colors) {
        StyledDocument doc = new DefaultStyledDocument();
        SimpleAttributeSet s = new SimpleAttributeSet();
        try {
            doc.insertString(0, text, s);
        } catch (BadLocationException ex) {
            Logger.getLogger(StyledDocumentManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (int i = 0; i < colors.length; i++) {
            Color c = new Color(colors[i]);
            s.addAttribute(StyleConstants.Background, c);
            doc.setCharacterAttributes(i, 1, s, true);
        }

        return doc;
    }

}
