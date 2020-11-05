//prints a calendar given # days and date of first Sunday
import java.util.Scanner;
class calendar{
	public static int prevend;
	public static void week(){
		System.out.println("  Sun    Mon    Tue    Wed    Thu    Fri    Sat");
	}
	public static void topbottom(){
		System.out.println("+------+------+------+------+------+------+------+");
	}
	public static void firstweek(int begin){
		System.out.print("|");
		for (int i = 0; i < 7-begin+1; i++){
			System.out.print("      |");
		}
		for (int i = 1; i <= begin-1; i++){
			System.out.print("   " + i + "  |");
		}
		System.out.println("");
	}
	public static void day(int days, int begin){
		System.out.print("|");
		for (int i = begin; i <= days; i++){
			if (i <= 9){
				System.out.print(" ");
			}
			System.out.print("  " + i + "  |");
			if (i%7 == begin-1){
				prevend = i;
				if (prevend != days){
				System.out.println("");
				System.out.print("|");
				}
			}
		}
		if (prevend != days){
			for (int i = 0; i < prevend+7-days; i++){
				System.out.print("      |");
			}
		}
		System.out.println("");
	}
	public static void main(String[] args){
		Scanner console = new Scanner(System.in);
		System.out.println("");
		System.out.print("Please enter the number of days in the month: ");
		int days = console.nextInt();
		System.out.println("Please enter the number of the day of the first Sunday: ");
		int first = console.nextInt();

		week();
		topbottom();
		if (first != 1){
			firstweek(first);
			day(days,first);
		}
		else{
			day(days,first);
		}
		topbottom();
		System.out.println("");
	}
}