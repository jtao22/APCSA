//used sweepline technique to solve n queens problem, took 35 min
import java.io.*; 
import java.util.*; 
import java.text.*;

class queens{
	public static int n;
	public static Boolean works(Boolean[] rows, Boolean[] cols, int row, int col, Boolean[][] queen){
		if(rows[row] || cols[col]){
			return false;
		}
		for (int i = row, j = col; i >= 0 && j >= 0; i--, j--){ 
            if (queen[i][j]){
                return false; 
            }
        }
		for (int i = row, j = col; j >= 0 && i < n; i++, j--){
            if (queen[i][j]){
                return false;
            }
		}
		return true;
	}
	public static void print(Boolean[][] queen){
		for (int i = 0; i < n; i++){
			for (int j = 0; j < n; j++){
				if(queen[i][j]){System.out.print("Q");}
				else{System.out.print("-");}
			}
			System.out.println();
		}
	}
	public static int total = 0;
	public static void solve(Boolean[][] queen, int col, int count, Boolean[] rows, Boolean[] cols){
		if(col == n){
			if(count == n && total < n){
				total++;
				print(queen);
				System.out.println("");
			}
			return;
		}
		for(int i = 0; i < n; i++){
			if (works(rows,cols,i,col,queen)){
				queen[i][col] = true; rows[i] = true; cols[col] = true;
				solve(queen,col+1,count+1,rows,cols);
				queen[i][col] = false; rows[i] = false; cols[col] = false;
			}
		}
	}
	public static void main(String[] args){
		System.out.println("This problem solves the classic 8 queens problem, placing queens on an NxN board such that no queens threaten each other.");
		Scanner input = new Scanner(System.in);
		System.out.print("Enter board size: ");
		n = input.nextInt();
		Boolean[] r = new Boolean[n];
		Boolean[] c = new Boolean[n];
		Boolean[][] queen = new Boolean[n][n];
		for (int i = 0; i < n; i++){
			for (int j = 0; j < n; j++){
				queen[i][j] = false;
			}
			c[i] = false;
			r[i] = false;
		}
		System.out.println("First " + n +" solutions: ");
		solve(queen,0,0,r,c);
	}
}