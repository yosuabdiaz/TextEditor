/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package text_editor;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
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
            state.insertString(0, memento.getState().getText(), memento.getState().getStyle());
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
        Style style = state.getStyle(text);
        Memento memento = new Memento(new DocumentState(text, style));
        careTaker.addMemento(memento);
        return memento;
    }
    
    public class MementoListener implements DocumentListener{
    @Override
            public void insertUpdate(DocumentEvent e) {
                System.out.println("1");
                createMemento();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                System.out.println("1");
                createMemento();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                System.out.println("1");
                createMemento();
            }
}
}
