/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package flow;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Juan
 */
public class CodeGenerator {
    
    public ArrayList<String> Generate(){
        String[] lex = {"start", "end","'statement bien random'","a", "=", 
                        "Genesis", "","Fatality", ",", "Insert",  "InsertIf",
                        "Smash", "ShowItToMe", "GetOverHere", "()", "b2", "5",
                        "(",")"}; 
        int a =lex.length;
        String line = "";
        ArrayList<String> flowcode = new ArrayList<>();
        for(int x=0;x<=2000;x++){
            if(x%10==0){
                line = line+" "+lex[new Random().nextInt(a)];
                flowcode.add(line);
                line="";
            }
            else{
                line = line+" "+lex[new Random().nextInt(a)];
            }
        }
        return flowcode;
    }

}
