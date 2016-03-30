/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package flow;
import java.io.*;
import java.util.ArrayList;

/**
 *
 * @author Juan
 */
public class Reading {
    File name; 
     /**
      * the constructor as a parameter needs a File 
      * @param name
      */
    public Reading(File name){ 
        this.name=name;  
    }
/**
 * read the file and return data in an ArrayList of String
 * @return file data in a ArrayList of String
 */
    public ArrayList<String> readFile(){
    File f = name;
    ArrayList<String> resumen = new ArrayList<>();
    String newline="";
      
    try{
    FileReader fr = new FileReader(f);
    BufferedReader br = new BufferedReader(fr);
     
    StringBuffer sb = new StringBuffer();
    String eachLine = br.readLine();

    while (eachLine != null) {
      sb.append(eachLine);
      sb.append("\n");
      newline = eachLine;
      resumen.add(newline);
      eachLine = br.readLine();
    }
   

   if(resumen.isEmpty())//in case data want to be seen remove this if (before)
        System.out.println(sb.toString());
   //if(resumen.isEmpty())//in case data want to be seen remove this if (after)
    for(int r=0;r<resumen.size();r++)
       System.out.println(resumen.get(r));
    
    } 
     catch (FileNotFoundException e) {
      System.out.println("File not Found");
      return null;
    }
    catch (IOException e) {
      System.out.println("IOException");
    }
      return resumen;
    }

}
