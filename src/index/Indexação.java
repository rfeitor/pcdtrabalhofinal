package index;

import java.io.File;
import java.util.HashSet;
import java.util.Hashtable;

public class Indexação {
	Hashtable<String, HashSet<String>> tabela = new Hashtable<String, HashSet<String>>();
	HashSet<String> lista_ficheiros = new HashSet<String>();
	
	public void addSourceForWord(String word, String source){
		HashSet<String> hash = new HashSet<String>();
	
		if(tabela.containsKey(word)){
			hash = tabela.get(word);
			hash.add(source);
			tabela.put(word, hash);
		}
	
		hash.add(word);
		tabela.put(word, hash);
	}
	
	public HashSet<String> findSourcesForWord(String words){
		HashSet<String> hash = new HashSet<String>(null);
		
		if(tabela.containsKey(words)){
			hash = tabela.get(words);
		}
		
		return hash;
	}
	
	public void indexaficheiros(File dir){
		//String userDir = System.getProperty("user.dir");
		//File user = new File(userDir);
		
		File [] children = dir.listFiles();
		
		for(int n = 0; n < children.length; n++){
			File file = children[n];
		    
			if(file.isDirectory()){
		    	search(file);
		    }
			else 
				if(file.getName().endsWith(".txt"))
					lista_ficheiros.add(file.getAbsolutePath());
		 }
	}
	
	public void search(File dir){
	     search(dir);	
	}
	
}