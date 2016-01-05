package ie.gmit.sw;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class QuadGramMap
{
	public static final int GRAM_SIZE=4;
	private static Map<String, Double> map = new ConcurrentHashMap<String, Double>(); //map for QuadGram file contents
	
	public QuadGramMap()
	{
		super();
	}
	public static Map<String, Double> getMap()
	{
		return map;
	}
	public static void setMap()
	{
		String quadFile = "4grams.txt";
		FileParser fp = new FileParser();//create new instance of FileParser
		try
		{
			map = fp.parse(quadFile); //map takes value returned from parse method when passed filepath
			
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	public static int getGramSize()
	{
		return GRAM_SIZE;
	}
	
}
