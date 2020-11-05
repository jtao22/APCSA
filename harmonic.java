// computes amount of terms needed in harmonic series sum to reach a certain value, took 15 min to code
import java.util.Scanner;
import java.text.DecimalFormat;
class harmonic{
	/*public static double count=1.0,sum = 1.0;
	public static void harmonic(double inp, double sum, double count){
		while (sum <= inp){
			count++;
			sum += 1/(count);
		}
	}
	*/
	public static void main(String[] args){
		Scanner console = new Scanner(System.in);
		double inp = console.nextDouble();
		double sum = 1.0, count = 1.0;

		final double startTime = System.currentTimeMillis();
		while (sum <= inp){
			count++;
			sum += 1/(count);
		}
		final double endTime = System.currentTimeMillis();
		System.out.println("Total execution time: " + (endTime-startTime));
		DecimalFormat df = new DecimalFormat("#.#####");
		System.out.print("Actual sum = "); System.out.printf("%.16f%n", sum); 
		System.out.println("Number of terms required: " + (int)count);
	}
}