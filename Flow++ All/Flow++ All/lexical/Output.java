/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lexical;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

/**
 *
 * @author Juan
 */
public class Output {
    File f;

    /**
     * the constructor needs a filename to create a File with that name
     * @param filename
     */
    public Output(String filename){
        f = new File(filename);
    }
    
    /**
     * This method takes an ArrayList<<String>> and make a text file with the 
     * Strings, the final output of the program is created
     * @param data ArrayList<<String>>
     */
    
    public void fileWritter(ArrayList<String> data){
        FileOutputStream out; // declare a file output object
        PrintStream p; // declare a print stream object
              
        try
        {
            if(!data.isEmpty()){
            // Create a new file output stream
            // connected to "f.txt"
            out = new FileOutputStream(f + ".txt");

            // Connect print stream to the output stream
            p = new PrintStream( out );

            for (int i=0; i< data.size(); i++)
                p.println(i+" "+data.get(i));
                p.close();
            }
        }
        catch (Exception e)
        {
            System.err.println ("Error writing to file");
        }

    } 
    
    public void fileWritterfpp(ArrayList<String> data){
        FileOutputStream out; // declare a file output object
        PrintStream p; // declare a print stream object
              
        try
        {
            if(!data.isEmpty()){
                // Create a new file output stream
                // connected to "f.fpp"
                out = new FileOutputStream(f + ".fpp");

                // Connect print stream to the output stream
                p = new PrintStream( out );

                for (int i=0; i< data.size(); i++)
                    p.println(data.get(i));
                    p.close();
            }
        }
        catch (Exception e)
        {
            System.err.println ("Error writing to file");
        }

    } 

}
