package index;

import java.util.HashSet;

public interface Index {
	
	public HashSet<String> findSourcesForWord(String words);
		
	public void addSourceForWord(String word, String source);
	
}
