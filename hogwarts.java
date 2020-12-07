// Code for a hogwarts murder mystery, given 2 hours, finished in 25 minutes.  
import java.util.Scanner;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.File;
import java.text.DecimalFormat;
import java.text.NumberFormat;
class hogwarts{
	public static void swap(int[] arr){
		int itr = 1,temp1,temp2;
		while(itr <= arr.length-7){
			temp1 = arr[itr];
			temp2 = arr[itr+1];
			arr[itr] = arr[itr+4];
			arr[itr+1] = arr[itr+5];
			arr[itr+4] = temp1;
			arr[itr+5] = temp2;
			itr+=8;
		}
	}
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++){
			arr[i] = input.nextInt();
		}
		swap(arr);
		char[] sums = new char[n/4];
		int sum = 0;
		for (int i = 0; i < n; i++){
			sum+=arr[i];
			if ((i+1)%4==0){
				sums[(i+1)/4-1]= (char)sum;
				sum = 0;
			}
		}
		for (int i = 0; i < n/4; i++){
			System.out.print(sums[i]);
		}
		System.out.println();
	}
}