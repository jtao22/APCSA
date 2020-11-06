// print out prime factorization of any value + total factors, took 10 min to code
import java.util.Scanner;
import java.util.Arrays;
class factorize{
	public static int best;
	public static boolean prime(int n){
		if (n%2==0){return false;};
		for(int i = 3; i <= (int)(Math.sqrt(n)+1); i+=2){
			if (n%i==0){return false;};
		}return true;
	}
	public static void primefactorize(int n){
		int count = 0, total = 1;
		while(n%2==0){count++;n/=2;}
		if(count>0){System.out.println("2 to the power of " + count);}
		total*=(count+1);count = 0;
		for (int i = 3; i <= (int)(Math.sqrt(n)+1); i+=2){
			count = 0;
			while(n%i==0){count++;n/=i;}
			if(count>0){System.out.println(i + " to the power of " + count);}
			total*=(count+1);
		}
		if (prime(n) && n > 2){System.out.println(n + " to the power of " + 1);total*=2;}
		System.out.println("Number of factors: " + total);
	}
	public static void main(String[] args){
		Scanner console = new Scanner(System.in);
		int n = console.nextInt();
		primefactorize(n);
	}
}