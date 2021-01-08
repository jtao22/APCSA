//lawnmoving problem 3x3 lawnmower floodfill took 80 minutes to code
import java.util.Scanner;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.File;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.*;
public class mow{
	public static char[][] lawn = new char[40][40];
	public static boolean[][] checked = new boolean[40][40];
	public static int[] di = new int[]{-1,-1,0,1,1,-1,1,0};
	public static int[] dj = new int[]{-1,0,-1,1,-1,1,0,1};
	public static int[] changei = new int[]{1,-1,0,0};
	public static int[] changej = new int[]{0,0,1,-1};
	public static int r,c;
	public static boolean canmove;
	public static void fill(int i, int j){
		checked[i][j] = true;
		lawn[i][j] = 'C';
		canmove = true;
		if(i+1 < r && i-1 >= 0 && j+1 < c && j-1 >= 0){
			for(int itr = 0; itr < 8; itr++){
				if (lawn[i+di[itr]][j+dj[itr]] == 'T'){
					canmove = false;
					break;
				}
			}

			if(canmove){
				for(int itr = 0; itr < 8; itr++){
					lawn[i+di[itr]][j+dj[itr]] = 'C';
				}				
				for (int itr = 0; itr < 4; itr++){
					if(lawn[i+changei[itr]][j+changej[itr]] != 'T' && !checked[i+changei[itr]][j+changej[itr]]){
						fill(i+changei[itr],j+changej[itr]);
					}
				}
			}
		}
	}
	public static void main(String[] args){
       DecimalFormat df = new DecimalFormat();
       df = new DecimalFormat("0.0");
       Scanner input = new Scanner(System.in);
       int n = input.nextInt();
       int starti,startj;
       String s;
       for (int itr = 0; itr < n; itr++){
       		r = input.nextInt();
       		c = input.nextInt();
       		starti = input.nextInt();
       		startj = input.nextInt();
       		s = input.nextLine();
       		for (int i = 0; i < r; i++){
       			s = input.nextLine(); 
       			for (int j = 0; j < s.length(); j+=2){
       				lawn[i][j/2] = s.charAt(j);
       			} 
       			for(int j = 0; j < c; j++){
       				checked[i][j] = false;
       			} 
       			
       		}
       		fill(starti,startj);
       		System.out.println();
       		for(int i = 0; i < r; i++){
       			for(int j = 0; j < c; j++){
       				System.out.print(lawn[i][j] + " ");
       			}
       			System.out.println("");
       		}
       }
	}
}