//sorted permutations of a string, took 10 min to code
import java.io.*; 
import java.util.*; 
import java.text.*;

class permuteString{
	public static SortedSet<String> ans = new TreeSet<String>();
	public static void permute(char[] s, int left, int right){
		if(left == right){
			ans.add(String.valueOf(s));
		}
		else{
			for(int i = left; i <= right; i++){
				char temp = s[left];
				s[left] = s[i];
				s[i] = temp;
				permute(s,left+1,right);
				s[i] = s[left];
				s[left] = temp;
			}
		}
	}
	public static void main(String[] args){
		System.out.println("Input string: ");
		Scanner input = new Scanner(System.in);
		String s = input.nextLine();
		char[] c = s.toCharArray();
		permute(c,0,s.length()-1);
		for (String i : ans){
			System.out.println(i);
		}
	}
}