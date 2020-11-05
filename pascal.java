// prints pascal's triangle up to 14 lines, took 20 min to code
import java.util.Scanner;
import java.util.Arrays;
class pascal{
	public static int n;
	public static int[] arr = new int[1000];
	public static int[] prevarr = new int[1000];


	public static void printpascal(int x){
		for (int i = 1; i <= x; i++){
			for (int space = 0; space < 2*(x-i); space++){
				System.out.print(" ");
			}
			for (int ind = 1; ind <= i; ind++){
				System.out.print(arr[ind]);
				if (ind < i){
				if (arr[ind+1]/10 == 0){
					System.out.print("   ");
				}
				else if (arr[ind+1]/100 == 0){
					System.out.print("  ");
				}
				else if (arr[ind+1]/1000 == 0) {
					System.out.print(" ");
				}
			}
				prevarr[ind] = arr[ind];
			}
			System.out.println();
			for (int j = 1; j <= i; j++){
				arr[j] = prevarr[j-1]+prevarr[j];
			}
			arr[i+1] = 1;
		}
	}
	public static void main(String[] args){
		Scanner console = new Scanner(System.in);
		int n = console.nextInt();
		arr[1] = 1;arr[0] = 0;arr[2] = 0;
		printpascal(n);
	}
}