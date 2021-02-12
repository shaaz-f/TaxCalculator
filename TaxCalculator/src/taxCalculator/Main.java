package taxCalculator;

import java.util.Scanner;

public class Main {

	// Initializing variables.
	static String status;
	static double income;
	
	public static void main(String[] args) {
		
		System.out.print("ENTER NUMBER FOR STATUS\n1: Single\n2: Married\nENTER HERE: ");
		Scanner in = new Scanner(System.in); // New scanner to determine status.
		setStatus(in); // Method that sets the status, input the scanner.
		
		System.out.print("ENTER INCOME: ");
		Scanner in2 = new Scanner(System.in); // New scanner to determine income.
		setIncome(in2); // Method that sets the income, input the scanner.
		
		System.out.println("You owe $" + roundDouble(calculateTax()) + " in taxes.");
		// Print out the taxes owed, using the calculateTax method and the roundDouble method.
		
	}
	
	/**
	 * Calculates the tax depending on your status and income.
	 * @return the tax that you owe.
	 */
	private static double calculateTax()
	{
		if (status == "Single") // If the status was set to single when we called this.
		{
			if (income >= 32000) // If the set income is greater than or equal to 32000.
			{
				return (4400 + (income * .25));	 // Return the taxes owed.
			}
			else if (income >= 8000 && income < 32000) // If the set income is between 8000 and 32000.
			{
				return (800 + (income * .15));	// Return the taxes owed.
			}
			else if (income > 0) // Make sure that the income is over 0.
			{
				return (income * .1); // Return the taxes owed.
			}
		}
		else if (status == "Married") // If the status was set to married when we called this.
		{
			if (income >= 64000) // If the income set is greater than or equal to 64000.
			{
				return (8800 + (income * .25));	// Return the taxes owed.			
			}
			else if (income >= 16000 && income < 64000) // If the income set is between 16000 and 64000.
			{
				return (1600 + (income * .15)); // Return the taxes owed.
			}
			else if (income > 0) // Make sure that the income is over 0.
			{
				return (income * .1); // Return the taxes owed.
			}
		}
		return 0; // Safety precaution, if something wasn't already returned, return 0.	
	}
	
	/**
	 * Forces the user to input valid status.
	 * @param in scanner to use for input.
	 */
	private static void setStatus(Scanner in)
	{
		
		if (in.hasNextInt()) // If scanners next input is in fact an integer.
		{
			int input = in.nextInt(); // Put the integer input into a variable.
			if (input == 1) // If the input is 1, since it's the one of the two options we're accepting.
			{
				status = "Single"; // Since 1 is a valid input which represents the status being single, set the file-global status variable to Single.
				System.out.println("");
			}
			else if (input == 2) // If the input is 2, which is the other input we are accepting.
			{
				status = "Married"; // Set the status variable to married.
				System.out.println("");
			}
			else // If the input number isn't 1 or two.
			{
				System.out.print("\nENTER NUMBER FOR STATUS\n1: Single\n2: Married\nENTER HERE: ");
				setStatus(in); // Run the loop again, since we didn't get the input we were looking for.
			}
		}
		else
		{
			System.out.print("\nENTER NUMBER FOR STATUS\n1: Single\n2: Married\nENTER HERE: ");
			in.next(); // Get the next input. We need this because we aren't initializing the variable to clear the buffer.
			setStatus(in); // Repeat the loop, since we didn't get the input we were looking for.
		}
	}
	
	/**
	 * Forces the user to input valid income.
	 * @param in scanner to use for input.
	 */
	private static void setIncome(Scanner in)
	{
		if (in.hasNextDouble()) // If the scanners next input is in fact a double.
		{
			double input = in.nextDouble(); // Put the next input double into a variable.
			if (input >= 0) // If the double input is greater than or equal to zero (prevent negative income).
			{
				income = input; // Set the file-global variable to the input, since it's valid.
				System.out.println("");
			}
			else // If the double input is negative or other issues (unlikely).
			{
				System.out.print("\nENTER INCOME: ");
				setIncome(in); // Input isn't valid so run this method again.
			}
		}
		else // If the scanners next input isn't a double.
		{
			System.out.print("\nENTER INCOME: ");
			in.next(); // Get the next input. We need this because we aren't initializing the variable to clear the buffer.
			setIncome(in); // Input isn't valid so run this method again.
		}
	}
	
	/**
	 * Rounds a double to the nearest hundredth.
	 * @param toRound the double to be rounded.
	 * @return the rounded double.
	 */
	private static double roundDouble(double toRound)
	{
		double round = toRound * 100; // Multiply by 100 (so that the hundredth place can be rounded).
		round = Math.round(round); // Round the variable to the nearest whole.
		round = round / 100; // Divide by 100 (so that we can get the double to two decimal places).
		return round; // Return the rounded double.
	}
}
