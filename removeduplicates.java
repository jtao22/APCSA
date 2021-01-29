//inefficient code solving a problem where you remove all non-case-sensitive duplicates 
//in an array list, took 15 minutes to code but had to try multiple different comparison 
//functions even though all should've worked
import java.io.*; 
import java.util.*; 
import java.text.DecimalFormat;
import java.text.NumberFormat;
class removeduplicates{
	public static ArrayList<String> arr = new ArrayList<String>(); 
	public static ArrayList<String> ans = new ArrayList<String>();
	public static void remove(ArrayList<String> arr){
		String prev = "";
		for (int i = 0; i < arr.size(); i++){
			if(!arr.get(i).equalsIgnoreCase(prev)){
				prev = arr.get(i);
				ans.add(arr.get(i));
			}
		}
	}
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		System.out.println();
		System.out.println("Please enter an alphabetical sequence of strings separated");
		System.out.println("by spaces. The end of the sequence must be signified using");
		System.out.println("the sentinel value lastString, followed by a return.");
		System.out.println();
		String input = scan.nextLine(), temp = "";
		System.out.println();
		int index;
		for (int i = 0; i < input.length(); i++){
			if(input.charAt(i) != ' '){
				temp+=input.charAt(i);
			}
			else{
				if(temp == "lastString"){
					break;
				}
				else{
					arr.add(temp);
				}
				temp = "";
			}
		}
		System.out.print("Your original list: [");
		if(arr.size() > 0){
			System.out.print(arr.get(0));
			for (int i = 1; i < arr.size(); i++){
				System.out.print(", " + arr.get(i));
			}
		}	
		System.out.println("]");
		System.out.println("");
		System.out.print("Your list with duplicates removed: [");
		if(arr.size() > 0){
			remove(arr);
			System.out.print(ans.get(0));
			for (int i = 1; i < ans.size(); i++){
				System.out.print(", " + ans.get(i));
			}
		}
		System.out.println("]");
		System.out.println("");
	}
}