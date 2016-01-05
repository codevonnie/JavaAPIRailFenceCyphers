package ie.gmit.sw;

import java.io.*;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class FileParser
{
	public Map<String, Double> parse(String file) throws Exception{
		Map<String, Double> temp = new ConcurrentHashMap<String, Double>();
		File quadFile = new File(file);
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(quadFile))); //inputstream opened
		String next=null;
		int i = 0;
		
		while((next=br.readLine())!=null){
			//Add each line to the parse
			String[] stuff = next.split(" ");//separates the string and score 
			temp.put(stuff[0], Double.parseDouble(stuff[1]));//puts the string and score into the quadgram map

		}
		br.close();//close inputstream
		return temp;
	}
	
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
