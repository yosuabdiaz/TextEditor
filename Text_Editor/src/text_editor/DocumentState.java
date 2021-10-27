/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package text_editor;

import javax.swing.text.Style;

/**
 *
 * @author lalem
 */
public class DocumentState {
    private String text;
    private Style style;

    public DocumentState(String text, Style style) {
        this.text = text;
        this.style = style;
    }

    public String getText() {
        return text;
    }

    public Style getStyle() {
        return style;
    }
    
    
}
