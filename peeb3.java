// computes dimensions of Earth, ppmw of CO2 in atmosphere, etc. took 1 hour to code
import java.util.Scanner;
import java.util.Arrays;
class peeb3{
	public static final double eradm = 3959,atpres = 14.7,ppmv = 440/1000000,mm = 44,co2fplbs = 8000;
	public static void main(String[] args){
		

		/* Table 1 */
		System.out.println("Table 1 Values Below:");

		//compute Earth's Surface Area
		double esurfm = Math.PI*Math.pow(eradm,2)*4; //mi^2
		double esurfi = esurfm*Math.pow(5280*12,2); //in^2
		System.out.println("Earth surface area in sq mi: " + esurfm);
		System.out.println("Earth surface area in sq in: " + esurfi);

		//compute Atmosphere's weight (atpres = lbs/in^2)
		double atweightlbs = esurfi*atpres; //lbs
		double atweightg = atweightlbs*435.592; // g (1 lb = 435.592g)
		double atweighttons = atweightlbs/2000; // tons (1 ton = 2000 lbs)
		System.out.println("Weight of atmosphere in lb: " + atweightlbs);
		System.out.println("Weight of atmosphere in tons: " + atweighttons);

		//compute ppmw for CO2 (since we know D = m/v, v = m/D, we can substitute into the ppmv value)
		double co2density = 1.977; double atmosdensity = 0.21*1.429+0.78*1.251;// g/L
		double ppmw = (440*co2density)/(1000000*atmosdensity);
		
		//compute co2weight using ppmw
		double co2weightlbs = ppmw*atweightlbs; // lbs
		double co2weighttons = co2weightlbs/2000; // lbs
		System.out.println("2015 CO2 Concentration ppmw: " + ppmw);
		System.out.println("2015 CO2 Concentration in %weight: " + (co2weightlbs/atweightlbs)*100 + "%");	
		System.out.println("2015 CO2 weight in lbs: " + co2weightlbs);
		System.out.println("2015 CO2 weight in tons: " + co2weighttons);
		
		// compute third line of table 
		double co2fppptons = 4, co2fppplbs = 8000;
		double anthro = 7.3*Math.pow(10,9)*co2fppptons;
		double anthropercent = anthro/co2weighttons;
		System.out.println("2015 annual carbon footprint per person in tons CO2: " + co2fppptons);
		System.out.println("2015 annual anthropomorphic CO2 equivalent in tons: " + anthro);
		System.out.println("Anthropomorphic fraction of total CO2 per year: " + anthropercent*100 + "%");
		System.out.println("");


		/* Table 2 */
		System.out.println("Table 2 Values Below:");

		//compute 1750 weight
		double oldppmw = (280*co2density)/(1000000*atmosdensity);
		double oldco2weightlbs = oldppmw*atweightlbs;
		double oldco2weighttons = oldco2weightlbs/2000;
		double co2weightgaintons = co2weighttons-oldco2weighttons;
		System.out.println("2015 CO2 weight in tons: " + co2weighttons);
		System.out.println("1750 CO2 weight in tons: " + oldco2weighttons);
		System.out.println("CO2 weight gain in tons: " + co2weightgaintons);

		//computing absorption capacity
		double halfabsorb = 0.5*7.3*Math.pow(10,9);
		double doubabsorb = 2*7.3*Math.pow(10,9);
		System.out.println("CO2 absorption capacity per year (1/2): " + halfabsorb);
		System.out.println("CO2 absorption capacity per year (2/1): " + doubabsorb);

		//computing time needed
		double halftime = co2weightgaintons/halfabsorb;
		double doubtime = co2weightgaintons/doubabsorb;
		System.out.println("Time to lose weight (1/2): " + halftime);
		System.out.println("Time to lose weight (2/1): " + doubtime);
		System.out.println("");


		/* Table 3 */
		System.out.println("Table 3 Values Below:");

		//computing interest
		double c2015 = 400, c1900 = 280, n = 115;
		double r = Math.pow(c2015/c1900,1/n);r--;
		System.out.println("Average CO2 \"interest rate\" since 1900: " + r*100 + "%");

		//computing 20/50 year compound
		double compound20 = Math.pow(1.0082,20);
		double compound50 = Math.pow(1.0082,50);
		System.out.println("Estimated compounding of CO2 emissions over next 20 years @ 0.82% (2015 level): " + (compound20-1)*100 + "%");
		System.out.println("Estimated compounding of CO2 emissions over next 50 years @ 0.82% (2015 level): " + (compound50-1)*100 + "%");
	}	 
}