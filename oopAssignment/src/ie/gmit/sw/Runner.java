package ie.gmit.sw;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.BlockingQueue;

public class Runner
{
	private static String input; 
			
	public static void main(String[] args)
	{
		QuadGramMap.setMap(); //call setMap method from QuadGramMap class
		Scanner console = new Scanner(System.in);
		System.out.print("Enter cyphertext or pathfile (including .txt extention) for decryption: ");
		input = console.nextLine(); //read in filepath or cyphertext from user
		InputChecker ic = new InputChecker(); //create instance of InputChecker
		ic.inputType(input); //check whether input is filepath or cyphertext
	}
}
