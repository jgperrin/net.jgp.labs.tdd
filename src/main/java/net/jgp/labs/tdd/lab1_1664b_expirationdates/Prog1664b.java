/* Programmer: Pierre-Nicolas Perrin
 * Program: Prog607a
 * 
 * Date: 01/06/2017
 * School: Carrboro High School
 * 
 * Description: The program reads the date for encoding it into the letter code, or reads the
 * code and outputs the correct date for it. It stops whenever the user want (begining, end).
 * What I learned: Method-making, object-centered java, decision making, return statement, 
 * while loops, throwing exceptions, handling expressions, Scanner objects, constructors,
 * string array, void methods.
 */

package net.jgp.labs.tdd.lab1_1664b_expirationdates;

//imports
import java.util.Scanner;

public class Prog1664b {
	public static void main(String[] args) {

		//launch the Prog607a constructor
		Prog1664b app = null;
		app = new Prog1664b();

		//launch the method code for decoding/encoding
		app.start();
	}

	// the private void method code contains the necessary used inside for encoding/encoding (main structure)
	private void start() {

		//Declare local variables
		String answerChoice;
		String answerContinue;
		String inputToProcess;
		boolean stopLoop = true;
		
		// Declare Scanner object
		Scanner scan = new Scanner(System.in);

		while (stopLoop = true) {
			
			//print the following as grid-like output (and the choice user makes) and ask user for function necessary
			System.out.println("----menu----");
			System.out.print("0) Quit\n1) Encode Date\n2) Decode Date\nSelect an option: ");

			//the answerChoice is the 
			answerChoice = scan.next();

			//if the answer is 0
			if (answerChoice.equals("0")) {
				//quit program
				System.exit(0);
			}

			//if the answer is 1
			if (answerChoice.equals("1")) {
				//ask for the date
				System.out.print("Enter date (m/d/y) ");
				//input to process is input from user
				inputToProcess = scan.next();
				//use the encode method on input to process
				System.out.println("The code is " + encode(inputToProcess));
			}

			//if the answer is 2
			if (answerChoice.equals("2")) {
				//ask for the code
				System.out.print("Enter code: ");
				//input to process is the input from user
				inputToProcess = scan.next();
				//use the decode method on input to process
				System.out.println("The date is: " + decode(inputToProcess));
			}
			//ask to continue
			System.out.print("Do you want to continue (Y/N): ");
			//the input is answerContinue
			answerContinue = scan.next();

			//if the answer is a yes (Y)
			if (answerContinue.equals("Y")) {
				//stop loop is true
				stopLoop = true;
				//go to next line
				System.out.println();
			}
			//if the answer is no (N)
			if (answerContinue.equals("N")) {
				//stop loop is false
				stopLoop = false;
			}
		}
	}

	//public string encode method for encoding parameter (String dateAsString)
	public String encode(String dateAsString) {

		//create an array of split elements from the date between "/"
		String[] dateElements = dateAsString.split("/");

		//integer month is the integer from the first array item
		int month = Integer.parseInt(dateElements[0]);
		
		//if the month is less than 1 or more than 12
		if (month < 1 || month > 12) {
			//throw new NumberFormatException
			throw new NumberFormatException("Month should be between 1 and 12, " + month + " was provided");
		}
		//integer day is the second array item integer
		int day = Integer.parseInt(dateElements[1]);
		//if the day is less than 1 or more than 31
		if (day < 1 || day > 31) {
			//throw new NumberFormatException
			throw new NumberFormatException("Day should be between 1 and 31, " + day + " was provided");
		}
		//integer year is the third array item integer
		int year = Integer.parseInt(dateElements[2]);
		//if the year is less than 71 or more than 96
		if (year < 71 || year > 96) {
			//throw new NumberFormatException
			throw new NumberFormatException("Year should be between 71 and 96, " + year + " was provided");
		}

		//the code is then transformed to be with letters based on each digit and year (character ASCII arithmetic)
		String code = Character.toString((char) (month - 1 + 'A'));
		//for day (first digit)
		//if the day is more than 9
		if (day > 9)
			//code is added the character resulted for following
			code += Character.toString((char) (day / 10 - 1 + 'Q'));
		//if day is less than 9
		if (day < 9)
			//code is added 0
			code += "0";
		//for day (second digit)
		code += Character.toString((char) (day % 10 - 1 + 'Q'));
		//for year (character arithmetic)
		code += Character.toString((char) ('Z'- (year-70) +1));

		//go to next line
		System.out.println();

		//return the following
		return  code;
	}

