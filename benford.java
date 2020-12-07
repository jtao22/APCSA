//Proof of benford's law, took 25 minutes to code
import java.util.Scanner;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.File;
import java.text.DecimalFormat;
import java.text.NumberFormat;
// ^including all necessary libraries^
class benford {
    public static int[] digcount = new int[10]; //digit count array
    public static void fd(int n){ // find first digit
        int ten = 1;
        while (ten*10 <= n){
            ten*=10;
        } //checking how large the number is (if it's 981, the variable 10 will become 100 and then 981/ten = 9)
        digcount[n/ten]++; //add one to the digit count of the first digit 
    }
    public static void printcountformat(int n){ // prints values with correct number of spaces
        int ten = 1;
        int digits = 1;
        while(ten*10 <= digcount[n]){ //same process as above, except this time we're working with the digit counts instead of the numbers
            ten*=10;
            digits++;
        }
        for (int i = 0; i < 5-digits; i++){ //max number of spaces is 5, if the number is single digit you want to print 4 spaces + number, if it is two digits you want 3 spaces + number, so on
            System.out.print(" ");
        }
        System.out.print(digcount[n]);

    }
    public static void main(String[] args) throws FileNotFoundException {
        DecimalFormat df = new DecimalFormat();
        df = new DecimalFormat("##.00");
        System.out.println("Let us count those leading digits...");
        Scanner input = new Scanner(System.in);
        System.out.print("input file name? ");
        String filename = input.next();
        int zerocount = 0,count = 0;
        Scanner scanner = new Scanner(new File(filename));
        int[] store =  new int[200000]; // ^ all the above is boiler-plate code + declaration of variables
        int itr = 0;
        while (scanner.hasNextInt()){
            store[itr++] = scanner.nextInt();
        } // storing all the integers into an array
        for (int i = 0; i < itr; i++){
            if (store[i] == 0){
                zerocount++; //checking for zeros
            }
            else{
                fd(store[i]); //computing first digit
            }
        }
        for (int i =1; i <= 9; i++){
            digcount[0]+=digcount[i];
        } //computing total legitimate values 
        if (zerocount > 0){
            System.out.println("excluding " + zerocount + " zeros");
        } //if there are zeros we want the user to know we've excluded them
        double percent;
        System.out.println("Digit Count Percent"); //print table heading
        for (int i = 1; i <= 9; i++){ //iterate through each digit 1-9
            System.out.print("    " + i + " "); //spacing formatting
            printcountformat(i); //calling the method that prints the right amount of  spaces
            percent = ((double)digcount[i]/(double)digcount[0]) * 100; // calc percent
            if (percent >= 10){ //if the percent is >= 10, it will have one more digit so we want to print one less space
                System.out.println("  " + df.format(percent)); //format
            }
            else{
                System.out.println("   " + df.format(percent)); //format
            } 
        } 
        //printing the last line of the table
        System.out.print("Total ");
        printcountformat(0);//total count was stored in 0th index
        System.out.println(" 100.00"); //percentages should add to 100 anyways
    }
}