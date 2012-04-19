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
        
        // START WHILE
        while ( ((line = infile.readLine()) != null) && limit < 20000000 ) {
            limit++;
            //splitLine = line.split("\\s+");
            splitLine = line.split("\t");
            // LØKKE SOM ERSTATTER FORKORTELSER MED FULLE ORD
            System.out.println(splitLine.length);
            for (int i =0; i<splitLine.length; i++){
                splitLine[i] = splitLine[i].replaceAll("adj", "adjektiv");
                splitLine[i] = splitLine[i].replaceAll("subst", "substantiv");
                splitLine[i] = splitLine[i].replaceAll("adv", "adverb");
                splitLine[i] = splitLine[i].replaceAll("fork", "forkortelse");
                splitLine[i] = splitLine[i].replaceAll("pron", "pronomen");
                splitLine[i] = splitLine[i].replaceAll("konj", "konjuksjon");
                splitLine[i] = splitLine[i].replaceAll("det", "determinativ");
                splitLine[i] = splitLine[i].replaceAll("prep", "preposisjon");
                splitLine[i] = splitLine[i].replaceAll("sbu", "subjunksjon");
                splitLine[i] = splitLine[i].replaceAll("interj", "interjeksjon");

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
                if (splitLine[i].equalsIgnoreCase("pret")){
                    splitLine[i] = splitLine[i].replaceAll("pret", "preteritum");
                }
                if (splitLine[i].equalsIgnoreCase("pres-part") || splitLine[i].equalsIgnoreCase("<pres-part>")){
                    splitLine[i] = splitLine[i].replaceAll("<pres-part>", "presens-partisipp");
                    splitLine[i] = splitLine[i].replaceAll("pres-part", "presens-partisipp");
                }
                if (splitLine[i].equalsIgnoreCase("perf-part") || splitLine[i].equalsIgnoreCase("<perf-part>")){
                    splitLine[i] = splitLine[i].replaceAll("<perf-part>", "perfektum-partisipp");
                    splitLine[i] = splitLine[i].replaceAll("perf-part", "perfektum-partisipp");
                }
                // SLUTT PÅ IF-SETNINGENE                    
                splitLine[i] = splitLine[i].replaceAll("fem", "feminin");
                splitLine[i] = splitLine[i].replaceAll("mask", "maskulin");
                splitLine[i] = splitLine[i].replaceAll("m/f", "maskulin/feminin");
                splitLine[i] = splitLine[i].replaceAll("nøyt", "nøytral");
                splitLine[i] = splitLine[i].replaceAll("ent", "entall");                 
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
                if (splitLine[i].equalsIgnoreCase("<trans6>") || splitLine[i].equalsIgnoreCase("<trans4>")){

                }
                 // System.out.print(splitLine[i]+" ");
            }
            //System.out.println("");
        }
        // SLUTT WHILE LØKKE
        
    }   
}
