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

public class CareTaker {
    ArrayList<Memento> memento = new ArrayList<>();
    int currentIndex;
    
    void addMemento(Memento memento){
        if(currentIndex >= this.memento.size())
        this.memento.add(memento);
        currentIndex++;
    } 
    
    Memento getMemento(int index){
        return (index >= memento.size())? null : memento.get(index);
            
    }
    
    Memento getNextState(){
        if(currentIndex + 1 >= memento.size()){
            return null;
        }
        currentIndex++;
        return memento.get(currentIndex);
    }
    
    Memento getPreviousState(){
        System.out.println(currentIndex);
        if(currentIndex -1 < 0){
            return null;
        }
        currentIndex--;
        System.out.println(currentIndex);
        return memento.get(currentIndex);
    }
    
}

