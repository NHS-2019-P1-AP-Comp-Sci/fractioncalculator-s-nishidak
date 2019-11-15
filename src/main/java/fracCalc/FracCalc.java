/**
 * @author Mr. Rasmussen
 */

package fracCalc;
import java.util.*;
import java.lang.Math;
public class FracCalc {

    public static void main(String[] args)
    {
    	Scanner scan = new Scanner(System.in);
    	System.out.println("Enter fraction equation(ex: 1_1/2 + 5/2)");
    	String input = scan.nextLine();
    	String second = produceAnswer(input);
    	System.out.println("second operand: "+second);
       // TODO: Read the input from the user and call produceAnswer with an equation

    }

    // ** IMPORTANT ** DO NOT DELETE THIS FUNCTION.  This function will be used to test your code
    // This function takes a String 'input' and produces the result
    //
    // input is a fraction string that needs to be evaluated.  For your program, this will be the user input.
    //      e.g. input ==> "1/2 + 3/4"
    //
    // The function should return the result of the fraction after it has been calculated
    //      e.g. return ==> "1_1/4"
    public static String produceAnswer(String input)
    { 
    	int plus = input.indexOf("+");
    	int minus = input.indexOf("-");
    	int times = input.indexOf("*");
    	int divide = input.indexOf("/");
    	int operator = Math.max(plus,minus);
    	operator = Math.max(operator, times);
    	operator = Math.max(operator, divide);
    	String first = new String(input.substring(0,operator-1));
    	char oper = input.charAt(operator);
    	String second =new String(input.substring(operator+2));

        // TODO: Implement this function to produce the solution to the input

        return second;
    }

    // TODO: Fill in the space below with any helper methods that you think you will need

}
