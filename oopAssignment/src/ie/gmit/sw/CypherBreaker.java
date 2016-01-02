package ie.gmit.sw;

import ie.gmit.sw.Resultable;

import java.util.*;
import java.util.concurrent.*;

public class CypherBreaker
{
	private static final int MAX_QUEUE_SIZE = 100;
	private BlockingQueue<Resultable> queue;
	private String cypherText;
	
	public CypherBreaker(String cypherText){
		queue = new ArrayBlockingQueue(MAX_QUEUE_SIZE);
		this.cypherText = cypherText;
		
		init();
		
	}
	
	public void init(){
		//start a load of producers
		for(int i = 2; i<cypherText.length()/2; i++){
			new Thread(new Decryptor(queue, cypherText, i)).start();
		}
		
		Thread t = new Thread(new ScoreComparer(cypherText.length()/2, queue));
		try
		{
			Thread.sleep(1000);
		} catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		t.start();
	}
}