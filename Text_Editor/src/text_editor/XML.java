/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package text_editor;

import java.awt.Color;
import java.io.File;
import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.StyledDocument;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import utils.StyledDocumentManager;

/**
 *
 * @author Yosua Blanco Diaz
 */
public class XML implements IFile{

    @Override
    public StyledDocument loadFile(File path) {
      
        try {
            // parse XML file to build DOM
            DocumentBuilder builder = DocumentBuilderFactory.newInstance()
                    .newDocumentBuilder();
            Document dom = builder.parse(path);

            // normalize XML structure
            dom.normalizeDocument();

            // get root element
            Element root = dom.getDocumentElement();

           

            // print elements
            String text = root.getElementsByTagName("text").item(0).getTextContent();
            String colorData = root.getElementsByTagName("color").item(0).getTextContent();
            String[] colorDataList = colorData.split(",");
            int[] colors = new int[colorDataList.length];
            for(int i = 0; i < colorDataList.length; i++){
                colors[i] = Integer.parseInt(colorDataList[i]);
            }
            return StyledDocumentManager.getStyledDocument(text, colors);
           

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public void saveFile(File path, String text, int[] colors) {
        try {
            //crea el documento
            DocumentBuilder builder = DocumentBuilderFactory.newInstance()
                    .newDocumentBuilder();
            Document dom = builder.newDocument();
            Element root = dom.createElement("document");
            dom.appendChild(root);
            //Crea la etiqueta con el texto
            Element textData = dom.createElement("text");
            textData.setTextContent(text);
            
            String colorText = "";
            for(int i = 0; i < colors.length; i++){
                colorText += colors[i];
                if(i < (colors.length - 1)){ colorText += ","; }
            }
            //Crea la etiqueta con el color
            Element colorData = dom.createElement("color");
            colorData.setTextContent(colorText);
            root.appendChild(textData);
            root.appendChild(colorData);
            //Parsea el elemento dom en xml y lo escribe
            Transformer tr = TransformerFactory.newInstance().newTransformer();
            tr.setOutputProperty(OutputKeys.INDENT, "yes");
            tr.transform(new DOMSource(dom), new StreamResult(path));
            //tr.transform(new DOMSource(dom), new StreamResult(System.out));
        } catch (Exception ex) {
            Logger.getLogger(XML.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
}
