//computes radiant flux given wavelength, temperature, took 30 min to code
import java.util.Scanner;
import java.text.DecimalFormat;
class peeb1 {
  public static double hcOverK = 0.0143876515, hcsq = 1.19104292,lambda, temp,oneoverLT,eraised,B;
  public static void main(String[] args) {
     Scanner input = new Scanner(System.in);
     System.out.println("Radiant photon flux at a given wavelength");
     System.out.println("and temperature using Planck's Law.");
     System.out.print("wavelength in microns:");
     lambda = input.nextDouble();
     System.out.print("temperature in degrees Kelvin:");
     temp = 288;
     double micro2meter = Math.pow(10,-6);
     lambda*=micro2meter;
     oneoverLT = 1/(lambda*temp);
     eraised = Math.exp(hcOverK*oneoverLT);
     eraised--;
     eraised*=(Math.pow(10,16));
     eraised*=Math.pow(lambda,5);
     B = hcsq/eraised;
    DecimalFormat df1 = new DecimalFormat("0.00E00");
     //System.out.println("radiant flux B = " + df1.format(B).toLowerCase() + " Wm-3steradian-1");
      System.out.println("wavelength in microns: temperature in degrees Kelvin: radiant flux B = " + df1.format(B).toLowerCase() + " Wm-3steradian-1");
  }
}
