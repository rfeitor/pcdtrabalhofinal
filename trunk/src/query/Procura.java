package query;

import java.util.HashSet;

import index.Indexação;

public class Procura extends AbstractQuery {

	Indexação ind;
	HashSet<String> coleccao = new HashSet<String>();

	public Procura(String queryString) {
		super(queryString);
	}

	public void run() {
		ind = new Indexação();
		// System.out.println(">" + queryString);
		// System.out.println(ind.findSourcesForWord(queryString));
		coleccao = ind.findSourcesForWord(queryString);
	}

	@Override
	public HashSet<String> getResults() {
		return coleccao;
	}

}
