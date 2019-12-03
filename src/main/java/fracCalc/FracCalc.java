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
    	char operator = notfirst.charAt(0);
    	String second = new String(notfirst.substring(2));
    	
     	int underscore =  first.indexOf("_");
    	int divide = first.indexOf("/");
    	String firstnum = "";
    	String firsttop = "";
    	String firstbot = "";
    	if (underscore != -1) {
    		firstnum = new String(first.substring(0,underscore));
    	}
    	else {
    		if (divide == -1) {
    			firstnum = first;
    		}
    		else {
    			firstnum = "0";
    		}
    	}
    	if (divide != -1) {
    		firsttop = new String(first.substring(underscore+1,divide));
    		firstbot = new String(first.substring(divide+1));
    	}
    	else {
    		firsttop = "0";
    		firstbot = "1";
    	}
    	
     	underscore =  second.indexOf("_");
    	divide = second.indexOf("/");
    	String secondnum = "";
    	String secondtop = "";
    	String secondbot = "";
    	if (underscore != -1) {
    		secondnum = new String(second.substring(0,underscore));
    	}
    	else {
    		if (divide == -1) {
    			secondnum = second;
    		}
    		else {
    			secondnum = "0";
    		}
    	}
    	if (divide != -1) {
    		secondtop = new String(second.substring(underscore+1,divide));
    		secondbot = new String(second.substring(divide+1));
    	}
    	else {
    		secondtop = "0";
    		secondbot = "1";
    	}
    	
        // TODO: Implement this function to produce the solution to the input
    	int firstwhole = Integer.parseInt(firstnum);
    	int firstnume = Integer.parseInt(firsttop);
    	if (firstwhole < 0) {
    		firstnume *=-1;
    	}
    	int firstden = Integer.parseInt(firstbot);
    	int secondwhole = Integer.parseInt(secondnum);
    	int secondnume = Integer.parseInt(secondtop);
    	if (secondwhole < 0) {
    		secondnume *=-1;
    	}
    	int secondden = Integer.parseInt(secondbot);
    	String ans = "";
    	if (operator == '+') {
    		ans = add(firstwhole, firstnume, firstden, secondwhole, secondnume, secondden);
    		return ans;
    	}
    	if (operator == '-') {
    		ans = sub(firstwhole, firstnume, firstden, secondwhole, secondnume, secondden);
    		return ans;
    	}
    	if (operator == '*') {
    		ans = mult(firstwhole, firstnume, firstden, secondwhole, secondnume, secondden);
    		return ans;
    	}
    	if (operator == '/') {
    		ans = div(firstwhole, firstnume, firstden, secondwhole, secondnume, secondden);
    		return ans;
    	}
		return ans;
    		
    	
    	
    	
    	
    	
    }
    // TODO: Fill in the space below with any helper methods that you think you will need
    public static String add(int firstwhole, int firstnume, int firstden, int secondwhole, int secondnume, int secondden) {
    	String ans ="";
    	int answhole = firstwhole + secondwhole;
		int anstop = (firstnume * secondden)+(secondnume * firstden);
		if (anstop < 0) {
			anstop *=-1;
		}
		int ansbot = firstden * secondden;
		if (answhole == 0) {
			if(anstop == 0) {
				ans = "0";
				return ans;
    		}
    		else {
    			ans = anstop + "/" + ansbot;
    			return ans;
    		}
    	}
    	else {
    		if(anstop == 0) {
    			ans =""+ answhole;
    			return ans;
    		}
    		else {
    			ans =answhole +"_"+ anstop + "/" + ansbot;
    			return ans;
    		}
    	}
		
    }
    public static String sub(int firstwhole, int firstnume, int firstden, int secondwhole, int secondnume, int secondden) {
    	String ans ="";
    	int answhole = firstwhole - secondwhole;
		int anstop = (firstnume * secondden)-(secondnume * firstden);
		if (anstop < 0) {
			anstop *=-1;
		}
		int ansbot = firstden * secondden;
		if (answhole == 0) {
			if(anstop == 0) {
				ans = "0";
				return ans;
    		}
    		else {
    			ans = anstop + "/" + ansbot;
    			return ans;
    		}
    	}
    	else {
    		if(anstop == 0) {
    			ans =""+ answhole;
    			return ans;
    		}
    		else {
    			ans =answhole +"_"+ anstop + "/" + ansbot;
    			return ans;
    		}
    	}
    }
    public static String mult(int firstwhole, int firstnume, int firstden, int secondwhole, int secondnume, int secondden) {
    	String ans ="";
    	int firsttop = firstnume + (firstwhole * firstden);
    	int secondtop = secondnume + (secondwhole * secondden);
    	int anstop = firsttop * secondtop;
		int ansbot = firstden * secondden;
		ans = anstop + "/" +ansbot;
    	return ans;
    }
    public static String div(int firstwhole, int firstnume, int firstden, int secondwhole, int secondnume, int secondden) {
    	String ans ="";
    	int firsttop = firstnume + (firstwhole * firstden);
    	int secondtop = secondnume + (secondwhole * secondden);
    	int anstop = firsttop * secondden;
		int ansbot = firstden * secondtop;
		ans = anstop + "/" +ansbot;
    	return ans;
    }
}
	
