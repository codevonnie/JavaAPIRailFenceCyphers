package ie.gmit.sw;

import java.io.IOException;

public class InputChecker
{
	private static FileReader fr = new FileReader(); //create instance of FileParser
	
	public void inputType(String input){ //check whether input is filepath or cyphertext
		
		if(input.contains(".")){ //if the input contains char . it is taken to be a filepath
			 
			try
			{
				input=fr.readFile(input); //read file to string in FilerReader readFile method
				new CypherBreaker(input); //create new CypherBreaker with file content
			} catch (IOException e)
			{
				System.out.println("Could not find specified file");//tell the user if the file could not be found
				//e.printStackTrace();
			}
		}
		else{
			new CypherBreaker(input); //else the input is cyphertext that is sent directly to CypherBreaker
		}
		
		

		
	}
}
