import java.io.*;
import java.util.*;

public class count{
	public static void main(String [] args){
		int count =-1;
		counter(count);
	}

	public static void counter(int count){
		Scanner in = new Scanner(System.in);
		int input = in.nextInt();
		if(count ==-1){
			if(input==0){
				counter(input);
			}else{
				System.out.println("Next number is 0!!!!");
				counter(-1);
			}
		}else if(input==(count+1)){
			counter(input);
		}else{
			System.out.println("You messed up. Idiot next number was: "+(count+1));
			counter(-1);
			
		}
	}
}
