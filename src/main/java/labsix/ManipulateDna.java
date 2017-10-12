package labsix;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

/** This class manipulates the DNA string for bioinformatics.
 *  author @Devin Ho
**/

public class ManipulateDna {
  /** The main entry point for ManipulateDna.
   *  The source code inside of this method is executed when the program runs in the command line. 
   *  The output of this program will appear in the terminal window.
   *  The printline statements will display the outputs.
  **/
 
  public static void main(String[] args) {
    // display the name of the programmer and the date
    System.out.println("Devin Ho " + new Date());
    // declare the starting file and scanner
    File dnaInputsFile = null;
    Scanner scanner = null;
    // connect the scanner to the input file
    try {
      dnaInputsFile = new File("input/dna_inputs.txt");
      scanner = new Scanner(dnaInputsFile);
    } catch (FileNotFoundException noFile) {
      System.out.println("Unable to locate file");
    }
    // Step One: Read in and display the chosen DNA string
    String dna = scanner.nextLine();
    System.out.println("Okay, I am going to manipulate the DNA string " 
        + "\"" + dna + "\"" + ".");
    System.out.println();
    System.out.println("Enter a string containing only C, G, T, and A: " + dna.toUpperCase());
    // Step Two: Compute the complement of the DNA String
    String dnaUp = dna.toUpperCase();
    String p1 = dnaUp.replace('A', 't');
    String p2 = p1.replace('T', 'a');
    String p3 = p2.replace('C', 'g');
    String p4 = p3.replace('G', 'c');
    System.out.println("The complement of ACTG is " + p4.toUpperCase());

    // Step Three: Insert a randomly chosen DNA letter into the DNA String
    Random generator = new Random();
    int num1 = generator.nextInt(4);
    char insertion = "ACTG".charAt(num1);

    String result1 = insertion + p4.toUpperCase();
    System.out.println("Inserting " + insertion + " at position 0 gives " + result1);

    // Step Four: Delete a DNA letter from a randomly chosen position in the DNA string
    int num2 = generator.nextInt(dna.length());
    String insertion2 = dna.substring(0, num2);
    String deletion = dna.substring(num2 + 1);
    System.out.println("Deleting from position " + num2 + " gives " 
        + (insertion2 + deletion).toUpperCase());
    
    // Step Five: Change a random position in the DNA String to a randomly chosen DNA letter
    int num3 = generator.nextInt(4);
    int num4 = generator.nextInt(4);
    char addletter = "ACTG".charAt(num3);
    String s1 = dna.substring(0, num4) + addletter + dna.substring(num4 + 1);
    System.out.println("Changing position " + num4 + " gives " + (s1.toUpperCase()));
    // Step Six: Display a final thankyou message
    System.out.println();
    System.out.println("Thanks for using the ManipulateDna program.\nHave an awesome day.");
  }

}
