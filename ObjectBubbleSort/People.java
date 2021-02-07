//Implementation of Bubble Sort on Objects, took 45 minutes to code
import java.io.*; 
import java.util.*; 
import java.text.DecimalFormat;
import java.text.NumberFormat;

class People extends Person{
	public static ArrayList<Person> arr = new ArrayList<Person>();
	public static ArrayList<String> peoplelist = new ArrayList<String>();
	public static ArrayList<Integer> sorted = new ArrayList<Integer>();
	public static void bSort(ArrayList<Person> arr) {
	    Person a = new Person();
	    Person b = new Person();
	    boolean tf = false;
	    while(!tf) {
	        tf = true;
	        for (int i = 0; i < arr.size()-1; i++) {
	            a = arr.get(i); b = arr.get(i+1);
	            if(a.mustswap(b)){
	            	arr.set(i+1,a);
	            	arr.set(i,b);
	            	tf = false;
	            }
	        }
	    }
	}

	public static void main(String[] args) throws IOException{
		Scanner inp = new Scanner (System.in);
		String input = inp.nextLine();
		String[] temp = new String[3];
		temp = input.split(" ");
		int count = 0;
		while(!temp[0].equals("stop")){
			Person p = new Person(temp[0],Integer.parseInt(temp[1]),Double.parseDouble(temp[2]));
			arr.add(p);
			sorted.add(count);
			input = inp.nextLine();
			temp = input.split(" ");
			count++;
		}
		Person out = new Person();  System.out.println("Original list: ");
		System.out.print("["); 
		if(arr.size() > 0){
			out = arr.get(0);out.printperson();
			for (int i = 1; i < arr.size(); i++){
				out = arr.get(i);
				System.out.print(", "); out.printperson();
			}
		}
		System.out.println("]");
		System.out.println("");
		System.out.println("Sorted list: ");
		System.out.print("[");
		if(arr.size() > 0){
			bSort(arr);
			out = arr.get(0); 
			 out.printperson();
			for (int i = 1; i < arr.size(); i++){
				out = arr.get(i);
				System.out.print(", "); out.printperson();
			}
		}
		System.out.println("]");
	}
}
