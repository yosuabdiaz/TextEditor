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
                System.out.println("Error con el archivo"); 
                return;
            }

            String myFileName = myFile.getName();
            String extention = "";
            int index = myFileName.lastIndexOf('.');
            if (index > 0) {
                extention = myFileName.substring(index + 1);
            }
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
            setDoc(myNewFile.loadFile(myFile));
            this.myPane.setStyledDocument(getDoc());// aqui se cargaria el estilo al pane
            setName(chooser.getDescription(chooser.getSelectedFile()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
