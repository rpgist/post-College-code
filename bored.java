//James Hawkins
//asks user for cat or dog. cat just prints cato a the number of times from user input
//dog does some file processing on a gutenburg text file

import java.util.*;
import java.io.*;

public class bored{

	public static void main(String [] args){
		System.out.println("Enter a option(cat or dog): ");
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		if(input.equals("cat")){	
			cat();
		}else if(input.equals("dog")){
			dog();
		}
	}

	//method takes in nothing
	//prompts user for number 
	//prints cato that many times
	public static void cat(){
		System.out.println("Enter a number: ");
		Scanner sc = new Scanner(System.in);
		String input = sc.next();
		for(int i = 0; i < Integer.parseInt(input); i++){
			System.out.println("Cato");
		}
	}

	//prompts user for a file
	//is setup to read a guttenburg .txt file
	//promtps for word to count occurance of in the file
	public static void dog(){
		System.out.print("Enter a file to process: ");
		Scanner sc = new Scanner(System.in);
		String input = sc.next();
		System.out.print("Would you like to know the most common word in the file? (yes or no): ");
		String yer = sc.next();
		if(yer.toLowerCase().equals("yes")){
			PopularCounter(input);
		}
		System.out.print("Would you like to count a specific word? (yes or no)" );
		yer = sc.next().toLowerCase().trim();
		if(yer.equals("yes")){
			wordCounter(input);
		}
	}
	
	//Counts the number of occurances of a word in the file
	//take in a file name to proccess
	public static void wordCounter(String input){
		int lineCount = 0;
		int wordCount = 0;
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter a word to count: ");
		String word = sc.next().toLowerCase();
	  	try{
			File file = new File(input);
			Scanner fileSc = new Scanner(file);
			ArrayList<String> list = new ArrayList<String>();
			while(fileSc.hasNextLine()){
				String line = fileSc.nextLine();
				lineCount++;
				Scanner lineSc = new Scanner(line);
				while(lineSc.hasNext()){
					String temp = lineSc.next().toLowerCase().trim();
					if(temp.equals("release")){
						if(lineSc.hasNext()){
							temp = lineSc.next().toLowerCase().trim();
							if(temp.equals("date:")){
								list.add(line);
							}
						}
					}
					if(temp.equals(word)){
						wordCount++;
					}
				}
			}
			for(int i = 0; i < list.size(); i++){
				System.out.println(list.get(i));
			}
			System.out.println("File contained "+lineCount+" lines.");
			System.out.println("File contained (" + word + ") " + wordCount + " times.");	
		}catch(Exception e){
			System.out.println(e);
		}
	}
	
	//finds the most common word in the file
	//takes in the file to process
	public static void PopularCounter(String fileName){
		try{
			File file = new File(fileName);
			Scanner fileSc = new Scanner(file);
			Map<String, Integer> map = new HashMap<String, Integer>();
			while(fileSc.hasNextLine()){
				String line = fileSc.nextLine();
				Scanner lineSc = new Scanner(line);
				while(lineSc.hasNext()){
					String temp = lineSc.next().toLowerCase().trim();
					if(map.containsKey(temp)){
						int value = map.get(temp);
						map.put(temp, value+1);
					}else{
						map.put(temp, 1);
					}					
				}
			}
			int check = 0;
			String result = "";
			for(String i : map.keySet()){
				int value = map.get(i);
				if(value > check){
					result = i;
					check = value;
				} 	
			}
			System.out.println("The most common word was (" + result + ") it appeared: " 
					   + check+" times");
		}catch(Exception e){
			System.out.println(e);
		}
	}
}
