//number pyramid, took 25 min to code
import java.util.Scanner;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.File;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.*;
class numberpyramid{
	public static int[] digcount = new int[10];
	public static void main(String[] args){
	    DecimalFormat df = new DecimalFormat();
        df = new DecimalFormat("##.00");
        Scanner input = new Scanner(System.in);
       	System.out.print("Enter an integer <= 10 digits long: ");
        String s = input.nextLine();
        boolean inp = false;
        while (!inp){ //checks if all the characters are numbers
        	inp = true;
        	if (s.charAt(0) == '-'){
       			s = s.substring(1); //accounts for negative
        	}
	        for (int i = 0; i  < s.length(); i++){
	        	if (!Character.isDigit(s.charAt(i))){
	        		inp = false;
	        		break;
	        	}
	        }
	        if (!inp){
	        	System.out.println("Your input must only contain numbers!");
	        	s = input.nextLine();
	        }
	    }
	    int loop = 0;
	    String prevs;
	    Map<String, Integer> map = new HashMap<String, Integer>(); 
	    while (true){
	    	if (!map.containsKey(s)){
	    		map.put(s,loop);
	    	}
	    	else{
	    		System.out.println("Repeating pattern detected starting at index " + map.get(s));
	    		System.out.println("The repeating pattern is "+ (loop-map.get(s)) + " step(s) long.");
	    		break;
	    	}
	    	for (int i = 0; i <= 9; i++){
	    		digcount[i] = 0;
	    	}
	    	for (int i = 0; i < s.length(); i++){
	    		digcount[(int)s.charAt(i)-48]++;
	    	}
	    	System.out.print(loop + ". ");
	    	s = "";
	    	for (int i = 1; i <= 9; i++){
	    		if (digcount[i] > 0){
	    			System.out.print(digcount[i]);
	    			System.out.print(i);
	    			s = s + (char)(digcount[i]+48) + (char)(i+48);
	    			for (int j = i; j <= 9; j++){
	    				if (digcount[j] > 0 && j != i){
	    					System.out.print(","+digcount[j]+j);
	    					s = s + (char)(digcount[j]+48) + (char)(j+48);
	    				}
	    			}
	    			break;
	    		}
	    	}
	    	if (digcount[0] > 0){
	    		System.out.print(","+digcount[0]+0);
	    	}
	    	System.out.println("");
	    	loop++;
	    }
    }
}