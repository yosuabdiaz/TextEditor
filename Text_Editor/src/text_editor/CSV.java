/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package text_editor;

/**
 *
 * @author Yosua Blanco Diaz
 */
public class CSV implements IFile{

    @Override
    public void loadFile() {
        System.out.println("me cargo como csv");
    }

    @Override
    public void saveFile() {
        System.out.println("me guardo como csv");
    }
    
}
