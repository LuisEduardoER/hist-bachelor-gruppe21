/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package converter;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * LESER OG LASTER OPP DATA TIL BOKMÅLORDBOK
 * @author Andre
 */
public class bmReader {
    public static void  main (String[] args) throws IOException, SQLException{
        // setter opp arraylist som inneholder beskrivelsene vi vil ha med
        String[] lovligeBeskrivelserTabell = {"substantiv","adjektiv","verb","adverb","pronomen","forkortelse","konjuksjon","determinativ","preposisjon","subjunksjon","interjeksjon","imperativ","infinitiv","presens","preteritum","perfektum-partisipp","presens-partisipp","feminin","maskulin","nøytral","maskulin/feminin ","entall","flertall","bestemt","ubestemt","passiv","transitiv","intransitiv","ditransitiv","positiv","komparativ","superlativ"};
        ArrayList<String> lovligeBeskrivelser = new ArrayList<String>();
        lovligeBeskrivelser.addAll(Arrays.asList(lovligeBeskrivelserTabell));
        String beskrivelse;
        //databasetilkobling
        DbConnector database = new DbConnector("jdbc:mysql://158.38.188.81:3306/dictionary","andre","f3ilif");
        database.connect();        
        //adresse til filen som skal leses
        String filename = "C:/Users/Andre/Documents/NetBeansProjects/Converter/src/converter/fullform_bm.txt";
        String line;
        String[] splitLine;
        String[] splitBeskrivelser;
        //Oppsett av fillesing
        InputStreamReader isr = new InputStreamReader(new FileInputStream(filename),"ISO-8859-15");
        BufferedReader infile = new BufferedReader(isr);
        
        // START WHILE
        while ( ((line = infile.readLine()) != null) ) {
            splitLine = line.split("\t");            
            // LØKKE SOM ERSTATTER FORKORTELSER MED FULLE ORD
            for (int i =3; i<splitLine.length-2; i++){
                //ORDKLASSER
                splitLine[i] = splitLine[i].replaceAll("adj ", "adjektiv ");
                splitLine[i] = splitLine[i].replaceAll("subst ", "substantiv ");
                splitLine[i] = splitLine[i].replaceAll("adv ", "adverb ");
                splitLine[i] = splitLine[i].replaceAll("fork ", "forkortelse ");
                splitLine[i] = splitLine[i].replaceAll("pron ", "pronomen ");
                splitLine[i] = splitLine[i].replaceAll("konj ", "konjuksjon ");
                splitLine[i] = splitLine[i].replaceAll("det ", "determinativ ");
                splitLine[i] = splitLine[i].replaceAll("prep ", "preposisjon ");
                splitLine[i] = splitLine[i].replaceAll("sbu ", "subjunksjon ");
                splitLine[i] = splitLine[i].replaceAll("interj ", "interjeksjon ");

                splitLine[i] = splitLine[i].replaceAll("imp ", "imperativ ");
                splitLine[i] = splitLine[i].replaceAll("inf ", "infinitiv ");         
                splitLine[i] = splitLine[i].replaceAll("pos ", "positiv ");
                splitLine[i] = splitLine[i].replaceAll("komp ", "komparativ ");
                splitLine[i] = splitLine[i].replaceAll("sup ", "superlativ ");
                splitLine[i] = splitLine[i].replaceAll("pass ", "passiv ");
                // IF-SETNINGER FOR Å IKKE ERSTATTE PRES OG PERF DOBBELT
                splitLine[i] = splitLine[i].replaceAll("pres ", "presens ");
                splitLine[i] = splitLine[i].replaceAll("perf ", "perfektum ");
                splitLine[i] = splitLine[i].replaceAll("pret ", "preteritum ");
                splitLine[i] = splitLine[i].replaceAll("<pres-part> ", "presens-partisipp ");
                splitLine[i] = splitLine[i].replaceAll("pres-part ", "presens-partisipp ");
                splitLine[i] = splitLine[i].replaceAll("<perf-part> ", "perfektum-partisipp ");
                splitLine[i] = splitLine[i].replaceAll("perf-part ", "perfektum-partisipp ");
                // SLUTT PÅ IF-SETNINGENE                    
                splitLine[i] = splitLine[i].replaceAll("fem ", "feminin ");
                splitLine[i] = splitLine[i].replaceAll("mask ", "maskulin ");
                splitLine[i] = splitLine[i].replaceAll("m/f ", "maskulin/feminin ");
                splitLine[i] = splitLine[i].replaceAll("nøyt ", "nøytral ");
                splitLine[i] = splitLine[i].replaceAll("ent ", "entall ");                 
                splitLine[i] = splitLine[i].replaceAll("fl ", "flertall ");
                // IF SETNINGER FOR Å IKKE ERSTATTE BESTEMT/BESTEMT DOBBELT
                splitLine[i] = splitLine[i].replaceAll("be ", "bestemt ");
                splitLine[i] = splitLine[i].replaceAll("ub ", "ubestemt ");
                // IF SETNINGER TRANSITIVITET
                splitLine[i] = splitLine[i].replaceAll("trans ", "transitiv ");
                splitLine[i] = splitLine[i].replaceAll("intrans ", "intransitiv ");
                splitLine[i] = splitLine[i].replaceAll("ditrans ", "ditransitiv ");
            } // SLUTT PÅ ERSTATTINGSLØKKE
            //SJEKKER OM LINJA ER LENGER ENN 6 KOLONNER
            if(splitLine.length == 6){
                beskrivelse ="";
                //SPLITTER DEN MORFOLOGISKE BESKRIVELSEN
                splitBeskrivelser = splitLine[3].split(" ");
                //SJEKKER OM ORDENE I SPLITEN ER "LOVLIG" (om vi vil ha dem med)
                for (int i=0;i<splitBeskrivelser.length;i++){
                    //HVIS IKKE SÅ SLETTER VI DEM (erstatter med tom streng)
                    if (!lovligeBeskrivelser.contains(splitBeskrivelser[i])){
                        splitBeskrivelser[i]="";
                    }
                }                
                //SETTE SAMMEN BESKRIVELSE IGJEN
                for (int i=0;i<splitBeskrivelser.length;i++){
                    if(!splitBeskrivelser[i].equalsIgnoreCase("")){
                        beskrivelse += splitBeskrivelser[i]+" ";
                    }
                }
                // PRINT UT
                for (int i=0;i<splitLine.length-3;i++){
                    System.out.print(splitLine[i]+" ");
                }                
                System.out.println(beskrivelse);
                database.insertNorskOrdbok(splitLine[0], splitLine[1], splitLine[2], beskrivelse);
            }// slutt if            
        } // SLUTT WHILE LØKKE
        database.disconnect();
    } //slutt main()   
}