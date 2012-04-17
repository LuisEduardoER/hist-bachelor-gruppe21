/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package converter;

/**
 *
 * @author auchaunn
 */

/*
public class Converter {
*/

    /**
     * @param args the command line argument
     */
/*
    public static void main(String[] args) {
        // TODO code application logic here
    }
}
*/

import com.sun.tools.internal.xjc.api.S2JJAXBModel;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Converter {
    public static void main(String[] args) {   
        
        //ArrayList<String> LineFromFile = 
        String Delimiter = "\\s+"; 
        String []temp;
        String str ="asdf afsadf asdf";
                
        JFileChooser fileopen = new JFileChooser();
        FileFilter filter = new FileNameExtensionFilter("Text File", "txt");
        fileopen.addChoosableFileFilter(filter);
        int ret = fileopen.showDialog(null, "Open file");
        
        if (ret == JFileChooser.APPROVE_OPTION) {
            File file = fileopen.getSelectedFile();
            FileInputStream fis = null;
            BufferedInputStream bis = null;
            DataInputStream dis = null;


            try {
                fis = new FileInputStream(file);

                // Here BufferedInputStream is added for fast reading.
                bis = new BufferedInputStream(fis);
                dis = new DataInputStream(bis);
                
                // dis.available() returns 0 if the file does not have more lines.
                while (dis.available() != 0) {
                    
                    //temp = str.split(Delimiter);
                    temp = dis.readLine().split(Delimiter);
                    for(int i = 0; i < temp.length;i++)
                        System.out.println(temp[i]);
                    
                    
                    //System.out.print(temp[i]);
                    // this statement reads the line from the file and print it to
                    // the console.
                    //System.out.println(temp[i]);
                }

                // dispose all the resources after using them.
                fis.close();
                bis.close();
                dis.close();

            } 
            catch (FileNotFoundException e) {
                e.printStackTrace();
            } 
            catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
            
        
    
