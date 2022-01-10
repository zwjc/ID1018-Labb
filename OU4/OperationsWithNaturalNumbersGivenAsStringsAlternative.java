import java . util .*; // Scanner
import static java . lang . System . out ;

public class OperationsWithNaturalNumbersGivenAsStringsAlternative {

	public static void main ( String [] args )
	{
		out . println ( " OPERATIONS ON NATURAL NUMBERS " +
				" IN CHARACTER STRINGS " );
		// enter two natural numbers
		Scanner in = new Scanner ( System . in );
		in.useLocale(Locale.US);
		out . println ( " two natural numbers : " );
		String tal1 = in . next ();
		String tal2 = in . next ();
		out . println ();
		// add the numbers and show the result
		String sum = add ( tal1 , tal2 );
		show(tal1, tal2, sum, '+');


		String diff = subtract ( tal1 , tal2 );
		show(tal1, tal2, diff, '-');


		in.close();
	}
	// The add method accepts two natural numbers represented
	// as character strings and returns their sum as a
	// character string .
	public static String add ( String num1 , String num2 )
	{
		StringBuilder a = new StringBuilder (num1);
		StringBuilder b = new StringBuilder (num2);
		StringBuilder sum = new StringBuilder ("");
		int carry = 0;
		int sumOfDigits = 0;


		while (a.length() > b.length())
		{
			b.insert(0, 0);		//b inserts 0 to match the length of a.length 10 - 100 - 1000
		}

		while (a.length() < b.length())
		{
			a.insert(0, 0);
		}
		//actual string length (17 = 1 to 16)
		for (int i = a.length() - 1; i > -1; i--)
		{
			sumOfDigits = carry + (a.charAt(i)-48) + (b.charAt(i)-48);
			sum.insert(0, sumOfDigits % 10); //r = 7,, 7 placed at position of sum
			carry = sumOfDigits / 10;
		}

		if (carry == 1) //when last carry == 1
		{
			sum.insert(0, 1); //if carry is 1 then replace 1 with 0
		}

		return sum.toString();

	}
	// The subtract method accepts two natural numbers
	// represented as character strings and returns their
	// difference as a character string .
	// The first number is not smaller than the second
	public static String subtract ( String num1 , String num2 )
	{
		StringBuilder minuend = new StringBuilder (num1);
		StringBuilder subtrahend = new StringBuilder (num2);
		StringBuilder difference = new StringBuilder ("");
		int diffOfDigits = 0;

		while (minuend.length() > subtrahend.length())
		{	
			subtrahend.insert(0, 0);
		}

		for (int i = minuend.length() - 1; i > -1 ; i--)
		{
			if (minuend.charAt(i) - 48 >= subtrahend.charAt(i) - 48) //if num1>num2
			{
				difference.insert(0, 
						(minuend.charAt(i) - 48) - (subtrahend.charAt(i) -48)); //insert their difference at position 0
			}

			else
			{
				diffOfDigits = 10 + (minuend.charAt(i) - 48) - (subtrahend.charAt(i) - 48);
				difference.insert(0, diffOfDigits);

				minuend.setCharAt(i - 1, (char) (minuend.charAt(i - 1) - '1' + '0'));
			}
		}
		return difference.toString(); 
	}

	// The show method presents two natural numbers , an
	// operator and the result string .
	public static void show ( String num1 , String num2 ,
			String result , char operator )
	{
		// set an appropriate length on numbers and result
		int len1 = num1 . length ();
		int len2 = num2 . length ();
		int len = result.length ();
		int maxLen = Math . max ( Math . max ( len1 , len2 ) , len );
		num1 = setLen ( num1 , maxLen - len1 );
		num2 = setLen ( num2 , maxLen - len2 );
		result = setLen ( result , maxLen - len );
		// show the expression
		out . println ( "   " + num1 );
		out . println ( " " + operator + " " + num2 );
		for ( int i = 0; i < maxLen + 3; i ++)
			out . print ( "-" );

		out . println ();
		out . println ( "   " + result + "\n " );
	}
	// The setLen method prepends the supplied number of
	// spaces onto the beginning of a string
	public static String setLen ( String s , int nofSpaces )
	{
		StringBuilder sb = new StringBuilder (s);
		for ( int i = 0; i < nofSpaces ; i ++)
			sb . insert (0 , " " );

		return sb . toString ();


	}

}


