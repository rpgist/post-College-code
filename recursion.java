
import java.io.*;
import java.util.Scanner;

public class recursion{
    public static void main(String [] args){
    	Scanner sc = new Scanner(System.in);
	System.out.print("Enter a number of repetitions: ");
	String temp = sc.next();
	int input = Integer.parseInt(temp);
	System.out.println("Series up to " +input+" :");
	for(int i=0; i<input;i++){
	    System.out.print(recur(i)+ " ");

	}
	System.out.println();
    }

    public static int recur(int input){
    	if(input==1 || input == 2){
	    return 1;
	}else if(input ==0){
	    return 0;
	}
	
	return recur(input-1) + recur(input-2);	    
    }
    
}
