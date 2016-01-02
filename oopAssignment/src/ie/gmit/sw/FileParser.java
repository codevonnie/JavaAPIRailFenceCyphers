package ie.gmit.sw;

import java.io.*;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class FileParser
{
	public Map<String, Double> parse(String file) throws Exception{
		Map<String, Double> temp = new ConcurrentHashMap<String, Double>();
		File quadFile = new File(file);
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(quadFile)));
		String next=null;
		int i = 0;
		
		while((next=br.readLine())!=null){
			//Add each line to the parse
			String[] stuff = next.split(" ");
			temp.put(stuff[0], Double.parseDouble(stuff[1]));

		}
		
		return temp;
	}
}
