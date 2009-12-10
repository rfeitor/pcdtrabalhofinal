package index;

import crawler.Crawler;
import query.Procura;

import java.io.File;
import java.util.HashSet;
import java.util.StringTokenizer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Indexação implements Index {

	Crawler crawl = new Crawler();
	int contar = 0;
	boolean file_available = false;
	boolean algum_null = false;

	HashSet<String> results = new HashSet<String>();
	ExecutorService executor;

	public boolean getFileAvailable() {
		return file_available;
	}

	public void setNull() {
		algum_null = true;
	}

	public void addSourceForWord(String word, String source) {
		HashSet<String> hash = new HashSet<String>();

		if (tabela.containsKey(word)) {
			hash = tabela.get(word);
			hash.add(source);
			tabela.put(word, hash);
		}
		else {
			hash.add(source);
			tabela.put(word, hash);
		}

	}

	public void indexaFicheiros(File dir) {
		try {
			File[] children = dir.listFiles();

			for (int n = 0; n < children.length; n++) {
				file_available = true;
				File file = children[n];

				if (file.isDirectory()) {
					search(file);
				} else if (file.getName().endsWith(".txt")) {
					crawl.lerFicheiro(file);
					System.out.println("Ficheiro: " + file.getAbsolutePath());
				}
			}
		} catch (NullPointerException e) {
			// TODO 
		}
	}

	public void search(File file) {
		indexaFicheiros(file);
	}
	
	public HashSet<String> findSourcesForWord(String words) {
		HashSet<String> hash;

		hash = tabela.get(words);

		return hash;
	}

	public HashSet<String> procuraPartilhada(String string_procurar) {
		StringTokenizer st = new StringTokenizer(string_procurar);
		results.clear();
		algum_null = false;

		executor = Executors.newFixedThreadPool(st.countTokens());
		
		while (st.hasMoreElements()) {
			executor.execute(new Procura(st.nextToken(), this));
		}
		
		try {
			executor.awaitTermination(5, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return results;
	}

	public void pop(HashSet<String> hs) throws InterruptedException {
		if(hs == null){
			algum_null = true;
			results.clear();
		}
		if (results.isEmpty() && !algum_null) {
			results = hs;
			System.out.println("Ola " + hs);
		} else if(!algum_null) {
			System.out.println("hs " + hs);
			results.retainAll(hs);
			System.out.println("Results " + results);
		}
	}
}