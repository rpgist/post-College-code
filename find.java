//finds a string in a file and adds depending on user input
import java.util.Scanner;
import java.io.*;
public class find{
    public static void main(String [] args)throws FileNotFoundException{
	//string to hold current input
    	String input="";
	//string to check. might change to boolean
	String run = "y";
	//gets file to use
	System.out.print("Enter a file name: ");
	Scanner sc = new Scanner(System.in);
	String fileName =sc.next();
	//makes sure file exists
	try{
	    File dir = new File(fileName);
	    while(!dir.exists()){
  	        System.out.println("Invalid File!");
		System.out.print("Enter a EXISTING file: ");
		fileName=sc.next();
		dir= new File(fileName);
	    }
	    //runs the program until user says to stop
	    while(run.equals("y")){
		//gets string to check
	        System.out.print("Enter a string to search: ");
	        input=sc.next().toLowerCase();
	        boolean test =checker(input, dir);
	    	if(test){
	            System.out.println(input + " EXISTS IN FILE!!!");
	    	}else{
	            System.out.println(input + " DOES NOT EXIST IN FILE :(");
		    System.out.print("Would you like to add " +input+" to the file? (y/n)");
		    String answer = sc.next().toLowerCase();
		    if(answer.equals("y")){
			adder(input, dir);
		    }
	    	}
		System.out.print("continue searching? (y/n) : ");
		run=sc.next();
	    }
	}catch(Exception e){
	    System.out.println(e);
	}
    }
    
    //checks to see if the string is in the file
    public static boolean checker(String input, File dir)throws FileNotFoundException{
	Scanner fileSc= new Scanner(dir);
	while(fileSc.hasNextLine()){
	    String line = fileSc.nextLine().toLowerCase();
	    Scanner lineSc = new Scanner(line);
	    while(lineSc.hasNext()){
	    	String temp= lineSc.next();
		if(temp.equals(input)){
		    return true;
		}
	    }
	}
	return false;
    }
    
    //adds the string to the file
    public static void adder(String input, File dir){
	try{
    	    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(dir, true)));
	    out.println(input);
	    out.close();
	}catch(Exception e){
	    System.out.println(e);
	}
    }
}
