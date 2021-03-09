import java.util.*;
public class Reverse{
  	public static void main(String [] args){
		System.out.print("Enter a sting to be reversed: ");
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		System.out.println(reverse(input));
  	}
  	public static String reverse(String str) {
		//System.out.println("This is input:" + str);
		Scanner sc = new Scanner(str);
		ArrayList<String> wordArrayList = new ArrayList<String>();
		for(String word : str.split(" ")) {
		//	System.out.println("this is word to add to array: "+word);
    			wordArrayList.add(word);
		}
		String result="";
		for(int i=0;i<wordArrayList.size();i++){
			String temp =wordArrayList.get(i);
			//System.out.println("This is word to get reversed: "+temp);
			char[] try1 = temp.toCharArray();
			String temp2 = "";
			for (int j = try1.length - 1; j >= 0; j--){
				temp2=temp2+try1[j];
			}
			result = temp2+ " "+result;
		}
		//System.out.println(result);
		return result;
  	}
}
