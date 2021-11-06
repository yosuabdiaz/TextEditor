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
public class SaveAsCommand extends Command {

    public SaveAsCommand(JTextPane Pane, StyledDocument doc, Style style, String name) {
        super(Pane, doc, style, name);
    }

    @Override
    public void execute() {
        System.out.println("I'm save as ");
        File myFile = null;
        if (getName().equals("")) {
            //select name and save
            JFileChooser chooser = new JFileChooser();
            chooser.setDialogTitle("Guardar archivo:");
            int retrival = chooser.showSaveDialog(null);
            if (retrival == JFileChooser.APPROVE_OPTION) {
                try {
                    myFile = chooser.getSelectedFile();
                    setName(chooser.getDescription(chooser.getSelectedFile()));
                    //System.out.println(chooser.getDescription(chooser.getSelectedFile()));
                    
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        } else {
            myFile = new File(getName()); 
        }
        
        String myFileName = myFile.getName();
        String extention = "";
        int index = myFileName.lastIndexOf('.');
        if (index > 0) {
            extention = myFileName.substring(index + 1);
        }
        System.out.println(extention);
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
                myNewFile = FileFactory.getFile(docType.TXT);
        }
        try {
            System.out.println(myFile);
            System.out.println(getDoc());
            myNewFile.saveFile(myFile, getDoc().getText(0,doc.getLength()), StyledDocumentManager.getBackgroundColors(getDoc()) );
        } catch (BadLocationException ex) {
            Logger.getLogger(SaveAsCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
