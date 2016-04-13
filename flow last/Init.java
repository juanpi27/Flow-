/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package flow;
 
import java.util.Scanner;


/**
 *
 * @author Juan
 */
public class Init {
    public void Begin(){
        System.out.println("Starting now");
        String method = "c";
        Scanner in = new Scanner(System.in); 
        System.out.println("Please select the method to be used:");
        while(!method.equals("a") && !method.equals("b")){
            System.out.println("a Input File \nb Generate Code "); 
            method = in.nextLine();
            switch (method) {
                case "a":
                    new Flow().start();
                    break;
                case "b":
                    new Flow().start2();
                    break;
                default:
                    System.out.println("Please enter a or b");
                    break;
            }
        } 

    }
}
