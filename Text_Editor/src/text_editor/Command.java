/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package text_editor;

import java.util.ArrayList;
import javax.swing.JTextPane;
import javax.swing.text.AttributeSet;
import javax.swing.text.Style;
import javax.swing.text.StyledDocument;

/**
 *
 * @author Yosua Blanco Diaz
 */
abstract class Command {
    protected JTextPane myPane;
    protected StyledDocument doc;
    protected Style style;
    protected String text = "";
    protected ArrayList<AttributeSet> attributes = new ArrayList<>();
    protected String name = "";
    Command(JTextPane Pane){
        myPane = Pane;
    }
    
    Command(JTextPane Pane,StyledDocument doc,Style style ){
        myPane = Pane;
        this.doc = doc;
        this.style = style;
    }
    
    Command(JTextPane Pane,StyledDocument doc,Style style,String name ){
        myPane = Pane;
        this.doc = doc;
        this.style = style;
        this.name = name;
    }

    public ArrayList<AttributeSet> getAtrributes() {
        return attributes;
    }

    public void setAtrributes(ArrayList<AttributeSet> atrributes) {
        this.attributes = atrributes;
    }
    
    
    abstract void execute();
     public JTextPane getPanel() {
        return myPane;
    }

    public void setPanel(JTextPane panel) {
        this.myPane = panel;
    }

    public StyledDocument getDoc() {
        return doc;
    }

    public void setDoc(StyledDocument doc) {
        this.doc = doc;
    }

    public Style getStyle() {
        return style;
    }

    public void setStyle(Style style) {
        this.style = style;
    }
    
    public void setText(String text){
        this.text = text;
    }
    
    public String getText(){
        return text;
    }

    public String getName() {
        return name; 
    }
    
    public void setName(String name){
        this.name = name;
    }
}
