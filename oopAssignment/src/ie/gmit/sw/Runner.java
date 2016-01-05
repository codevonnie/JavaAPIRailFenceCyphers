package ie.gmit.sw;

import java.util.Scanner;

public class Runner
{
	private static String input; 
	private static InputChecker ic = new InputChecker(); //create instance of InputChecker
			
	public static void main(String[] args)
	{
		QuadGramMap.setMap(); //call setMap method from QuadGramMap class
		Scanner console = new Scanner(System.in);
		System.out.print("Enter cyphertext or pathfile (including .txt extention) for decryption: ");
		input = console.nextLine(); //read in filepath or cyphertext from user
		ic.inputType(input); //check whether input is filepath or cyphertext
		console.close();
	}
}