	//public String decode for decoding parameter (String code)
	public String decode(String code) {

		//if the first character is less than A or more than L
		if (code.charAt(0) < 'A' || code.charAt(0) > 'L') {
			//throw new NumberFormatException
			throw new NumberFormatException("The character should be between A and L, " + code.charAt(0) + " was provided");
		}
		//if the second character is less than Q or more than S and not 0
		if ((code.charAt(1) < 'Q' || code.charAt(1) > 'S') && code.charAt(1) != '0') {
			//throw new NumberFormatException
			throw new NumberFormatException("The character should be between Q and Z, " + code.charAt(1) + " was provided");
		}
		//if the third character is less than Q or more than Z
		if (code.charAt(2) < 'Q' || code.charAt(2) > 'Z') {
			//throw new NumberFormatException
			throw new NumberFormatException("The character should be between Q and Z, " + code.charAt(2) + " was provided");
		}
		//if the last character is less than A or more than Z
		if (code.charAt(3) < 'A' || code.charAt(3) > 'Z') {
			//throw new NumberFormatException
			throw new NumberFormatException("The character should be between A and Z, " + code.charAt(3) + " was provided");
		}

		//string date
		String date;
		String x = "";
		//date is the first digit as the month (character arithmetic)
		date = Integer.toString((int)(code.charAt(0) -'A'+1)) + "/";

		//if the second character is not 0
		if (code.charAt(1) != '0') {
			//print the day for each digit and add them together
			date += Integer.toString((int)((code.charAt(1) -'Q' +1)*10 + code.charAt(2) -'Q' +1));
		}
		//if the code at second character is 0
		if ((code.charAt(1) == '0')) {
			//then print only the date for days at one digit (3rd code letter)
			date+= Integer.toString((int)(code.charAt(2) -'Q' +1));
		}
		//date is added /19 and add the correct year (character arithmetic)
		date += "/19" + Integer.toString((int)('Z'-code.charAt(3) +70 +1));
		//return the date 
		return date;
	}
}

/* Sample Output
----menu----
0) Quit
1) Encode Date
2) Decode Date
Select an option: 2
Enter code: IQTN
The date is: 9/14/1983
Do you want to continue (Y/N): Y

----menu----
0) Quit
1) Encode Date
2) Decode Date
Select an option: 1
Enter date (m/d/y) 1/1/75

The code is A0QV
Do you want to continue (Y/N): N

----menu----
0) Quit
1) Encode Date
2) Decode Date
Select an option: 2
Enter code: AQTM
The date is: 1/14/1984
Do you want to continue (Y/N): Y

----menu----
0) Quit
1) Encode Date
2) Decode Date
Select an option: 1
Enter date (m/d/y) 9/14/83

The code is IQTN
Do you want to continue (Y/N): N

----menu----
0) Quit
1) Encode Date
2) Decode Date
Select an option: 1
Enter date (m/d/y) 1/14/84

The code is AQTM
Do you want to continue (Y/N): Y

----menu----
0) Quit
1) Encode Date
2) Decode Date
Select an option: 2
Enter code: A0QV
The date is: 1/1/1975
Do you want to continue (Y/N): Y

----menu----
0) Quit
1) Encode Date
2) Decode Date
Select an option: 2
Enter code: K0RH
The date is: 11/2/1989
Do you want to continue (Y/N): Y

----menu----
0) Quit
1) Encode Date
2) Decode Date
Select an option: 0

*/