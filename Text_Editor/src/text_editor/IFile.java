/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package text_editor;

import javax.swing.text.StyledDocument;

/**
 *
 * @author Yosua Blanco Diaz
 */
interface IFile {
    void loadFile(String path);
    void saveFile(String path, StyledDocument doc);
}
