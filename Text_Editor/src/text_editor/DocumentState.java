/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package text_editor;

import java.util.ArrayList;
import javax.swing.text.AttributeSet;
import javax.swing.text.Style;

/**
 *
 * @author lalem
 */
public class DocumentState {
    private String text;
    ArrayList<AttributeSet> style;

    public DocumentState(String text, ArrayList<AttributeSet> style) {
        this.text = text;
        this.style = style;
    }

    public String getText() {
        return text;
    }

    public  ArrayList<AttributeSet> getStyle() {
        return style;
    }
    
    
}
