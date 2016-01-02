package ie.gmit.sw;

import java.io.File;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.BlockingQueue;

public class Runner
{
	private static String file;
			
	public static void main(String[] args)
	{
		QuadGramMap.setMap();
		Scanner console = new Scanner(System.in);
		System.out.print("Enter pathfile for decryption: ");
		file = console.nextLine();
		CypherBreaker cypher = new CypherBreaker(file);
		
		/*String s = new RailFence().decrypt("cypherText", key);
		System.out.println(">" + s);*/
	}

}
