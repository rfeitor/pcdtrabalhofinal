package query;

import java.util.HashSet;

import index.Indexa��o;

public class Procura extends AbstractQuery {

	Indexa��o ind;
	HashSet<String> coleccao = new HashSet<String>();

	public Procura(String queryString) {
		super(queryString);
	}

	public void run() {
		ind = new Indexa��o();	
		coleccao = ind.findSourcesForWord(queryString);
	}
	
	@Override
	public HashSet<String> getResults() {
		return coleccao;
	}

}