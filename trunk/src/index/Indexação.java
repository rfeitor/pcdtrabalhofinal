package index;
import crawler.Crawler;
import query.Procura;

import java.io.File;
import java.util.HashSet;



public class Indexação implements Index {

	Crawler procura = new Crawler();
	
	public void addSourceForWord(String word, String source){
	HashSet<String> hash = new HashSet<String>();
	
		if(tabela.containsKey(word)){
			hash = tabela.get(word);
			hash.add(source);
			tabela.put(word, hash);
		}
		
		else{
			hash.add(source);
			tabela.put(word, hash);
		}
		
	
	}
	
	public HashSet<String> findSourcesForWord(String words){
		HashSet<String> hash;
		
			hash = tabela.get(words);
		
		return hash;
	}
	
	public void indexaFicheiros(File dir){
		
		File [] children = dir.listFiles();
		
		for(int n = 0; n < children.length; n++){
			File file = children[n];
			
			if(file.isDirectory()){
		    	search(file);
			}
			else 
				if(file.getName().endsWith(".txt")){
					procura.lerFicheiro(file);
				}	
		 }
	}
	
	public void search(File file){
	     indexaFicheiros(file);	
	}
		
	public static void main(String args[]){
		String userDir = System.getProperty("user.dir");
		File user = new File(userDir);
		Indexação ind = new Indexação();
		ind.indexaFicheiros(user);
		
		new Procura("rato").start();
	}
}