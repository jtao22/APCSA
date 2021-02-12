//removes all values in array list that are alphabetically between begin and end string, took 15 min to code
import java.io.*; 
import java.util.*; 
import java.text.*;

class removeInRange{
	public static ArrayList<String> init = new ArrayList<String>();
	public static void main(String[] args){
		System.out.println(); System.out.println("Please enter an alphabetical sequence of strings separated");
		System.out.println("by spaces. The end of the sequence must be signified using");
		System.out.println("the sentinel value lastString, followed by a return");System.out.println();
		Scanner inp = new Scanner (System.in);String input = inp.next();
		while(!input.equals("lastString")){
			init.add(input);
			input = inp.next();
		}
		System.out.println("Your original list: " + init.toString());System.out.println();
		System.out.println("Now please enter your start String");String start = inp.next();System.out.println();
		System.out.println("Finally, please enter your end String");String end = inp.next(); System.out.println();
		System.out.print("Your reduced list: [");int counter = 0;
		for (int i = 0; i < init.size(); i++){
			if (start.compareTo(init.get(i)) <= 0 && end.compareTo(init.get(i)) >= 0){counter = counter;}
			else{
				if(counter > 0){System.out.print(", ");}
				System.out.print(init.get(i));
				counter++;				
			}
		}
		System.out.println("]");
	}
}