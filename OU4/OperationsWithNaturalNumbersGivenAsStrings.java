import java . util .*; // Scanner
import static java . lang . System . out ;

class OperationsWithNaturalNumbersGivenAsStrings {

    public static void main(String[] args) {
        out.println(" OPERATIONS ON NATURAL NUMBERS " + " IN CHARACTER STRINGS ");
        // enter two natural numbers
        Scanner in = new Scanner(System.in);
        out.println(" two natural numbers : ");
        String num1 = in.next();
        String num2 = in.next();
        out.println();
        // add the numbers and show the result
        String sum = add(num1, num2);
        show(num1, num2, sum, '+');

        // subtract the numbers and show the result
        // *** WRITE YOUR CODE HERE ***
        String difference = subtract(num1, num2);
        show(num1, num2, difference, '-');
    }

    // The add method accepts two natural numbers represented
    // as character strings and returns their sum as a
    // character string .
    public static String add(String num1, String num2) {
        //Make sure numbers are in the correct format for addition

        int carry = 0;
        int sum = 0;
        StringBuilder answer = new StringBuilder();

        // format
        if (num1.length() > num2.length()) {
            num2 = sameLength(num1, num2);
        } else if (num2.length() > num1.length()) {
            num1 = sameLength(num2, num1);
        }

        for (int i = num1.length() - 1; i >= 0; i--) {
            int value1 = Character.getNumericValue(num1.charAt(i));
            int value2 = Character.getNumericValue(num2.charAt(i));

            sum = carry + value1 + value2;
            answer.insert(0, sum % 10);
            carry = sum / 10;
        }

        if (carry == 1)
        {
            answer.insert(0, 1);
        }

        return answer.toString();
    }

    // The subtract method accepts two natural numbers
    // represented as character strings and returns their
    // difference as a character string .
    // The first number is not smaller than the second

    public static String subtract ( String num1 , String num2 ) {
        int carry = 0;
        StringBuilder answer = new StringBuilder();

        // format
        if (num1.length() > num2.length()) {
            num2 = sameLength(num1, num2);
        }

        for (int i = num1.length() - 1; i >=0 ; i--) {

            int value1 = Character.getNumericValue(num1.charAt(i));
            int value2 = Character.getNumericValue(num2.charAt(i));
            int difference  = value1- value2 - carry;

            if (difference < 0)
            {
                difference = difference + 10;
                carry = 1;
            }
            else
            {
                carry = 0;
            }
            answer.insert(0,difference);
        }
        return answer.toString();
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
    private static String sameLength(String big, String small) {
        int difference = big.length() - small.length();
        for (int i = 0; i < difference; i++) {
            small = "0" + small;
        }
        return small;
    }
}