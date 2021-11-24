//Takes in the file path to a file and checks the read and write permissions
//James Hawkins
//
import java.util.*;
import java.io.*;

public class filePermissions{
	public static void main(String [] args){
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the path to a file to check the permissions of: ");
		String input = sc.nextLine();
		String result ="";
		try{
			File file = new File(input);
			if(file.canWrite()){
				result = result + "can write ";
			}else{
				result = result + "cannot write ";
			}if(file.canRead()){
				result = result + "can read ";
			}else{
				result = result + "cannot read ";
			}
			System.out.println(result);
		}catch(Exception e){
			System.out.println("File not found");
		}
	}
}
