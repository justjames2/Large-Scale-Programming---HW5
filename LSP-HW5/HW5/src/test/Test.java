package test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import classes.java.*;

public class Test//(Main)
{	/**Main driver class for the program
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException
	{
		BufferedReader input = new BufferedReader(new FileReader("src/resources/input.txt"));
		int coefficient, exponent;								// BufferedReader to take input from text files
		while(input.ready())									// Loop while there is an input to take
		{
			BufferedReader operations = new BufferedReader(new FileReader("src/resources/operation.txt"));
			String[] line = input.readLine().split(";");		// .split to show where each line ends
			Polynomial myPoly = new Polynomial();				// Declare instance of Polynomial
			String name = line[0];
			
			for(int i = 1; i < line.length; i += 2)				// +=2 to skip over the increments given for the 2 variables below
			{
				coefficient = Integer.parseInt(line[i]);
				exponent = Integer.parseInt(line[i + 1]);
				Term myTerm = new Term(coefficient, exponent);	// Creates new Term for each set of integers given from the .txt files
				myPoly.insert(myTerm);							// Creates new Polynomial for each Term
			}
			System.out.println("Polynomial " + name + ": ");
			
			while(operations.ready())							// Loop while there is an input to take
			{
				String read = operations.readLine();
				System.out.println(read);
				line = read.split(" ");
				if(line[0].equals("INSERT"))					// .equals() to compare two strings
				{												// For Insert operation
					Term newTerm = new Term(Integer.parseInt(line[1]), Integer.parseInt(line[2]));
					myPoly.insert(newTerm);
				}
				if(line[0].equals("DELETE"))					// For Delete operation
				{
					Term deleteTerm = new Term(Integer.parseInt(line[1]), Integer.parseInt(line[2]));
					myPoly.delete(deleteTerm);
				}
				if(line[0].equals("REVERSE"))					// For Reverse operation
				{
					myPoly.reverse();
				}
				if(line[0].equals("PRODUCT"))					// For Product operation
				{
					System.out.println(myPoly.getList());
				}
				System.out.println("");
			}
			operations.close();
			System.out.println("");
		}
		input.close();
//		testTerm();												// Used for test cases
//		testPolynomial();										// Used for test cases
	}
	
/* The following code was used for testing the Term & Polynomial class
	public static void termTesting()
	{
		System.out.print("Test Results: ");
		Term myTerm = new Term(2, 2);
		System.out.println(myterm.toString());
	}
	
	public static void polynomialTesting()
	{
		System.out.println("Polynomial test: ");
		
		String expression;
		Term myTerm1 = new Term(1, 3);
		Term myTerm2 = new Term(-3, 5);
		Term myTerm3 = new Term(5, 7);
		Term myTerm4 = new Term(-7, 11);
		Term myTerm5 = new Term(9, 7);
		Term myTerm6 = new Term(-11, 5);
		Term myTerm7 = new Term(13, 3);
		Term myTerm8 = new Term(1, 3);
		Polynomial myPolynomial = new Polynomial();
		myPoly.insert(myTerm1);
		myPoly.insert(myTerm2);
		myPoly.insert(myTerm3);
		myPoly.insert(myTerm4);
		myPoly.insert(myTerm5);
		myPoly.insert(myTerm6);
		myPoly.insert(myTerm7);
		
		expression = myPoly.getList();
		System.out.println("Array List: " + expression);
		
		int value = myPoly.getTotalValue();
		System.out.println("Value: " + value);
		
		myPoly.deleteTerm(myTerm8);
		expression = myPolynomial.getList();
		System.out.println("Array List after deleting: " + expression);
		
		myPolynomial.reverse();
		expression = myPolynomial.getList();
		System.out.println("Array List after reversing: " + expression);
	}*/
} // END
