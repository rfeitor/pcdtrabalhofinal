package index;

import crawler.Crawler;
import query.Procura;

import java.io.File;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Indexação implements Index {

	Crawler procura = new Crawler();

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

	public HashSet<String> findSourcesForWord(String words) {
		HashSet<String> hash;

		hash = tabela.get(words);

		return hash;
	}

	public void indexaFicheiros(File dir) {

		File[] children = dir.listFiles();

		for (int n = 0; n < children.length; n++) {
			File file = children[n];

			if (file.isDirectory()) {
				search(file);
			} else if (file.getName().endsWith(".txt")) {
				procura.lerFicheiro(file);
			}
		}
	}

	public void search(File file) {
		indexaFicheiros(file);
	}

	public synchronized void procuraPartilhada(String string_procurar) {
		StringTokenizer st = new StringTokenizer(string_procurar);
		HashSet<String> hash = new HashSet<String>();
		
		while(st.hasMoreElements()) {
			new Procura(st.nextToken()).start();
		}
		
	}

	public static void main(String args[]) {
		String userDir = System.getProperty("user.dir");
		File user = new File(userDir);
		Indexação ind = new Indexação();
		ind.indexaFicheiros(user);

		ind.procuraPartilhada("rato rei");
	}
}