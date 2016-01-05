package ie.gmit.sw;

import java.util.concurrent.BlockingQueue;

public class Decryptor implements Runnable
{
	private BlockingQueue<Resultable> queue;
	private String cypherText;
	private int key;
	private static RailFence rf = new RailFence(); //new instance of RailFence
	private static TextScorer tScore;

	public Decryptor(BlockingQueue<Resultable> queue, String cypherText, int key) //constructor
	{
		super();
		this.queue = queue;
		this.cypherText = cypherText;
		this.key = key;
		
	}

	public void run() //producer threads overriden run method
	{
		String plainText = rf.decrypt(cypherText, key); //plainText takes value returned by RailFence decrypt method
		tScore = new TextScorer(QuadGramMap.getMap()); //new instance of TextScorer
		Double score = tScore.getScore(plainText); //score takes value from TextScorer getScore method
		Resultable r = new Result(plainText, key, score); //create a result
		
		try
		{
			queue.put(r); //put result onto the queue for the consumer to take
		} catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
