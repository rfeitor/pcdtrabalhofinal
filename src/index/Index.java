package index;

import java.util.HashSet;
import java.util.Hashtable;

public interface Index {
	
	Hashtable<String, HashSet<String>> tabela = new Hashtable<String, HashSet<String>>();
	
	public HashSet<String> findSourcesForWord(String words);
		
	public void addSourceForWord(String word, String source);
	
}
