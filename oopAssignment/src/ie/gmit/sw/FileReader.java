package ie.gmit.sw;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileReader
{
	public String readFile(String file) throws IOException{
		
		StringBuilder sb = new StringBuilder(); //for appending strings
		File f=new File(file); //textfile entered by user
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(f))); //open inputstream
		String line; //to read in file line by line
				
		while((line=br.readLine())!=null){ //while values still to be read in from file

			sb.append(line);
			
		}//while */
		br.close(); //close bufferedreader
		file=sb.toString();//convert stringbuilder to String
		return file;
		
	}
}
