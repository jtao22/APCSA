//number pyramid, took 55 min to code
/* I accidentally  also coded the part of the project where the letters a,b,c... are 
included to help readers visualize the pattern, I included print statements for those letters
because  I didn't read the directions closely enough :(*/ 
import java.util.Scanner;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.File;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.*;
class numberpyramid{
	public static int[] digcount = new int[10];
	public static String toString(int n){
		String s = "";
		int ten = 1;
        while (ten*10 <= n){
            ten*=10;
        } 
		while (ten >= 1){
			s = s + (char)(n/ten+48);
			n%=ten;
			ten/=10;
		}
		return s;
	}
	public static boolean checkInt(String s){ //method to check if all characters in s are integers
		for (int i = 0; i  < s.length(); i++){
	        if (s.charAt(i) == ' '){
	        	s = s.substring(0,i) + s.substring(i+1);
	        }
	        else if (!Character.isDigit(s.charAt(i))){
	        	return false;
	        }
	    }
	    return true;
	}
	public static void setzero(){ //resets all the digit counts
	   	for (int i = 0; i <= 9; i++){
	    	digcount[i] = 0;
	    }
	}
	public static void adddig(String s){ //checks frequency of digits in string s
	   	for (int i = 0; i < s.length(); i++){
	    	digcount[(int)s.charAt(i)-48]++;
	    }
	}
	public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        String playagain = "yes";
        String s,init,prints; boolean inp; int loop; //s is the string we'll be checking for frequency, print is the string we'll be pushing into the vector of strings
       	Map<String, Integer> map = new HashMap<String, Integer>(); //declare map, this lets us know if a specific string has occurred already 
       	Map<String, String> patterns = new HashMap<String, String>(); //stores previous patters
       	Map<Integer, String> printing = new HashMap<Integer, String>(); //stores output strings       	
        while (playagain.charAt(0) == 'y'){ //continues looping until player doesn't want to play anymore;
        map.clear(); //clearing both maps
        printing.clear();
       	System.out.print("Enter an integer <= 10 digits long: ");
        s = input.nextLine(); inp = false; loop = 1;
        while (!inp){ //waits until input where all the characters are numbers
        	if (s.charAt(0) == '-'){
       			s = s.substring(1); //accounts for negative
        	}
        	inp = checkInt(s);
        	if(s.length() > 10){
        		inp = false;
        	}
	        if (!inp){
	        	System.out.println("Invalid input. Please enter valid input.");
	        	s = input.nextLine();
	        }
	    }
	    init = s;
	    while (true){
	    	if (!map.containsKey(s)){ //check if we've seen this string before
	    		map.put(s,loop);
	    	}
	    	else{ //if so, print and then break;
	    		System.out.println("0. " + init);
	    		for (int i = 1; i < map.get(s); i++){
	    			System.out.println(i + ". " + printing.get(i));
	    		}
	    		char a = 'a';
	    		for (int i = 0; i < loop-map.get(s); i++){
	    			System.out.println((map.get(s)+i) + ". " + printing.get(map.get(s)+i) + " " + (char)((int)(a)+i));
	    		}
	    		a = 'a';
	    		
	    		for (int i = 0; i < loop-map.get(s)-1; i++){
	    			System.out.println((loop+i) + ". " + printing.get(map.get(s)+i) + " " + (char)((int)(a)+i));
	    		}
	    		//checking if pattern has been seen before
	    		System.out.println("Repeating pattern detected starting at index " + (map.get(s)-1) + ".");
	    		System.out.println("The repeating pattern is "+ (loop-map.get(s)) + " step(s) long.");
	    		//checking if pattern has been seen before
	    		if (!patterns.containsKey(s)){
	    			patterns.put(s,init);
	    		}
	    		else{
	    			System.out.println("PATTERN RECOGNIZED: This pattern is the same as the pattern produced by the input: " + patterns.get(s));
	    		}
	    		break;
	    	}
	    	setzero(); //reset
	    	adddig(s); //check frequency of digits
	    	//below code is all printing or updating strings
	    	s = "";
	    	prints = "";
	    	for (int i = 1; i <= 9; i++){
	    		if (digcount[i] > 0){
	    			s = s + toString(digcount[i]) + (char)(i+48);
	    			prints = prints + toString(digcount[i]) + (char)(i+48);
	    			for (int j = i; j <= 9; j++){
	    				if (digcount[j] > 0 && j != i){
	    					prints = prints + ", " + toString(digcount[j]) + (char)(j+48);
	    					s = s + toString(digcount[j]) + (char)(j+48); //update string
	    				}
	    			}
	    			break;
	    		}
	    	}
	    	// there are two for loops above because we need to format the string correctly
	    	if (digcount[0] > 0){
	    		s = s + toString(digcount[0])+(char)(48);
	    		if (prints != ""){
	    			prints = prints + ", ";
	    		}
	    		prints = prints + (char)(digcount[0]+48) + (char)(48); //add number of times zero appears
	    	}
	    	printing.put(loop,prints);
	    	loop++;
	    }
	    System.out.println("Again? ('yes' or 'no')");
	    playagain = input.nextLine();
	  }
	  System.out.println("Exiting.");
    }
}
