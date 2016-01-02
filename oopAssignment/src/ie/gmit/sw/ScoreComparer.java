package ie.gmit.sw;

import java.util.concurrent.BlockingQueue;

public class ScoreComparer implements Runnable
{
	private BlockingQueue<Resultable> queue;
	private int count;
	private Resultable highScore = null;

	public ScoreComparer(int count, BlockingQueue<Resultable> queue)
	{
		this.count = count;
		this.queue = queue;
	}

	public void run()
	{
		while(!queue.isEmpty()&&count!=2){
			try
			{
				
				Resultable r = queue.take();
				count--;
				if(highScore==null||r.getScore()>highScore.getScore()){
					highScore=r;
					
				}
								
			} catch (InterruptedException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		System.out.println("Plain Text: " + highScore.getPlainText() + "\nKey: " + highScore.getKey() + "\nScore: " + highScore.getScore());
		
	
	
	}
		
		
}

