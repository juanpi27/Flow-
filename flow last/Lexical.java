/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package flow;

import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 *
 * @author Juan
 */
public class Lexical {
    
    ArrayList<String> tokensIden;
    ArrayList<String> tokensDef;
    ArrayList<String> arr;
    String ErrorLine;
    int ErrorLine1;
    boolean done;

    public Lexical(ArrayList<String> arrayl){
        
        tokensIden = new ArrayList<>();
        tokensDef = new ArrayList<>(); 

        if(arrayl!=null)
            arr = arrayl;
        else
            arr=new ArrayList<>();
        
        ErrorLine="";
        ErrorLine1=0;
        done=true;
        
    }

    public ArrayList<String> LexicalAnalyzer(){
        
        ArrayList<String> lexi = new ArrayList<>();
	//ArrayList<String> tokens ;
        
	if(arr.isEmpty())
            return lexi;
        
	arr = replaceRemoveComments(arr);  
	//tokens = tokensFactory(arr); 
		
	for(int i=0;i<arr.size();i++){
            if(!lex(stringTokensFactory(arr.get(i))).equalsIgnoreCase("Done")){
		done=false;
		ErrorLine1=i+1;
		i=arr.size();
            }
	}
		
	if(done){
            lexi.add("Token-TokenType");
            lexi.add("");
            for(int i=0; i<tokensIden.size();i++){
		lexi.add(tokensIden.get(i)+"-"+tokensDef.get(i));
            }
            lexi.add("");
            lexi.add("Done");
	}
	else{
            lexi.add("Token-TokenType");
            lexi.add("");
            for(int i=0; i<tokensIden.size();i++){
		lexi.add(tokensIden.get(i)+"-"+tokensDef.get(i));
            }
            lexi.add("Error in line: "+ErrorLine1+" \n "+ErrorLine);
	} 
		
        return lexi;
    }
	
    private String lex(ArrayList<String> tokens){
	String s = "Done";
        String temp = "";
        for(int i=0; i<tokens.size(); i++){
            //System.out.println(tokens.get(i));
            if(isStmt(tokens.get(i))){
		tokensDef.add(tokens.get(i)); //this is a keyword
		tokensIden.add(tokens.get(i));
            } 
            else if(isId(tokens.get(i))){
                tokensDef.add("Var");
		tokensIden.add(tokens.get(i));
            } 
            /*else if(isCharValue(tokens.get(i))){
                tokensDef.add("CharValue");
                tokensIden.add(tokens.get(i));
            }
            else if(isIntValue(tokens.get(i))){
                tokensDef.add("Number");
                tokensIden.add(tokens.get(i));
            }   */
            else if(isComma(tokens.get(i))){
		tokensDef.add("Comma");
		tokensIden.add(tokens.get(i));
            } 
            else if(isLeftParen(tokens.get(i))){
		tokensDef.add("LeftParen");
		tokensIden.add(tokens.get(i));
            }
            else if(isRightParen(tokens.get(i))){
		tokensDef.add("RightParen");
		tokensIden.add(tokens.get(i));
            }
            else if(isAssignValue(tokens.get(i))){
		tokensDef.add("Assign");
		tokensIden.add(tokens.get(i));
            }
            else if(isDelim(tokens.get(i))){
		tokensDef.add("Delimiter");
		tokensIden.add(tokens.get(i));
            }
            else if(tokens.get(i).equals("\\")){
                tokensDef.add("Backslash");
		tokensIden.add(tokens.get(i));
            } 
            else if(tokens.get(i).equals("&&&&&&&&&&*")){
                tokensDef.add("Newline");
		tokensIden.add(tokens.get(i));
            } 
            else if(tokens.get(i).equals("\'")){
                if(tokens.size()>i+1){
                    
                    if(!tokens.get(i+1).equals("\'")){
                        tokensDef.add("Quote");
                        tokensIden.add("\'");
                        temp = "";
                        i++;
                        while(i<tokens.size()&&!tokens.get(i).equals("\'")&&!tokens.get(i).equals("&&&&&&&&&&*")){ 
                            temp=temp+" "+tokens.get(i); 
                            i++;
                        }
                        //i++;
                        tokensDef.add("String");
                        tokensIden.add(temp);
                        if(i<tokens.size()){
                            if(tokens.get(i).equals("\'")){
                              tokensDef.add("Quote");
                              tokensIden.add("\'");   
                            }
                            else if(tokens.get(i).equals("&&&&&&&&&&*")){
                              tokensDef.add("Newline");
                              tokensIden.add(tokens.get(i));   
                            }
                        }
                        
                    }
                    else {
                        tokensDef.add("Quote");
                        tokensIden.add("\'");
                        i++;
                        tokensDef.add("Quote");
                        tokensIden.add("\'");
                    }
                }
                else{
                    tokensDef.add("Quote");
                    tokensIden.add("\'");
                } 
            } 
            else{
                tokensDef.add("unknown");
                tokensIden.add(tokens.get(i));
                //ErrorLine =  "Token: "+tokens.get(i)+" Number: "+i;
                //return "Error";
            }
        } 
        
        return s;
        
    }
	
