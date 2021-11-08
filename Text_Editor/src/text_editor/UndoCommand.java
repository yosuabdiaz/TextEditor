/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package text_editor;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;

/**
 *
 * @author Yosua Blanco Diaz
 */
public class UndoCommand extends Command{
    Originator originator;
    public UndoCommand(JTextPane Pane, Originator originator) {
        super(Pane);
        this.originator = originator;
    }
    @Override
    public void execute(){
        System.out.println("I'm undo");
        Memento memento = originator.careTaker.getPreviousState();
        originator.setMemento(memento);
    }
}

