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
public class FileFactory {
    public static IFile getFile(docType typeDocument) {
        switch (typeDocument) {
            case CSV : return new CSV();
            case JSON : return new JSON();
            case TXT : return new TXT();
            case XML : return new XML();
            default : return new TXT();
        }

    }

}
