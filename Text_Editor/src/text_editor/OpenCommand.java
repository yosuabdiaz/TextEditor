/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package text_editor;

import java.io.File;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.JTextPane;

/**
 *
 * @author Yosua Blanco Diaz
 */
public class OpenCommand extends Command {

    public OpenCommand(JTextPane Pane) {
        super(Pane);
    }

    @Override
    public void execute() {
        System.out.println("I'm open");
        try {
            JFileChooser chooser = new JFileChooser();
            chooser.setDialogTitle("Abrir archivo:");
            chooser.showOpenDialog(null);
            File myFile = chooser.getSelectedFile();
            if (!myFile.exists()) {
                //Error 
                return;
            }

            String myFileName = myFile.getName();
            String extention = "";
            int index = myFileName.lastIndexOf('.');
            if (index > 0) {
                extention = myFileName.substring(index + 1);
            }
            //System.out.println(extention);
            IFile myNewFile; 
            switch(extention){
                case "csv": myNewFile = FileFactory.getFile(docType.CSV);
                break;
                case "xml": myNewFile = FileFactory.getFile(docType.XML);
                break;
                case "json": myNewFile = FileFactory.getFile(docType.JSON);
                break;
                case "txt": myNewFile = FileFactory.getFile(docType.TXT);
                break;
                default: myNewFile = FileFactory.getFile(docType.TXT);
            }
            //carga el estilo que viene de los archivos 
            //y lo guarda en el comando para actualizar 
            //interface.
            setDoc(myNewFile.loadFile(myFile));

            this.myPane.setText(extention);
            setName(myFileName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
