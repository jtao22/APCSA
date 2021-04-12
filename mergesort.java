//merge sort java implementation, took 15 min to code 
import java.io.*; 
import java.util.*; 
import java.text.*;

class mergesort{
	public static ArrayList<Integer> arr = new ArrayList<Integer>();
	public static ArrayList<Integer> mergesort(ArrayList<Integer> a){
		if(a.size() <= 1){
    		return a;
  		}
  		ArrayList<Integer>l = new ArrayList<Integer>(); 
  		ArrayList<Integer>r = new ArrayList<Integer>();
		 for(int i = 0; i < a.size()/2; i++){
		   l.add(a.get(i));
		 }
	 	for (int i = a.size()/2; i < a.size(); i++){
		   r.add(a.get(i));
		 }
  		ArrayList<Integer>lprime = mergesort(l); 
		ArrayList<Integer>rprime = mergesort(r); 
  		int lc = 0, rc = 0;
  		ArrayList<Integer>ans = new ArrayList<Integer>();
	  for(int i = 0; i < a.size(); i++){
	    if(rc == rprime.size() || (lc < lprime.size() && lprime.get(lc) < rprime.get(rc))){
	      ans.add(lprime.get(lc));
	      lc++;
	    }
    else{
      ans.add(rprime.get(rc));
      rc++;
    }
  }
  return ans;
	}
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			arr.add(input.nextInt());
		}
		System.out.println("mergeSort");
		System.out.println(arr);
		System.out.println(mergesort(arr));
	}
}