package ie.gmit.sw;

import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;

public class Decryptor implements Runnable
{
	private BlockingQueue<Resultable> queue;
	private String cypherText;
	private int key;

	public Decryptor(BlockingQueue<Resultable> queue, String cypherText, int key)
	{
		super();
		this.queue = queue;
		this.cypherText = cypherText;
		this.key = key;
		
	}

	public void run()
	{
		RailFence rf = new RailFence();
		String plainText = rf.decrypt(cypherText, key);
		
		TextScorer tScore = new TextScorer(QuadGramMap.getMap());
		Double score = tScore.getScore(plainText);
		
		Resultable r = new Result(plainText, key, score); //create a result
		try
		{
			queue.put(r);
		} catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
