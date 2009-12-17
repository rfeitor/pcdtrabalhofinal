package index;

import crawler.Crawler;
import query.Procura;

import java.io.File;
import java.util.HashSet;
import java.util.StringTokenizer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Indexação implements Index {

	Crawler crawl;
	int contar = 0;
	boolean file_available = false;
	boolean algum_null = false;

	HashSet<String> results;
	ExecutorService executor, executorFile;
	ReentrantLock pauseLock = new ReentrantLock();
	Condition unpaused = pauseLock.newCondition();
	ReentrantLock pauseLockFile = new ReentrantLock();
	Condition unpausedFile = pauseLockFile.newCondition();

	public boolean getFileAvailable() {
		return file_available;
	}

	public void addSourceForWord(String word, String source) {
		HashSet<String> hash = new HashSet<String>();
		if (tabela.containsKey(word)) {
			hash = tabela.get(word);
			hash.add(source);
			tabela.put(word, hash);
		} else {
			hash.add(source);
			tabela.put(word, hash);
		}

	}

	public void indexaFicheiros(File dir, int num_crawler, int depth) {

		executorFile = Executors.newFixedThreadPool(num_crawler);

		try {
			File[] children = dir.listFiles();

			for (int n = 0; n < children.length; n++) {
				file_available = true;
				File file = children[n];
				pauseLockFile.lock();
				if (file.isDirectory() && depth > 0 || depth <= -1 ) {
					depth--;
					search(file, num_crawler, depth);
					depth++;
				} else if (file.getName().endsWith(".txt")) {
					executorFile.execute(new Crawler(file));
					while (pauseLockFile.getWaitQueueLength(unpausedFile) != 0) {
						try {
							unpausedFile.await();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					pauseLockFile.unlock();
				}
			}
		} catch (NullPointerException e) {
			// TODO
		}
	}

	public void search(File file, int num_crawler, int depth) {
		indexaFicheiros(file, num_crawler, depth);
	}

	public HashSet<String> findSourcesForWord(String words) {
		return tabela.get(words);
	}

	public HashSet<String> procuraPartilhada(String string_procurar) {
		StringTokenizer st = new StringTokenizer(string_procurar);
		results = new HashSet<String>();
		algum_null = false;
		executor = Executors.newFixedThreadPool(st.countTokens());

		pauseLock.lock();
		while (st.hasMoreElements()) {
			executor.execute(new Procura(st.nextToken(), this));
		}
//		
//		while (pauseLock.getWaitQueueLength(unpaused) != 0) {
//			try {
//				unpaused.await();
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
		pauseLock.unlock();
		executor.shutdown();
		while (!executor.isTerminated())
			;
		return results;

	}

	public void pop(HashSet<String> hs) throws InterruptedException {
		if (hs == null) {
			algum_null = true;
			results.clear();
		}
		if (results.isEmpty() && !algum_null) {
			results = hs;
			System.out.println("Ola " + hs);
		} else if (!algum_null) {
			System.out.println("hs " + hs);
			results.retainAll(hs);
			System.out.println("Results " + results);
		}
	}
}