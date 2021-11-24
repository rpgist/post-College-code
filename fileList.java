//James Hawkins
//Takes in a directory and lists all the files in that directory

import java.util.*;
import java.io.*;

public class fileList{
	public static void main(String [] args){
		System.out.println("Driectory to list(Default is /home/): ");
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		if(input.equals("")){
			input= "/home/bb6/";
		}
		try{
			File file = new File(input);
			String [] fileList = file.list();
			for(String name : fileList){
				System.out.println(name);
			}
		}catch(Exception e){
			System.out.println(e);
		}
	}
}
