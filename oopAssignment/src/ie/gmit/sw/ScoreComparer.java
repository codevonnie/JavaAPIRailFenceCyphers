package ie.gmit.sw;

public class ScoreComparer
{
	private String plainText;
	private int key;
	private double score;
	private static Resultable highScore = null;

	public static Resultable compare(Resultable score)
	{
		if(highScore==null||score.getScore()>highScore.getScore()){
			highScore=score;
			return highScore;
		}
		else{
			return score;
		}
		
	}

}
