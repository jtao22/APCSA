//read in file and leave only the odd-lengthed words, took 15 min to code
import java.io.*; 
import java.util.*; 
import java.text.*;
class eremove{
	public static void main(String[] args) throws Exception{
		System.out.println("Removes strings of even length from an array.");
		System.out.print("Enter filename for file containing strings: ");
		ArrayList<String> list = new ArrayList<String>();
		Scanner input = new Scanner(System.in);
		String filename = input.nextLine();
		System.out.println("Enter two indices for range of odd words to be printed out: ");
		File file = new File(filename); 
		BufferedReader br = new BufferedReader(new FileReader(file)); 
		String s; 
		int count = 0;
		while ((s = br.readLine()) != null){
			String[] split = s.split(" ");
			for (int i = 0; i < split.length; i++){
				if(split[i].length() > 0){
					count++;
					if(split[i].length()%2!=0){
						list.add(split[i]);
					}
				}
			}
		}
		int start = input.nextInt(), end = input.nextInt();
		System.out.println("initial list.size(): " + count);
		System.out.println("final   list.size(): " + list.size());
		System.out.println("odd words from index " + start + " to " + end + ":");
		for(int i = start; i <= end; i++){
			System.out.println(list.get(i));
		}
	}
}