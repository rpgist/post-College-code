/*
so far this just takes a input of some data file containing ints
and either sums them or subtracts them.
*/

import java.util.Scanner;
import java.io.*;
public class test{
    public static void main(String [] args){
    	System.out.print("Enter File Name: ");
	Scanner sc = new Scanner(System.in);
	String fileName = sc.next();
	try{
	    File inFile = new File(fileName);
	    //gets valid file input
	    while(!inFile.exists()){
	    	System.out.println("File DOES NOT EXIST!! ");
		System.out.print("Please enter a EXISTING file: ");
		fileName=sc.next();
		inFile = new File(fileName);
	    }
	    //calls next part of program to get function to run
	    functionCaller(inFile); 
	}catch(Exception e){
	    System.out.println(e);
	}

    }
    //takes file from functionCaller and sums the contents of the file
    public static void sum(File input) throws FileNotFoundException{
        Scanner lineSc = new Scanner(input);
        while(lineSc.hasNext()){
	    //scanner for each individual line in the file
            String line = lineSc.nextLine();
	    //checks if the line is empty
	    if(line.length() >0){
		//scanner for each token in the line
                Scanner tokenSc = new Scanner(line);
                int lineSum=0;
		//sums the line
                while(tokenSc.hasNext()){
                    String temp = tokenSc.next();
		    if(isInteger(temp)){
                        int num = Integer.parseInt(temp);
                        lineSum= lineSum+num;
		    }
                }
		//prints the sum of that line
                System.out.println(lineSum);
            }
        }
    }
    //takes file as input from functionCaller and subtracts the contents
    public static void subtract(File input) throws FileNotFoundException{
        Scanner lineSc = new Scanner(input);
        while(lineSc.hasNext()){
            String line = lineSc.nextLine();
	    //checks for emptey line
	    if(line.length() > 0){
                Scanner tokenSc = new Scanner(line);
		//preloads the total
	        String start = tokenSc.next();
		//makes sure the preload is an int
	        while((!isInteger(start))&&tokenSc.hasNext()){
            	    start=tokenSc.next();
	        }
	        if(!isInteger(start)){
		    continue;
	        }
	        int lineSum = Integer.parseInt(start);
		//goes through the line and subtracts from the preload
                while(tokenSc.hasNext()){
                    String temp = tokenSc.next();
		    //checks if next token is an int
		    if(isInteger(temp)){
                        int num = Integer.parseInt(temp);
                        lineSum= lineSum-num;
		    }
                }
		//prints the result of that line
                System.out.println(lineSum);
	    }
        }
    }
    //input is the file from main and decides what function to run
    public static void functionCaller(File inFile) throws FileNotFoundException{
	Scanner sc = new Scanner(System.in);
	//gets user input
        System.out.print("Enter a function (options are 'sub','sum', or 'multi'): ");
        String func = sc.next();
        func=func.toLowerCase();
	//checks to see if input is valid
        if(func.equals("sum")){
            sum(inFile);
        }else if(func.equals("sub")){
            subtract(inFile);
        }else if(func.equals("multi")){
	    multi(inFile);
        }else{
            System.out.println("INVALID FUNCTION!!!");
	    //recursive call to functionCaller to avoid a invalid input
	    functionCaller(inFile);
        }
    }
    //checks to see if the string is an integer
    public static boolean isInteger(String s) {
	//sets base 10 for ints
	int radix =10;
        if(s.isEmpty()){
	    return false;
	}
	//goes through string and checks for chars
        for(int i = 0; i < s.length(); i++) {
            if(i == 0 && s.charAt(i) == '-') {
                if(s.length() == 1){
		    return false;
                }else{
		    continue;
		}
            }
	    //if it is a double return false. only supports ints 
            if(Character.digit(s.charAt(i),radix) < 0){
		 return false;
	    }
        }
        return true;
    }
    //multi method is basically sum method but with a * and result starting at 1
    public static void multi(File input) throws FileNotFoundException{
	Scanner lineSc = new Scanner(input);
        while(lineSc.hasNext()){
            //scanner for each individual line in the file
            String line = lineSc.nextLine();
            //checks if the line is empty
            if(line.length() >0){
                //scanner for each token in the line
                Scanner tokenSc = new Scanner(line);
                int result=1;
                //sums the line
                while(tokenSc.hasNext()){
                    String temp = tokenSc.next();
                    if(isInteger(temp)){
                        int num = Integer.parseInt(temp);
                        result= result*num;
                    }
                }
                //prints the sum of that line
                System.out.println(result);
            }
        }
    }
}
