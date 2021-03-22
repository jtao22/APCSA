//selection sort, took 5 min

import java.io.*; 
import java.util.*; 
import java.text.*;

class SelectionSort{
	public static void main(String[] args){
		Scanner console = new Scanner(System.in);
		int[] arr = new int[10];
		for (int i = 0; i < 10; i++){
			arr[i] = console.nextInt();
		}
		System.out.println("selectionSort");
		for(int i = 0; i < 10; i++){
			int min = 1000000000,index=0;
			System.out.print("[" + arr[0]);
			for (int j = 1; j < 10; j++){
				System.out.print(", " + arr[j]);
			}
			System.out.println("]");
			for (int j = i; j < 10; j++){
				if(arr[j] < min){
					min = arr[j];
					index = j;
				}
			}
			int temp = arr[index];
			arr[index] = arr[i];
			arr[i] = temp;
		}
System.out.println("");
	}
}