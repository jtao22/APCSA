//code to compute the factorial, superfactorial, and ultrafactorial of a natural number n. Took 35 min to code
//superfactorial: n? = n! * (n-1)! * (n-2)! * . . . * 3! * 2! * 1
//ultrafactorial: n$ = n? * (n-1)? * (n-2)? * . . . * 3? * 2? * 1
import java.util.Scanner;
import java.util.Arrays;
import java.util.*; 
import java.math.BigInteger; 
class ultrafaclong{
	public static long[] facs = new long[10000000];
	public static long[] sfacs = new long[10000000];
	public static long prime = 179424691;
	public static long factorial(int n){
		facs[1] = 1;
		for (int i = 2; i <= n; i++){
			facs[i] = facs[i-1]*i;
			facs[i] = facs[i]%(prime);
		}
		return facs[n];
	}
	public static long superfactorial(int n){
		sfacs[1] = 1;
		for (int j = 2; j <= n; j++){
			sfacs[j] = sfacs[j-1]*facs[j];
			sfacs[j] = sfacs[j]%(prime);
		}
		return sfacs[n];
	}
	public static long ultrafactorial(int n){
		long f = 1;
		for (int k = 2; k <= n; k++){
			f = f*sfacs[k];
			f = f%(prime);
		}
		return f;
	}
	public static void main(String[] args){
		//179424691
		Scanner console = new Scanner(System.in);
		System.out.println("Enter a natural number (non-negative integer): ");
		int x = console.nextInt();
		System.out.println("factorial       " + factorial(x));
		System.out.println("superfactorial: " + superfactorial(x));
		System.out.println("ultrafactorial: " + ultrafactorial(x));
	}
}