//compute largest prime less than n, also largest prime factor of n, took 15 min to code
import java.util.Scanner;
import java.util.Arrays;
class bigprime{
	public static int best;
	public static int largestfactor(int n){
		while(n%2==0){best = 2;n/=2;}
		for (int i = 3; i <= (int)(Math.sqrt(n)); i+=2){
			while(n%i==0){best = i;n/=i;}
		}
		if (n > 2){
			best = n;
		}
		return best;
	}
	public static void main(String[] args){
		Scanner console = new Scanner(System.in);
		int n = console.nextInt();
		final double startTime = System.currentTimeMillis();
		int temp,ans = 0;
		int original =n;n+=2;
		boolean tf;
		if (n%2==0){n--;}
		while(true){
			n-=2;temp = 3;tf = false;
				while (temp <= (int)(Math.sqrt(n)) && temp < n){
					if (n%temp == 0){tf = true;break;}
					temp+=2;
				}
				if (!tf){
					ans = n; 
					break;
				}
		}
		largestfactor(original);
		System.out.println(best);
		System.out.println(ans);
		final double endTime = System.currentTimeMillis();
		System.out.println(endTime-startTime);
	}
}