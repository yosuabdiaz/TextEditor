/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package text_editor;

import javax.swing.text.StyledDocument;

/**
 *
 * @author lalem
 */
public class Memento {
    
    DocumentState state;
    
    Memento(DocumentState state){
       this.state = state;
    }
    
    DocumentState getState(){
        return state;
    }
    
    
}
