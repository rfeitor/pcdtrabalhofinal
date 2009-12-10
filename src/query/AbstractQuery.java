package query;
import java.util.HashSet;
import index.Indexação;

public abstract class AbstractQuery extends Thread{
String queryString;
HashSet<String> queryHashSet;
Indexação index;

	public AbstractQuery(String queryString, Indexação index) {
		this.queryString = queryString;
		this.index = index;
	}
	
	public abstract HashSet<String> getResults();
}
