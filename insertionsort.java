//insertion sort java implementation, took 10 min to code 
import java.io.*; 
import java.util.*; 
import java.text.*;

class insertionsort{
	public static ArrayList<Integer> arr = new ArrayList<Integer>();
	public static void insertionsort(ArrayList<Integer> a){
		int temp, index;
		for (int i = 0; i < a.size(); i++){
			temp= a.get(i); index = i-1;
			while(index>=0 && a.get(index) > temp){
				arr.set(index+1,arr.get(index));
				index--;
			}
			arr.set(index+1,temp);
			System.out.println(arr);
		}
		return;
	}
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			arr.add(input.nextInt());
		}
		System.out.println("insertionSort");
		insertionsort(arr);
		System.out.println();
	}
}