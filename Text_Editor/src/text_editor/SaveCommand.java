/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package text_editor;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JTextPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.BadLocationException;
import javax.swing.text.Style;
import javax.swing.text.StyledDocument;

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
        IFile file = FileFactory.getFile(docType.XML);
        file.saveFile("", doc);
        
        /*JFileChooser jfc = new JFileChooser();
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("text", "txt");
        jfc.setFileFilter(filtro);
        int seleccion = jfc.showSaveDialog(null);

        FileOutputStream fw = null;
        ObjectOutputStream bw = null;
        if (seleccion == JFileChooser.APPROVE_OPTION) {
            try {
                System.out.println(jfc.getName());
                
                  File fichero = null;
                  
                if (jfc.getFileFilter().getDescription().equals("text")) {
                    fichero = new File(jfc.getSelectedFile().getPath() + ".omf");
                } else {
                    fichero = jfc.getSelectedFile();
                }
                System.out.println(fichero.getName());
//
//                fw = new FileOutputStream(fichero);
//                bw = new ObjectOutputStream(fw);
//                Documento d = new Documento(tp_texto, doc, estilo);
//                bw.writeObject(d);
//                bw.flush();
//
//                JOptionPane.showMessageDialog(this,
//                        "Archivo guardado exitosamente");
//
            } catch (Exception e) {
                e.printStackTrace();
            }

        }//fin IF
        try {
            bw.close();
            fw.close();
        } catch (IOException ex) {
        }*/
    }
}
