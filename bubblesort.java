//rudimentary bubble sort, took 10 min to code 
import java.io.*; 
import java.util.*; 
import java.text.*;

class bubblesort{
	public static int count = 0;
	public static void sort(int[] arr){
		System.out.print("[");
		System.out.print(arr[0]);
		for (int i = 1; i < arr.length; i++){
			System.out.print(", " + arr[i]);
		}
		System.out.println("]");
		for (int i = 1; i < arr.length; i++){
			if(arr[i] < arr[i-1]){
				count++;
				for (int j = i; j < arr.length; j++){
					if(arr[j] < arr[j-1]){
						int temp = arr[j];
						arr[j] = arr[j-1];
						arr[j-1] = temp;
					}
				}
				sort(arr);
				break;
			}
		}
		return;
	}
	public static void main(String[] args){
		Scanner console = new Scanner(System.in);
		int[] arr = new int[10];
		for (int i = 0; i < 10; i++){
			arr[i] = console.nextInt();
		}
		System.out.println("bubbleSort");
		sort(arr);
		System.out.println("");
	}
}
