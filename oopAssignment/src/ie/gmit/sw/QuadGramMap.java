package ie.gmit.sw;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class QuadGramMap
{
	public static final int GRAM_SIZE=4;
	private static Map<String, Double> map = new ConcurrentHashMap<String, Double>();
	
	public QuadGramMap()
	{
		super();
		this.map = map;
	}
	public static Map<String, Double> getMap()
	{
		return map;
	}
	public static void setMap()
	{
		String quadFile = "4grams.txt";
		FileParser fp = new FileParser();
		try
		{
			map = fp.parse(quadFile);
			
		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static int getGramSize()
	{
		return GRAM_SIZE;
	}
	
}
