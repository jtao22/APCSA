//find max sum that's less than target, took 5 min to code

import java.io.*; 
import java.util.*; 
import java.text.*;

class maxsum{
	public static int ans = -1;
	public static void maxsum(int[] arr, int target, int curr, int sum){
		if(sum > ans){ans = sum;}
		for (int i = curr; i < arr.length; i++){
			if(sum+arr[i] <= target){
				maxsum(arr,target,i+1,sum+arr[i]);
			}
		}
		return;
	}
	public static void main(String[] args){
		Scanner console = new Scanner(System.in);
		int n = console.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++){
			arr[i] = console.nextInt();
		}
		int target = console.nextInt();
		maxsum(arr,target,0,0);
		System.out.println(ans);
	}
}