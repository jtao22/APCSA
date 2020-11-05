// java implemenation of Stefamn-Boltzman Law, took 20 min to code
import java.util.Scanner;
class peeb2 {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        double sbc = 5.6704, rs = 7, /*au = 150000000000,*/ ss = 6.42, dp, rp, alpha,sp,save,save2,tk;
        String name;
        System.out.println("Calculate radiant power per unit area for Sun and Planet using");
        System.out.println("Stefan-Boltzman Law. From balance equation for Planet,");
        System.out.println("(Power in) = (Power out), predict temperature of Planet.");
        System.out.print("Planet: ");
        name = console.nextLine();
        System.out.print("distance of Planet from Sun (AU): ");
        dp = console.nextDouble();
        dp*=1.5;
        System.out.print("radius of Planet (km): ");
        rp = console.nextDouble();
        rp*=1000;
        System.out.print("albedo of Planet: ");
        alpha = console.nextDouble();
        sp = 314.58/(dp*dp)*10;
        save = sp/4;
        save2 = save*(1-alpha);
        tk = Math.sqrt(Math.sqrt(save2/sbc))*100;
        System.out.println("photon flux SP = "+(int)Math.round(sp));
        System.out.println("average photon flux SAve = "+(int)Math.round(save));
        System.out.println("including albedo SAve x (1 - alpha) = "+(int)Math.round(save2));
        System.out.println("temperature TP (K) = " +Math.round(tk));
        System.out.println("temperature TP (C) = "+ Math.round(tk-273.15));
    }
}