/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package converter;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Andre
 */
public class nbReader {
    public static void  main (String[] args) throws IOException{
        
        String filename = "C:/Users/Andre/Documents/NetBeansProjects/Converter/src/converter/fullform_bm.txt";
        String line;
        String[] splitLine;
        
        InputStreamReader isr = new InputStreamReader(new FileInputStream(filename),"ISO-8859-15");
        BufferedReader infile = new BufferedReader(isr);
        int limit = 0;
        while ( ((line = infile.readLine()) != null) && limit < 60000 ) {
            limit++;
            
            if (limit > 5000){
                splitLine = line.split("\\s+");
                // LØKKE SOM ERSTATTER FORKORTELSER MED FULLE ORD
                for (int i =0; i<splitLine.length; i++){
                    splitLine[i] = splitLine[i].replaceAll("adj", "adjektiv");
                    splitLine[i] = splitLine[i].replaceAll("subst", "substantiv");
                    splitLine[i] = splitLine[i].replaceAll("imp", "imperativ");
                    splitLine[i] = splitLine[i].replaceAll("inf", "infinitiv");         
                    splitLine[i] = splitLine[i].replaceAll("pos", "positiv");
                    splitLine[i] = splitLine[i].replaceAll("komp", "komparativ");
                    splitLine[i] = splitLine[i].replaceAll("sup", "superlativ");
                    splitLine[i] = splitLine[i].replaceAll("pass", "passiv");
                    // IF-SETNINGER FOR Å IKKE ERSTATTE PRES OG PERF DOBBELT
                    if (splitLine[i].equalsIgnoreCase("pres")){
                        splitLine[i] = splitLine[i].replaceAll("pres", "presens");
                    }
                    if (splitLine[i].equalsIgnoreCase("perf")){
                        splitLine[i] = splitLine[i].replaceAll("perf", "perfektum");
                    }
                    if (splitLine[i].equalsIgnoreCase("pres-part") || splitLine[i].equalsIgnoreCase("<pres-part>")){
                        splitLine[i] = splitLine[i].replaceAll("<pres-part>", "presens-partisipp");
                    }
                    if (splitLine[i].equalsIgnoreCase("perf-part") || splitLine[i].equalsIgnoreCase("<perf-part>")){
                        splitLine[i] = splitLine[i].replaceAll("<perf-part>", "perfektum-partisipp");
                    }
                    // SLUTT PÅ IF-SETNINGENE                    
                    splitLine[i] = splitLine[i].replaceAll("fem", "feminin");
                    splitLine[i] = splitLine[i].replaceAll("mask", "maskulin");
                    splitLine[i] = splitLine[i].replaceAll("nøyt", "nøytral");
                    splitLine[i] = splitLine[i].replaceAll("ent", "entall");
                    splitLine[i] = splitLine[i].replaceAll("fork", "forkortelse");
                    if (splitLine[i].equalsIgnoreCase("fl")){
                        splitLine[i] = splitLine[i].replaceAll("fl", "flertall");
                    }
                    // IF SETNINGER FOR Å IKKE ERSTATTE BESTEMT/BESTEMT DOBBELT
                    if (splitLine[i].equalsIgnoreCase("be")){
                        splitLine[i] = splitLine[i].replaceAll("be", "bestemt");
                    }
                    if (splitLine[i].equalsIgnoreCase("ub")){
                        splitLine[i] = splitLine[i].replaceAll("ub", "ubestemt");
                    }
                    // IF SETNINGER TRANSITIVITET
                    if (splitLine[i].equalsIgnoreCase("trans")){
                        splitLine[i] = splitLine[i].replaceAll("trans", "transitiv");
                    }
                    if (splitLine[i].equalsIgnoreCase("intrans1")){
                        splitLine[i] = splitLine[i].replaceAll("intrans", "intransitiv");
                    }
                    if (splitLine[i].equalsIgnoreCase("ditrans1")){
                        splitLine[i] = splitLine[i].replaceAll("ditrans", "ditransitiv");
                    }
                    
                     System.out.print(splitLine[i]+" ");
                }
                 System.out.println("");
            }
        }
        
    }   
}
