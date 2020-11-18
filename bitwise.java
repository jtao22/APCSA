// Code to compute results of all bitwise operations on two values a and b. Took around 45 minutes to code(finished in 15 but missed last test case, troubleshooting took 30 min)
import java.util.Scanner;
import java.util.Arrays;
import java.util.*;
import java.text.DecimalFormat;
import java.text.NumberFormat;

class bitwise{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		int a,b,ai,bi;
		System.out.println("Enter 2 numbers: ");
		a = input.nextInt(); b = input.nextInt();
		ai = a; bi = b;
		int pow = 0,powa=0,powb=0;
		while (true){
			if (Math.pow(2,pow) >= Math.max(a,b)){
				break;
			}
			if (Math.pow(2,pow) <= a){powa=pow;}
			if (Math.pow(2,pow) <= b){powb=pow;}
			pow++;
		}

		int[] a_b = new int[pow+1]; int[] b_b = new int[pow+1];int[] ans = new int[pow+1]; 
		int andanswer = 0,oranswer = 0,xoranswer = 0;
		int a_comp = 0,ar = 0,al=0;
		int b_comp = 0,br = 0,bl=0;
		Arrays.fill(a_b,0); Arrays.fill(b_b,0);
		for (int i = pow; i >= 0; i--){
			if (Math.pow(2,i) <= a){
				a_b[i] = 1; a-=(Math.pow(2,i));
			}
			if (Math.pow(2,i) <= b){
				b_b[i] = 1; b-=(Math.pow(2,i));
			}
		}

		for (int i = 0; i<= pow; i++){
			if (a_b[i] == 1 && b_b[i] == 1){
				andanswer+=Math.pow(2,i);
				oranswer+=Math.pow(2,i);
			}
			else if(a_b[i] == 1 || b_b[i] == 1){
				oranswer+=Math.pow(2,i);
				xoranswer+=Math.pow(2,i);
			}
			if (a_b[i] == 0 && i <= powa){a_comp+=Math.pow(2,i);}
			if (b_b[i] == 0 && i <= powb){b_comp+=Math.pow(2,i);}
			if (a_b[i] == 1 && i > 0){ar+=Math.pow(2,i-1);}
			if (a_b[i] == 1){al+=Math.pow(2,i+1);}
			if (b_b[i] == 1 && i > 0){br+=Math.pow(2,i-1);}
			if (b_b[i] == 1){bl+=Math.pow(2,i+1);}
		}
		System.out.println("Bitwise AND: " + andanswer);
		System.out.println("Bitwise OR: " + oranswer);
		System.out.println("Bitwise XOR: " + xoranswer);
		System.out.println("Num1:");
		System.out.println("Bitwise Complement: " + a_comp); 
		System.out.println("Bitshift Right: " + ar);
		System.out.println("Bitshift Left: " + al);
		System.out.println("Num2:");
		System.out.println("Bitwise Complement: " + b_comp); 
		System.out.println("Bitshift Right: " + br);
		System.out.println("Bitshift Left: " + bl);
	}
}