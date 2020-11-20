//binary search java implementation, took 5 minutes to code
import java.util.Scanner;
import java.util.Arrays;
class binarysearch{
	public static boolean b_search(int[] arr, int val, int left, int right){
		if (right >= left){
			int mid = (right+left)/2;
		    if (arr[mid] == val){
		      System.out.println("value " + val + " found at index " + mid);
		      return true;
		    }
		    else{
		      if ( arr[mid] < val){
		        return b_search(arr,val,mid+1,right);
		      }
		        return b_search(arr,val,left,mid-1);
		    }
  		}
  		System.out.println("value " + val + " not found");
  		return false;
	}
	public static void main(String[] args){
		Scanner console = new Scanner(System.in);
		System.out.print("Enter number of elements in array: ");
		int n = console.nextInt();
		int[] arr = new int[n];
		System.out.println("Enter " + n + " integers and the element to be searched: ");
		for (int i = 0; i < n; i++){
			arr[i] = console.nextInt();
		}
		int val = console.nextInt();
		boolean tf = b_search(arr,val,0,n-1);
	}
}