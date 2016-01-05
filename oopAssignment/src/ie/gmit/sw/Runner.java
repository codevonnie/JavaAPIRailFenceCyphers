package ie.gmit.sw;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.BlockingQueue;

public class Runner
{
	private static String file; 
			
	public static void main(String[] args)
	{
		QuadGramMap.setMap(); //call setMap method from QuadGramMap class
		Scanner console = new Scanner(System.in);
		System.out.print("Enter pathfile for decryption: ");
		file = console.nextLine(); //read in file from user
		FileParser fp = new FileParser(); //create instance of FileParser 
		try
		{
			file=fp.readFile(file); //read file to string in readFile method
			new CypherBreaker(file); //create new CypherBreaker
		} catch (IOException e)
		{
			System.out.println("Could not find specified file");//tell the user if the file could not be found
			//e.printStackTrace();
		}

		

		
		
		
	}

}
