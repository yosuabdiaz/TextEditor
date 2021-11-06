/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package text_editor;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.String.valueOf;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.text.StyledDocument;
import utils.StyledDocumentManager;

/**
 *
 * @author Yosua Blanco Diaz
 */
public class CSV implements IFile {

    @Override
    public StyledDocument loadFile(File path) {
        BufferedReader csvReader;
        String[] data;
        String row;
        String text = "";
        ArrayList<Integer> colorsNumber = new ArrayList<>();
        try {
            csvReader = new BufferedReader(new FileReader(path.getPath()));
            while ((row = csvReader.readLine()) != null) {
                data = row.split(";");
                if (text.equals("")) {
                    for (String word : data) {
                        text += word + " ";
                    }
                } else {
                    int index = 0;
                    for (String number : data) {
                        int myNumber = Integer.parseInt(number);
                        colorsNumber.add(myNumber);
                    }
                }
            }
            csvReader.close();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(CSV.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(CSV.class.getName()).log(Level.SEVERE, null, ex);
        }
        int[] colorsFile = new int[text.length()];
        int index = 0;
        for (int n : colorsNumber) {
            colorsFile[index] = n;
            //System.out.print(colorsFile[index]+",");
            index++;
        }
        StyledDocument x = StyledDocumentManager.getStyledDocument(text, colorsFile);
        return x;
    }

    @Override
    public void saveFile(File path, String text, int[] colors) {
        //valida que no tenga ; el texto del editor.
        for (int i=0; i < text.length(); i++){
            char c = text.charAt(i);
            if(c == ';'){
                System.out.println("El formato no es correcto, contiene ;");
                return;
            }

        }
        System.out.println("El formato es correcto");
        String estilo="";
        for(int number : colors){
            if(estilo.equals("")){
                estilo += valueOf(number);
            }else{
                estilo += ";"+valueOf(number);
            }
        }
        
        // ------- end
        //----Formo el texto en el formato adecuado para escribir
        String myText = text.replace(' ',';');
        String myText2 = myText.replace('\n',';');
        // create FileWriter object with file as parameter
        PrintWriter pw = null;
        try {   
            pw = new PrintWriter(path);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        pw.write(myText2+"\n");
        pw.write(estilo);
        pw.close();
    }

}
