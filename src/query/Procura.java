package query;

import java.util.HashSet;

import index.Indexação;

public class Procura extends AbstractQuery {

	HashSet<String> coleccao = new HashSet<String>();

	public Procura(String queryString, Indexação index) {
		super(queryString, index);
	}

	public void run() {
		try {
			sleep((int) (Math.random() * 1000));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		coleccao = index.findSourcesForWord(queryString);

		try {
			System.out.println("Coleccao " + coleccao);
			//if (coleccao == null)
				index.pop(coleccao);
//			else {
//				this.interrupt();
//				index.setNull();
//			}
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