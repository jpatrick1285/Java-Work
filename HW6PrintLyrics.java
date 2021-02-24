
/****************************************************
 * HW6PrintLyrics.java (shell)
 * CS151
 *
 * Prints the lyrics of song "Ninety-Nine Bottles of Beer on the Wall."
 * Use user-defined methods
 *****************************************************/

/* Algorithm - main

loop from 99 down to 1
// one verse each iteration
numString <-- call method to convert i to string
print numstring + " bottles of beer on the wall, " // phrase 1
print numString + " bottles of beer, " // phrase 2
print "Take one down, pass it around, " // phrase 3
numString <-- call method to convert i-1 to string
print numstring + " bottles of beer on the wall." // phrase 4
print a blank line
end loop
 */

/* Algorithm - numberToString

ADD 1

 */

public class HW6PrintLyrics
{
    public static void main(String[] args)
    {
        // loop verses from 99 down to 1
        for (int i=99; i>0; i--)
        {
            // print one verse: with 4 phrases
            //   first two phrases: value i
            //   third phrase: no number
            //   fourth phrase: value i-1

            String numString = numberToString(i); // convert i to string
            if(i>2)
            {
                System.out.println(numString + " bottles of beer on the wall, ");
                System.out.println(numString + " bottles of beer, ");
            }
            else
            {
                System.out.println(numString + " bottle of beer on the wall, ");
                System.out.println(numString + " bottle of beer, ");
            }
            System.out.println(" Take one down, pass it around, ");
            numString = HW6PrintLyrics.numberToString(i-1);
            if(i>2)
            {
                System.out.println(numString + " bottles of beer on the wall.\n");
            }
            else if(i<2)
            {
                System.out.println("Zero bottles of beer on the wall.\n");
            }
            else
            {
                System.out.println(numString + " bottle of beer on the wall.\n");
            }
            //numString

        } // end for

    } // end main
    public static String numberToString(int num)
    {

        int tens = num/10;

        int ones = num%10;

        String result = "";
        String t = new String();

        String o = new String();

        //switch (tens)
        //{
        //case 0:
        //t = " ";
        //break;
        //case 1:
        if(tens == 1)
        {
            switch (ones)
            {
                case 0:
                o ="Ten";
                case 1:
                o = "Eleven";
                break;
                case 2:
                o = "Twelve";
                break;
                case 3:
                o = "Thirteen";
                break;
                case 4:
                o = "Fourteen";
                break;
                case 5:
                o = "Fifteen";
                break;
                case 6:
                o = "Sixteen";
                break;
                case 7:
                o = "Seventeen";
                break;
                case 8:
                o = "Eighteen";
                break;
                case 9:
                o = "Ninteen";
                break;
            }

        }
        switch(tens)
        {
            case 0:
            case 1:
            t = "";
            break;
            case 2:
            t = "Twenty";
            break;
            case 3:
            t = "Thirty";
            break;
            case 4:
            t = "Forty";
            break;
            case 5:
            t = "Fifty";
            break;
            case 6:
            t = "Sixty";
            break;
            case 7:
            t = "Seventy";
            break;
            case 8:
            t = "Eighty";
            break;
            case 9:
            t = "Ninety";
            break;
        }
        if(tens != 1)
        {
            switch (ones)
            {
                case 0:
                o = "";
                break;
                case 1:
                o = "One";
                break;
                case 2:
                o = "Two";
                break;
                case 3:
                o = "Three";
                break;
                case 4:
                o = "Four";
                break;
                case 5:
                o = "Five";
                break;
                case 6:
                o = "Six";
                break;
                case 7:
                o = "Seven";
                break;
                case 8:
                o = "Eight";
                break;
                case 9:
                o = "Nine";
                break;

            }
        }
        if(t != "" && o != "")
        {
            result = t + "-" + o;
        }
        else if(t.equals("") && o != "")
        {
            result = o;

        }
        else
        {
            result = t;
        }
        return  result;
    }
}