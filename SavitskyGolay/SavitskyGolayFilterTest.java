//application of Savitsky-Golay filters to reveal more about datasets. Took 45 min to code
import java.util.*;
import java.io.*;
import java.text.*;
import java.awt.*;
import java.lang.*;
import java.net.*;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.*;

class SavitskyGolayFilterTest{
	public static ArrayList<Integer> x = new ArrayList<Integer>();
	public static ArrayList<Double> y = new ArrayList<Double>();
	public static ArrayList<Double> fy = new ArrayList<Double>();
	public static int[][] filters = new int[12][9];
	public static void main(String[] args) throws Exception{
	    //initialize
	    int[] temp = {0, 0,-3,12,17,12,-3, 0, 0,0,-2, 3, 6, 7, 6, 3,-2, 0,-21,14,39,54,59,54,39,14,-21,0, 5,-30, 75,131, 75,-30, 5, 0,15,-55, 30,135,179,135, 30,-55,15,0, 0, 0,-1,0,1,0,0,0,0,0,-2,-1,0,1,2,0,0,0,-3,-2,-1,0,1,2,3,0,-4,-3,-2,-1,0,1,2,3,4,0,0,1,-8,0,8,-1,0,0,0, 22, -67, -58,0, 58, 67,-22, 0,86,-142,-193,-126,0,126,193,142,-86};
	    for (int i = 0; i < temp.length; i++){
	    	filters[i/9][i%9] = temp[i];
	    }
	    int[] scaling = {1,1,1,1,1,1,1,1,4,1,1,1,1}; 

	    //take input
		System.out.println("select Savitsky-Golay filter: ");
		System.out.println("smoothing");
		System.out.println(" quadratic or cubic");
		System.out.println("  0   {  0, 0,-3,12,17,12,-3, 0,  0}");
		System.out.println("  1   {  0,-2, 3, 6, 7, 6, 3,-2,  0}");
		System.out.println("  2   {-21,14,39,54,59,54,39,14,-21}");
		System.out.println(" quartic or quintic");
		System.out.println("  3   { 0,  5,-30, 75,131, 75,-30,  5, 0}");
		System.out.println("  4   {15,-55, 30,135,179,135, 30,-55,15}");
		System.out.println();
		System.out.println("1st derivative");
		System.out.println(" linear or quadratic");
		System.out.println("  5   { 0, 0, 0,-1,0,1,0,0,0}");
		System.out.println("  6   { 0, 0,-2,-1,0,1,2,0,0}");
		System.out.println("  7   { 0,-3,-2,-1,0,1,2,3,0}");
		System.out.println("  8   {-4,-3,-2,-1,0,1,2,3,4}");
		System.out.println(" cubic or quartic");
		System.out.println("  9   { 0,   0,   1,  -8,0,  8, -1,  0,  0}");
		System.out.println("  10  { 0,  22, -67, -58,0, 58, 67,-22,  0}");
		System.out.println("  11  {86,-142,-193,-126,0,126,193,142,-86}");
		// select filter
		System.out.print("Enter an integer 0 - 11 corresponding to desired filter: ");
		Scanner console = new Scanner(System.in);
		int key = console.nextInt();
		System.out.println();

		int tempx;
		double tempy;
	    File f = new File("data.txt");
	    Scanner input = new Scanner(f);
	    while (input.hasNextLine()){
	       	tempx = input.nextInt();
	      	tempy = input.nextDouble();
	      	x.add(tempx);
	        y.add(tempy);
	  	}
	  	input.close();

	    //replace values 
	    for (int i = 0; i < 4; i++){
	    	fy.add(y.get(i));
	    }
	    for (int i = 4; i < y.size()-4; i++){
	    	double tempsum = 0;
	    	for (int j = 0; j < 9; j++){
	    		tempsum+=filters[key][j]*(y.get(i-4+j));
	    	}
	    	fy.add(tempsum);
	    }
	    for (int i = 4; i > 0; i--){
	    	fy.add(y.get(y.size()-i));
	    }

	    //draw
	    DrawingPanel frame = new DrawingPanel(800, 400);
	    Graphics g = frame.getGraphics();
	   	g.setColor(Color.WHITE);
	    for (int i = 0; i < x.size(); i++){
	    	tempx = x.get(i); tempy = y.get(i);
	    	g.fillOval((int)(tempx), 380-(int)(tempy), 2, 2);
	    }
	    for (int i = 0; i < fy.size(); i++){
	    	tempx = x.get(i); tempy = fy.get(i);
	    	g.fillOval((int)(tempx),380-(int)(scaling[key]*tempy),2,2);
	    }

	    //add tickmarks
	    g.setFont(new Font("TimesRoman", Font.PLAIN, 10)); 
	    for (int i = 0; i <= 33; i++){
	    	g.drawString("|",21+23*i,385);
	    	g.drawString(String.valueOf(1960+2*i),9+23*i,395);
	    }
	}
}