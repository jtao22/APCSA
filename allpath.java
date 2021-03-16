import java.io.*; 
import java.util.*; 
// find all paths from origin to given point, took 15 minutes to code 
import java.text.*;

class allpath{
	public static int x,y,count=0;
	public static int[] dx = new int[]{0,1,1};
	public static int[] dy = new int[]{1,1,0};
	public static String[] ds = new String[]{"N","NE","E"};
	public static void paths(int currx, int curry, String s){
		if(currx == x && curry == y){
			System.out.println("moves:" + s);
			count++;
			return;
		}
		s+=" ";
		for (int i = 0; i < 3; i++){
			int tempx = currx+dx[i], tempy = curry+dy[i];
			if(tempx <= x && tempy <= y){
				paths(tempx,tempy,s + ds[i]);
			}
		}
	}
	public static void main(String[] args){
		System.out.println("Enter (x, y) coordinates as two integers separated by a space: ");
		Scanner input = new Scanner(System.in);
		x = input.nextInt(); y = input.nextInt();
		paths(0,0,"");
		System.out.println("Number of paths = " + count);
	}
}