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
	    while(!inFile.exists()){
	    	System.out.println("File DOES NOT EXIST!! ");
		System.out.print("Please enter a EXISTING file: ");
		fileName=sc.next();
		inFile = new File(fileName);
	    }
	    functionCaller(inFile); 
	}catch(Exception e){
	    System.out.println(e);
	}

    }
    public static void sum(File input) throws FileNotFoundException{
   	 Scanner lineSc = new Scanner(input);
            while(lineSc.hasNext()){
                String line = lineSc.nextLine();
                Scanner tokenSc = new Scanner(line);
                int lineSum=0;
                while(tokenSc.hasNext()){
                    String temp = tokenSc.next();
                    int num = Integer.parseInt(temp);
                    lineSum= lineSum+num;
                }
                System.out.println(lineSum);
            }
    }
    public static void subtract(File input) throws FileNotFoundException{
        Scanner lineSc = new Scanner(input);
        while(lineSc.hasNext()){
            String line = lineSc.nextLine();
            Scanner tokenSc = new Scanner(line);
            int lineSum=Integer.parseInt(tokenSc.next());
            while(tokenSc.hasNext()){
                String temp = tokenSc.next();
                int num = Integer.parseInt(temp);
                lineSum= lineSum-num;
            }
            System.out.println(lineSum);
        }
    }
    public static void functionCaller(File inFile) throws FileNotFoundException{
	Scanner sc = new Scanner(System.in);
        System.out.print("Enter a function (options are 'sub' or 'sum'): ");
        String func = sc.next();
        func=func.toLowerCase();
        if(func.equals("sum")){
            sum(inFile);
        }else if(func.equals("sub")){
            subtract(inFile);
        }else{
            System.out.println("IVALID FUNTION!!!");
	    functionCaller(inFile);
        }
    }
}