    //Under Cons, not done yet
    private String syntax(ArrayList<String> tokens){
        String tkn="Done";
        boolean VarDeclFlag = true;
        boolean exitFlag = false;
        ArrayList<String> temp = new ArrayList<>();
        //TODO return error
        //TODO return error method
        for(int i=0; i<tokens.size(); i++){
            if(VarDeclFlag){ 
                if(isId(tokens.get(i))){
                    tokensDef.add("Var");
                    i++;
                    if(isLeftParen(tokens.get(i))){
                        VarDeclFlag=false;
                        tokensDef.add("LeftParen");
                        i++;
                        while(!isRightParen(tokens.get(i)) && exitFlag){
                            if(exitFlag && !isRightParen(tokens.get(i))){
                                return "error";
                            }
                            if(tokens.get(i).endsWith(",")){
									
                                if(isId(removeLast(tokens.get(i)))){
                                    tokensDef.add("Var");
                                    i++;
                                }
                            }
                            else{
                                if(isId(tokens.get(i))){
                                    exitFlag = true;
                                    tokensDef.add("Var");
                                    i++; 
                                }
                            }
                        }
                    }
                }
            }
            else {
		if(isId(tokens.get(i))){
                    tokensDef.add("Var");
                    i++;
                    if(isLeftParen(tokens.get(i))){
                        VarDeclFlag=false;
			tokensDef.add("LeftParen");
                        i++;
                        if(!isRightParen(tokens.get(i))){
                            while(!isRightParen(tokens.get(i))){
                                if(exitFlag && !isRightParen(tokens.get(i))){
                                    return "error";
                                }
                                if(tokens.get(i).endsWith(",")){
                                    if(isId(removeLast(tokens.get(i)))){
                                        tokensDef.add("Var");
                                        i++;
                                        if(isRightParen(tokens.get(i))){
                                            return "error";
                                        }
                                    }
                                    else 
                                        return "error";
                                }
                                else{
                                    if(isId(tokens.get(i))){
                                        tokensDef.add("Var");
                                        i++;
                                        if(isRightParen(tokens.get(i))){
                                            tokensDef.add("RightParen");
                                            i++;
                                        }
                                        else
                                            return "error";
                                    }
                                }
                                
                            }
                        }
                        else{
                            tokensDef.add("RightParen");
                            i++;
                        } 
                    }
                }
            }
        }
		
        return tkn;
    
    }
	
    private ArrayList<String> replaceRemoveComments(ArrayList<String> arr){
        
        ArrayList<String> arr2 = new ArrayList<>();
        
        for (String arr1 : arr) {
            arr2.add(replaceCommentRemover(arr1));
        }
        
        return arr2;
        
    }
	
    private String concatenation(ArrayList<String> arr){
        
        String s = "";
        
        for(int i = 0; i<arr.size(); i++){
            if(i!=0)
                s = s+ " \n " + arr.get(i);
            else
                s= arr.get(i);
	}
	
        return s;
        
    }
	
    private ArrayList<String> tokensFactory(ArrayList<String> arr){
        ArrayList<String> tokens = new ArrayList<>();
	StringTokenizer st = new StringTokenizer(concatenation(arr));
        while(st.hasMoreTokens()){
            tokens.add(st.nextToken());
        }
        
        return tokens;
        
    }
	
    private ArrayList<String> stringTokensFactory(String arr){
        
        ArrayList<String> tokens = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(arr);
        
        while(st.hasMoreTokens()){
            tokens.add(st.nextToken());
        }
        
        return tokens;
    }
	
