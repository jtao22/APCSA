// input file name output word count, took 15 minutes to code
import java.util.Scanner;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.File;
class readfile {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(System.in);
        String filename = input.next();
        File f = new File(filename);
        Scanner input2 = new Scanner(f);
        System.out.print("Enter name of text file, e.g. Iliad.txt: ");
        int count = 0;
        while (input2.hasNext()){input2.next();count++;}
        System.out.println("Total words = " + count);
    }
}
