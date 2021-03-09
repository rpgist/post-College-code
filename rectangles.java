public class rectangles{
	public static void main(String [] args){
		String input = args[0];
		int matrix = Integer.parseInt(input);
		int result = matrix+1;
		result = result* matrix;
		result = result/2;
		result = result*result;
		System.out.println(result);
	}
}
