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
public class RedoCommand extends Command{
    Originator originator;
    public RedoCommand(JTextPane Pane, Originator originator) {
        super(Pane);
        this.originator = originator;
    }
    @Override
    public void execute(){
        Memento memento = originator.careTaker.getNextState();
        originator.setMemento(memento);
    }
}
