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

public class test {
    public static void main(String[] args) {   
        
        //ArrayList<String> LineFromFile = 
        String Delimiter = " "; 
        String []temp;
        String str ="asdf afs ad f a s d f";
        
        temp = str.split(Delimiter);
        for(int i = 0; i < temp.length;i++)
            System.out.print(temp[i]);
    }
}

        