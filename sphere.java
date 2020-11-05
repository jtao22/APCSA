import java.util.Scanner;
import java.text.DecimalFormat;
class sphere{
	public static Double a = 0.0, b = 0.0;
    public static void concat (String s){
        a = 0.0; b =0.0;
        int split = s.indexOf(" ");
        String sub1 = s.substring(0, split);
        String sub2 = s.substring(split+1, s.length());
        int temp;
        char c;
        int zero = 0;
        if(sub1.indexOf("-") == 0){
            zero = 1;
        }
        for(int i = sub1.length()-1; i >=zero; i--){
            c = sub1.charAt(i);
            temp = (int)c-48;
            a+= temp*Math.pow(10, sub1.length()-i-1);
        }
        if(sub1.indexOf("-") == 0){
            a*=-1;
        }
        zero = 0;
        if(sub2.indexOf("-") == 0){
            zero = 1;
        }
        for(int i = sub2.length()-1; i >=zero; i--){
            c = sub2.charAt(i);
            temp = (int)c-48;
            b+= temp*Math.pow(10, sub2.length()-i-1);
        }
        if(sub2.indexOf("-") == 0){
            b*=-1;
        }
    }

	public static double lat1,lat2,long1,long2,lat1deg, lat1min, lat2deg,lat2min,long1deg,long1min,long2deg,long2min;
    public static void main(String[] args) {
        
        Scanner console = new Scanner(System.in);
        System.out.println();
        System.out.println("This program computes the spherical distance");
        System.out.println("between two points, 1 and 2");
        System.out.println("");
        System.out.println("Please enter the latitude and longitude for");
        System.out.println("each point as a pair of integers, degrees");
        System.out.println("followed by minutes:");
        System.out.println("");


        System.out.print("latitude 1: ");
        String lat1s = console.nextLine();
        concat(lat1s);
        lat1deg = a;
        lat1min = b;
 
        System.out.print("longitude 1: ");
        String long1s = console.nextLine();
        concat(long1s);
        long1deg = a;
        long1min = b;
        System.out.println("");

        System.out.print("latitude 2: ");
        String lat2s = console.nextLine();
        concat(lat2s);
        lat2deg = a;
        lat2min = b;

        System.out.print("longitude 2: ");
        String long2s = console.nextLine();
        concat(long2s);
        long2deg = a;
        long2min = b;
        System.out.println("");
		

        lat1 = Math.toRadians(lat1deg + lat1min/60);
        lat2 = Math.toRadians(lat2deg + lat2min/60);
        long1 = Math.toRadians(long1deg + long1min/60);
        long2 = Math.toRadians(long2deg + long2min/60);

        Double earthradkm = 6372.795,earthradmi = earthradkm*0.621371;
        Double angulardistance = angdist(lat1,long1,lat2,long2);
        DecimalFormat df = new DecimalFormat("0.00000");
		System.out.println("Angular distance = " +df.format(angulardistance).toLowerCase() + " radians");
		System.out.println("Distance = " + ((int)Math.round(angulardistance*earthradkm)) + " kilometers");
		System.out.println("Distance = " + ((int)Math.round(angulardistance*earthradmi)) + " miles");
		System.out.println("");
	}
	public static Double angdist(Double phi1, Double lam1, Double phi2, Double lam2){
		return Math.acos(Math.sin(phi1)*Math.sin(phi2)+Math.cos(phi1)*Math.cos(phi2)*Math.cos(lam2-lam1));
	}
}