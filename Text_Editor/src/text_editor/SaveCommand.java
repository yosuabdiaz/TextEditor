/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package text_editor;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.Style;
import javax.swing.text.StyledDocument;
import utils.StyledDocumentManager;

/**
 *
 * @author Yosua Blanco Diaz
 */
public class SaveCommand extends Command {

    public SaveCommand(JTextPane Pane, StyledDocument doc, Style style, String name) {
        super(Pane, doc, style, name );
    }

    @Override
    public void execute() {
        System.out.println("I'm save");
        File myFile = null;
        if (getName().equals("")) { //si el archivo no tiene nombre
            JFileChooser chooser = new JFileChooser();
            chooser.setDialogTitle("Guardar archivo:");
            int retrival = chooser.showSaveDialog(null);
            if (retrival == JFileChooser.APPROVE_OPTION) {
                try {
                    myFile = chooser.getSelectedFile();
                    
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        } else {//si el archivo si tiene nombre 
            myFile = new File(getName()); //toma el nombre de archivo que tiene el command seteado
        }

        setName(myFile.getPath());
        //------Saca la extencio del archivo para llama en el factory
        String myFileName = myFile.getName();
        String extention = "";
        int index = myFileName.lastIndexOf('.');
        if (index > 0) {
            extention = myFileName.substring(index + 1);
        }
        //------- end
        IFile myNewFile;
        switch (extention) {
            case "csv":
                myNewFile = FileFactory.getFile(docType.CSV);
                break;
            case "xml":
                myNewFile = FileFactory.getFile(docType.XML);
                break;
            case "json":
                myNewFile = FileFactory.getFile(docType.JSON);
                break;
            case "txt":
                myNewFile = FileFactory.getFile(docType.TXT);
                break;
            default:
                System.out.println("."+extention+" no soportada.");
                return;
        }
        try {//llama al metodo guardar segun la instancia del factory
            myNewFile.saveFile(myFile, getDoc().getText(0,doc.getLength()), StyledDocumentManager.getBackgroundColors(getDoc()) );
        } catch (BadLocationException ex) {
            Logger.getLogger(SaveAsCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
