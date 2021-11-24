//James Hawkins
//takes user input and outputs the input in hex

import java.io.*;
import java.util.*;

public class hex{
	public static void main(String [] args){
		System.out.print("Enter text to convert to hex: ");
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		Scanner lineSc = new Scanner(input);
		while(lineSc.hasNext()){
			String word = lineSc.next();
			hexProccessor(word);
		}
		System.out.println();
	}
	public static void hexProccessor(String input){
		String output="";
		for(int i=0;i<input.length();i++){
			char temp = input.charAt(i);
			String hex = String.format("%02x",(int)temp);
			output = output.concat(hex+" ");
		}
		System.out.print(output+" ");
	}
}
