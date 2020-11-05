//compute nth prime, took 20 min to code
import java.util.Scanner;
import java.util.Arrays;
class nthprime2{
	public static void main(String[] args){
		Scanner console = new Scanner(System.in);System.out.print("enter integer n for nth prime (1st prime = 2): ");
		int n = console.nextInt();
		final double startTime = System.currentTimeMillis();
		int count = 1,temp,i=1;
		boolean tf;
		if (n == 1){count=2;}
		else{
		while(i < n){
			count+=2;temp = 3;tf = false;
				while (temp <= (int)(Math.sqrt(count)) && temp < count){
					if (count%temp == 0){tf = true;break;}
					temp+=2;
				}
				if (!tf){i++;}
		}
		}
		System.out.println("Prime #" + n + " is " + count);		
	}
}