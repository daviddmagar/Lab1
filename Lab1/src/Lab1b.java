
/**
 * CS 2003 - Lab 1. Code to compute the average of doubles from an input
 * file.  NOTE: add data members and methods at your convenience. Use
 * the most accurate data types. You can reuse bits of code from
 * the class Lab1a.
 *
 * @author David Magar
 * @version 1.1
 * @since 08-30-2017
 */

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;

public class Lab1b {

	// data members
	Vector<Double> dblVector;

	/**
	 * Constructor: calls method readFile that reads the doubles contained in the
	 * file "<code>filename</code>" and computes the average of the elements.
	 * 
	 * @param filename
	 *            name of the file containing doubles.
	 */
	public Lab1b(String filename) {
		readFile(filename);
	}

	/**
	 * Reads double from a file named <code>filename</code> and computes the average
	 * of the elements contained in the file
	 * 
	 * @param filename
	 *            name of the file containing the doubles
	 */
	public void readFile(String filename) {
		/**
		 * Creates a file objects from the filename variable passed, creates a scanner, 
		 * reads doubles from file, computes average of doubles and prints it to the console.
		 * 
		 * @param filename
		 * 		 		String containing the path to file containing the doubles
		 */
		try {
			File inputFile = new File(filename);
			Scanner input = new Scanner(inputFile);
			dblVector = new Vector<Double>(); //Vector containing each double from the file
			double value = 0;	//Double that temporarily holds each double in the file, one at a time
			double total = 0;	//Double that has each value added to it  
			int counter = 0;	//Integer that serves as a counter used as the quotient to find the average
			while (input.hasNextDouble()) {	//Reads each double in the file, and saves it to respective locations
				value = input.nextDouble();
				dblVector.addElement(value);
				total += value;
				counter++;
			}
			System.out.printf("There are %d elements in the file.\n", counter);
			double average = (total / counter);	//Double that holds the average of the doubles
			System.out.printf("The numbers in the file are: ");
			for (double dbl : dblVector)
				System.out.printf("%f ", dbl);
			System.out.println();
			System.out.printf("The average is: %f", average);
			input.close();
		} catch (IOException e) {
			System.err.println("IOException in reading input file!!!");
		}

	} // end readFile()

	/**
	 * main : creates a Lab1b Object with the filename passed in argument
	 */
	public static void main(String args[]) {
		new Lab1b("src/Lab1b.dat");
	} // end main

} // end class Lab1b
