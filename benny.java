//benny the bunny challenge problem, I just bashed it out, took 45 minutes to code
import java.io.*; 
import java.util.*; 
import java.text.DecimalFormat;
import java.text.NumberFormat;
class benny {
	public static int[][][] grid = new int[100][100][3];
	public static boolean[][] visited = new boolean[100][100];
	public static int n;
	public static int hop(int i, int j, int c){
		visited[i][j] = true;
		if(i+grid[i][j][1] < 0 || i+grid[i][j][1] >= n || j+grid[i][j][0] < 0 || j+grid[i][j][0] >= n || visited[i+grid[i][j][1]][j+grid[i][j][0]]){
			return c+grid[i][j][2];
		}
		return hop(i+grid[i][j][1],j+grid[i][j][0],c+grid[i][j][2]);
	}
	public static void main(String[] args) throws IOException{
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter name of text file: ");
		String s = scan.nextLine().trim();
		File input = new File( s );      
    	Scanner inp = new Scanner( input );  
    	n = inp.nextInt();
		int ans = -1;
		for (int i = 0; i < 3; i++){
			for(int j = 0; j < n; j++){
				for (int k = 0; k < n; k++){
					grid[j][k][i] = inp.nextInt();
				}
			}
		}
		for (int i = 0; i < n; i++){
			for(int j = 0; j < n; j++){
				for (int x = 0; x < n; x++){
					for (int y = 0; y < n; y++){
						visited[x][y] = false;
					}
				}
				ans = Math.max(ans,hop(i,j,0));
			}
		}
		System.out.println(ans);
	}
}