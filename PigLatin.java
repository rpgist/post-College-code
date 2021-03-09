import java.io.*;
import java.util.*;
public class PigLatin {
	public static void main(String [] args){
		System.out.print("Enter a phrase to convert to pig latin: ");
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		System.out.println("Pig latin: "+pigLatin(input));
		String result="";
		System.out.println(pigLatin("Cats are great pets."));
		System.out.println(pigLatin("Tom got a small piece of pie."));
		System.out.println(pigLatin("He told us a very exciting tale."));
		System.out.println(pigLatin("A diamond is not enough."));
		System.out.println(pigLatin("Hurry!"));
	}
	public static String pigLatin(String str) {
		Scanner sc = new Scanner(str);
		String sum ="";
		while(sc.hasNext()){
			sum=sum + convert(sc.next())+" ";
		}
		sum =sum.toLowerCase();
		
		sum= sum.substring(0, 1).toUpperCase() + sum.substring(1);
		return sum.substring(0,sum.length()-1);
	}
	public static String convert(String str){	
		char test = str.charAt(0);
		if(test=='a'||test=='e'||test=='i'||test=='o'||test=='u'){
			if(str.contains(".")){
				str=str.replace(".","");
				return str+"way.";
			}else if(str.contains("!")){
				str=str.replace("!","");
				return str+"way!";
			}else{
				return str+"way";
			}
		}else{
			char first = str.charAt(0);
			String result = str.substring(1);
			if(result.contains(".")){
				result=result.replace(".","");
				return result+first+"ay.";
			}else if(result.contains("!")){
				result=result.replace("!","");
				return result+first+"!";
			}else{
				result = result+first+"ay";
				return result;
			}
		}
	}
}
