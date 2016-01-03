package ie.gmit.sw;

import java.util.concurrent.BlockingQueue;

public class ScoreComparer implements Runnable
{
	private BlockingQueue<Resultable> queue;
	private int count;
	private Resultable highScore = null;

	public ScoreComparer(int count, BlockingQueue<Resultable> queue) //constructor
	{
		this.count = count;
		this.queue = queue;
	}

	public void run()
	{
		while(!queue.isEmpty()&&count!=2){ //while queue is not empty and count is not 2 (thread count starts at 2)
			try
			{
				
				Resultable r = queue.take();//result is taken from queue
				count--; //count is decremeneted
				if(highScore==null||r.getScore()>highScore.getScore()){ //if it's the first high score or the result score is greater than the current highscore score
					highScore=r;//highscore takes value of current result
					
				}
								
			} catch (InterruptedException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//print out Text, Key and Score of the highest scoring result
		System.out.println("Plain Text: " + highScore.getPlainText() + "\nKey: " + highScore.getKey() + "\nScore: " + highScore.getScore());
		
	
	
	}
		
		
}

