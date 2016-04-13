package lexical;



import gui.FlowInterface;

import java.io.File;
import java.util.Scanner;

/**
 *
 * @author Juan
 */
public class LexicalAnalyzer {
    
    public void start(){
       
    	String filename;
 
        filename=FlowInterface.getInputFile();
        File f = new File(filename+".fpp");
        Reading rf = new Reading(f);
        Lexical lex = new Lexical(rf.readFile());
        Output ou = new Output(filename+"_lexAnalisys");
        ou.fileWritter(lex.LexicalAnalyzer());
        FlowInterface.writeToUser("Ending...", false);
    }
    
    public void start2(){
       //Scanner in = new Scanner(System.in);  
        new Output("test").fileWritterfpp(new CodeGenerator().Generate());  
        Reading rf = new Reading(new File("test.fpp")); 
        new Output("test_lexAnalisys").fileWritter(new Lexical(rf.readFile()).LexicalAnalyzer());
        //System.out.print("Ending... ");
        FlowInterface.writeToUser("Ending...", false);
    }
    
}
