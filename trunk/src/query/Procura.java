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
		try {
			sleep((int)(Math.random()*1000));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		coleccao = ind.findSourcesForWord(queryString);
	
		try {
			ind.pop(coleccao);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public HashSet<String> getResults() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}