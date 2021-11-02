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
    int currentIndex;
    
    void addMemento(Memento memento){
        if(currentIndex == 20){
            this.memento.remove();
            this.memento.add(memento);
            return;
        }
        this.memento.add(memento);
        currentIndex++;
    } 
    
    Memento getMemento(int index){
        return (index >= memento.size())? null : 
                ((LinkedList<Memento>)memento).get(index);
            
    }
    
    Memento getNextState(){
        if(currentIndex + 1 >= memento.size()){
            return null;
        }
        currentIndex++;
        return ((LinkedList<Memento>)memento).get(currentIndex);
    }
    
    Memento getPreviousState(){
        
        if(currentIndex -2 < 0){
            return null;
        }
        currentIndex--;
        System.out.println(currentIndex -1);
        return ((LinkedList<Memento>)memento).get(currentIndex -1);
    }
    
}

