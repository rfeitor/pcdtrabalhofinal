package index;

import crawler.Crawler;
import query.Procura;

import java.io.File;
import java.util.HashSet;
import java.util.StringTokenizer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Indexação implements Index {

	Crawler procura = new Crawler();
	int contar = 0;
	boolean file_available = false;
	
	HashSet<String> results = new HashSet<String>();
	ExecutorService executor;
	
	public boolean getFileAvailable() {
		return file_available;
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
					procura.lerFicheiro(file);
					System.out.println("Ficheiro: " + file.getAbsolutePath());
				}
			}
		} catch (NullPointerException e) {
			// TODO continuacao de apanhar excepções à pedreiro
		}
	}

	public void search(File file) {
		indexaFicheiros(file);
	}

//	public HashSet<String> compara(HashSet<String> hash,
//			HashSet<String> hash_compara) {
//		Iterator<String> it = hash_compara.iterator();
//		HashSet<String> hash_return = new HashSet<String>();
//
//		while (it.hasNext()) {
//			if (hash.contains(it.next())) {
//				hash_return.add(it.next());
//			}
//		}
//
//		return hash_return;
//	}

	public HashSet<String> findSourcesForWord(String words) {
		HashSet<String> hash;
		System.out.println(tabela);
		hash = tabela.get(words);

		return hash;
	}

	public HashSet<String> procuraPartilhada(String string_procurar) {
		StringTokenizer st = new StringTokenizer(string_procurar);
		results = null;
		
		executor = Executors.newFixedThreadPool(st.countTokens());
		
		while(st.hasMoreElements()) {
			executor.execute(new Procura(st.nextToken()));
		}
		
		return results;
	}
	
	public void pop(HashSet<String> hs) throws InterruptedException {
		if(results.isEmpty()){
			results = hs;
		}
		results.retainAll(hs);
	}
	
//	public synchronized void procuraPartilhada(String string_procurar) {
//		StringTokenizer st = new StringTokenizer(string_procurar);
//		HashSet<String> hash = new HashSet<String>();
//
//		while (st.hasMoreElements()) {
//			Procura procura = new Procura(st.nextToken());
//			procura.start();
//
//			if (hash.isEmpty())
//				hash = procura.getResults();
//
//			System.out.println(procura.getResults());
//			hash.retainAll(procura.getResults());
//			System.out.println(hash);
//		}
//	}	
}