    //s must be a token
    private boolean isDelim(String s){
        
        switch (s) {
            case "(":
                return true;
            case ")":
                return true; 
            case ",":
                return true; 
            //case "'":
                //return true;
            case "=":
                return true; 
        } 
        
	return false;
        
    }    
	
    private boolean isStmt(String s){
        
        switch (s) {
            case "Genesis":
                return true;
            case "Fatality":
                return true;
            case "Insert":
                return true;
            case "InsertIf":
                return true;
            case "Smash":
                return true;
            case "ShowItToMe":
                return true;
            case "GetOverHere":
                return true;
        }
        
	return false;
        
    }
	
    private boolean isIntValue(String number){
        char[] chars = number.toCharArray();
        for (int i = 0; i < chars.length; i++)
        {
            if (!Character.isDigit(chars[i]))
                return false;
        }
        return true;
    }
	
    private boolean isWordValue(String word){
        char[] chars = word.toCharArray();
        for (int i = 0; i < chars.length; i++)
        {
            if (!Character.isLetter(chars[i]))
                return false;
        }
        return true;
    }
	
    private String removeLast(String word){
        char[] chars = word.toCharArray();
        String wordRLast = "";
        for (int i = 0; i < chars.length-1; i++)
        {
        	wordRLast = wordRLast + Character.isLetter(chars[i]);
        }
        return wordRLast;
    }
	
    private String removeFirst(String word){
        char[] chars = word.toCharArray();
        String wordRFirst = "";
        for (int i = 1; i < chars.length; i++)
        {
        	wordRFirst = wordRFirst + Character.isLetter(chars[i]);
        }
        return wordRFirst;
    }
	
    private boolean isCharValue(String chara){
		if(chara.length()==1){
        char[] chars = chara.toCharArray();
            if (Character.isLetter(chars[0]))
                return true;
		}
        return false;
    }

	
    private boolean isId(String token){
        
        char[] chars = token.toCharArray();
        int k;
        char d = "_".charAt(0);
        
        for (int i = 0; i < chars.length; i++){ 
            
            if ((!Character.isLetter(chars[i])&& i!=0) && Character.compare(d, chars[i])!=0){
            	k=i;
            	i=chars.length;
            	for (int j = k; j < chars.length; j++)
                {
                    if (!Character.isDigit(chars[j]))
                        return false;
                }
            }
            else if(!Character.isLetter(chars[i]) && i==0){
            	return false;
            }
            
        }
        
        return true;
        
    }
        
    private boolean isStr(String token){
        char[] chars = token.toCharArray();
        //int k;
        char d = "_".charAt(0);
        for (int i = 0; i < chars.length; i++){ 
            if (!Character.isLetter(chars[i]) && Character.compare(d, chars[i])!=0 && !Character.isDigit(chars[i])){
                return false; 
            }
        }
        return true;
    }
	
    private boolean isComma(String token){ 
        return token.length()==1 && token.equals(","); 
    } 
	
    private boolean isLeftParen(String token){ 
        return token.length()==1 && token.equals("(");
    }
	
    private boolean isRightParen(String token){
        if(token.length()==1){
            if (token.equals(")"))
                return true;
        }
        return false;
    }
	
    private boolean isAssignValue(String token){
        if(token.length()==1){
            if (token.equals("="))
                return true;
	}
        return false;
    }
    
    //under cons
    private Boolean isStatement(){
        return true;
    }
    
    //under cons
    private boolean isVarcDecl(String st){
	return true;
    }
	
    private String replaceCommentRemover(String s){ 
        s=s.replace(",", " , "); 
        s=s.replace("(", " ( ");
        s=s.replace(")", " ) "); 
        s=s.replace("\'", " \' ");   
        s=s.replace("//", " // "); 
        s=s.replace("=", " = ");
        s=s.replace("\n", " &&&&&&&&&&* ");
        StringTokenizer st = new StringTokenizer(s);
        String sReturn="";
        String token;
        //String noComment="";
        //char[] c;
        //Character ch;
        
        while(st.hasMoreElements()){
            token=st.nextToken(); 
            if(token.equals("//")){ 
                //System.out.println(sReturn); 
                return sReturn;
            } 
            else if(st.hasMoreElements())
                sReturn = sReturn+token+" ";
            else
                sReturn = sReturn+token;
        }
        sReturn = sReturn+" &&&&&&&&&&* ";
        return sReturn;
        
    }

}
