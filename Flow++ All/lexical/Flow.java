/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lexical;
import java.io.File;
import java.util.Scanner;

/**
 *
 * @author Juan
 */
public class Flow {
    
    public void start(){
        Scanner in = new Scanner(System.in); 
	String filename;
        String filename2;
        System.out.println("Enter filename(place the .fpp in project folder, dont write .fpp): "); 
        filename = in.nextLine(); 
        System.out.println("Enter the name of the file that will be generated(do not include extension): "); 
        System.out.println("(.txt file will be placed in project folder)"); 
        filename2 = in.nextLine(); 
        File f = new File(filename+".fpp");
        Reading rf = new Reading(f);
        Lexical lex = new Lexical(rf.readFile());
        Output ou = new Output(filename2);
        ou.fileWritter(lex.LexicalAnalyzer());
        System.out.print("Ending... "); 
    }
    
    public void start2(){
        Scanner in = new Scanner(System.in);  
        new Output("test").fileWritterfpp(new CodeGenerator().Generate());  
        Reading rf = new Reading(new File("test.fpp")); 
        new Output("output").fileWritter(new Lexical(rf.readFile()).LexicalAnalyzer());
        System.out.print("Ending... ");   
    }
    
}
