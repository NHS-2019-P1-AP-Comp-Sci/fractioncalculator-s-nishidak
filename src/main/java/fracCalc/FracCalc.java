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
    	String input = ""; 
    	System.out.println("Enter fraction equation(ex: 1_1/2 + 5/2) type \"quit\" to stop");
		input = scan.nextLine();
    	while(input != "quit") {
    		String output = produceAnswer(input);
    		System.out.println(output);
    		System.out.println("Enter fraction equation(ex: 1_1/2 + 5/2) type quit to stop");
    		input = scan.nextLine();
    		
    	}
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
    	int firstspace = input.indexOf(" ");
    	String first = new String(input.substring(0,firstspace));
    	String notfirst = new String(input.substring(firstspace+1));
    	String operator = new String(notfirst.substring(0,1));
    	String second = new String(notfirst.substring(2));
    	
    	String firstcomp = breakdown(first);
    	String secondcomp = breakdown(second);
    	
  		return secondcomp;	
    	
    	
        // TODO: Implement this function to produce the solution to the input
    	 
    	
    }

    // TODO: Fill in the space below with any helper methods that you think you will need
    public static String breakdown(String value) {
    	int underscore =  value.indexOf("_");
    	int divide = value.indexOf("/");
    	String num = "";
    	String top = "";
    	String bot = "";
    	if (underscore != -1) {
    		num = new String(value.substring(0,underscore));
    	}
    	else {
    		if (divide == -1) {
    			num = value;
    		}
    		else {
    			num = "0";
    		}
    	}
    	if (divide != -1) {
    		top = new String(value.substring(underscore+1,divide));
    		bot = new String(value.substring(divide+1));
    	}
    	else {
    		top = "0";
    		bot = "1";
    	}
    	
    	return "whole:"+ num + " numerator:" + top + " denominator:"+bot;
    }
}
