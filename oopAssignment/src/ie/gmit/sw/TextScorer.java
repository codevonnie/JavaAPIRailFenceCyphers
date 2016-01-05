package ie.gmit.sw;

import java.util.Map;
import java.util.concurrent.*;

public class TextScorer {
	private Map<String, Double> map = new ConcurrentHashMap<String, Double>();
	
	public TextScorer(Map<String, Double> m){
		this.map = m;
	}
	
	public double getScore(String text){ //get the score of the plaintext
		double score = 0f;

		for (int i = 0; i < text.length(); i++){
			if (i + QuadGramMap.GRAM_SIZE <= text.length() -1){ //read the first four characters from plain text, then the next four starting from the second character
				score += computeLogScore(text.substring(i, i + QuadGramMap.GRAM_SIZE));//score takes the value returned from computeLogScore method
			}
		}
		return score;
	}
	
	public double computeLogScore(String quadgram){ //gets passed the current four character string being compared
		if (map.containsKey(quadgram)){ //if the quadgram map contains the four character string
			double frequency = map.get(quadgram);//takes the value of the score of the string in the quadgram map
			double total = (double) map.size();//the value of the quadgram map size
			double probability = (double) (frequency/total);//divides the score by the total map size
			
			return Math.log10(probability);//returns the log10 value of the above value
		}else{
			return 0f;//else returns 0 if the string is not contained in the map
		}
	}
}
