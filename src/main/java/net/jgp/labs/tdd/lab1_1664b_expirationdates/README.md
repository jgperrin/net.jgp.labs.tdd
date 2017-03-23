# Program 1664b - Expiration dates

**Program Description**:  Product expiration dates are often encoded to discourage consumers from complaining.  A common technique is to use letters instead of numbers to represent the dates.  Suppose that the _Really Slick Dairy Company_ encodes the months as the letters 'A' through 'L', each digit of the day's date as the letters 'Q' through 'Z' and the year as the letters 'Z" through 'A' plus 1970, where 'Z' represents 1, and 'A' is 26.  Days that would otherwise have only one digit are preceded by a zero.  Write a program that codes and/or decodes an expiration date.  A menu should contain three options for the user: 1) Code 2) Decode 3) Quit.

**Statements Required**:  input, output, loop control, decision making, class

Sample Output: 

	-----menu-----
	0) Quit
	1) Encode Date
	2) Decode Date
	Select an option 1
	enter date (m/d/y) 9/14/83
	The code is:  IQTN
	
	-----menu-----
	0) Quit
	1) Encode Date
	2) Decode Date
	Select an option 1
	enter date (m/d/y) 1/14/84
	The code is:  AQTM
	
	-----menu-----
	0) Quit
	1) Encode Date
	2) Decode Date
	Select an option 2
	IQTN
	The date is:  9/14/1983
	
	-----menu-----
	0) Quit
	1) Encode Date
	2) Decode Date
	Select an option 1
	enter date (m/d/y) 1/1/75
	The code is:  AOQV
	
	-----menu-----
	0) Quit
	1) Encode Date
	2) Decode Date
	Select an option 2
	AQTM
	The date is:  1/14/1984
	-----menu-----
	0) Quit
	1) Encode Date
	2) Decode Date
	Select an option 2
	AOQV
	The date is:  1/1/1975
	
	-----menu-----
	0) Quit
	1) Encode Date
	2) Decode Date
	Select an option 2
	KORH
	The date is:  11/2/1989
	
	-----menu-----
	0) Quit
	1) Encode Date
	2) Decode Date
	Select an option 0

