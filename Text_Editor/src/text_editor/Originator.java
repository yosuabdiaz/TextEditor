/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package text_editor;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Element;
import javax.swing.text.Style;
import javax.swing.text.StyledDocument;

/**
 *
 * @author lalem
 */
public class Originator {
    private StyledDocument state;
    private MementoListener listener = new MementoListener();
    CareTaker careTaker = new CareTaker();
    public Originator(StyledDocument state) {
        this.state = state;
        state.addDocumentListener(listener);
    }
    
    void setMemento(Memento memento){
        if(memento == null){return;}
        state.removeDocumentListener(listener);
        try {
            state.remove(0, state.getLength());
            //state.insertString(0, memento.getState().getText(), memento.getState().getStyle());
            String text = memento.getState().getText();
            ArrayList<AttributeSet> style = memento.getState().getStyle();
            state.insertString(0, text, style.get(0));
            for (int i = 0; i< text.length(); i++){
                state.setCharacterAttributes(i, 1, style.get(i), true);
            }
        } catch (BadLocationException ex) {
            Logger.getLogger(Originator.class.getName()).log(Level.SEVERE, null, ex);
        }
        state.addDocumentListener(listener);
        
    }
    
    Memento createMemento(){
        String text = "";
        try {
            text = state.getText(0, state.getLength());
        } catch (BadLocationException ex) {
            Logger.getLogger(Interface.class.getName()).log(Level.SEVERE, null, ex);
        }
        ArrayList<AttributeSet> style = new ArrayList();
        for(int i=0; i<state.getLength();i++) {
            Element element = state.getCharacterElement(i);
            AttributeSet attribute = element.getAttributes();
            style.add(attribute);
            //append2(styledDocument.getText(i, 1), attributeNew);    
        }
        Memento memento = new Memento(new DocumentState(text, style));
        careTaker.addMemento(memento);
        return memento;
    }
    
    public class MementoListener implements DocumentListener{
    @Override
            public void insertUpdate(DocumentEvent e) {
                createMemento();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                createMemento();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                createMemento();
            }
}
}
