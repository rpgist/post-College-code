
import java.util.Scanner;
import java.io.*;

public class test{
    public static void main (String [] args){
	boolean weekday;
	boolean vacation;
	Scanner sc = new Scanner(System.in);
	System.out.print("enter weekday y or n: ");
	String temp = sc.next();
	if(temp.equals("y")){
	    weekday = true;
	}else{
	    weekday= false;
	}
	System.out.print("enter vacation y or n: ");
	temp = sc.next();
	if(temp.equals("y")){
	    vacation = true;
	}else{
	    vacation = false;
	}
    	if(tester(weekday, vacation)){
	    System.out.println("sleep");
	}else{
	    System.out.println("awaken");
	}
    } 
    public static boolean tester(boolean weekday, boolean vacation){
    	if(!weekday || vacation){
	    return true;
	}else{
	    return false;
	}
    }
}
