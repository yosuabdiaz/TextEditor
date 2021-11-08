/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package text_editor;

/**
 *
 * @author lalem
 */
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CareTaker {
    //ArrayList<Memento> memento = new ArrayList<>();
    Queue<Memento> memento = new LinkedList<Memento>();
    int currentIndex = 0;
    
    void addMemento(Memento memento){
        if(currentIndex == 20){
            this.memento.remove();
            this.memento.add(memento);
            return;
        }
        while (this.memento.size() > currentIndex) {
             this.memento.remove();
        }
        this.memento.add(memento);
        currentIndex++;
    } 
    
    Memento getMemento(int index){
        return (index >= memento.size())? null : 
                ((LinkedList<Memento>)memento).get(index);
            
    }
    
    Memento getNextState(){
        if(currentIndex >= memento.size()){
            return null;
        }
        Memento state = ((LinkedList<Memento>)memento).get(currentIndex);
        currentIndex++;
        return state;
    }
    
    Memento getPreviousState(){
        if(currentIndex-1 <= 0){
            return null;
        }
        
        currentIndex--;
        Memento state =  ((LinkedList<Memento>)memento).get(currentIndex -1);
        return state;
    }
    
}

