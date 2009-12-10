package query;
import java.util.HashSet;
import index.Indexa��o;

public abstract class AbstractQuery extends Thread{
String queryString;
HashSet<String> queryHashSet;
Indexa��o index;

	public AbstractQuery(String queryString, Indexa��o index) {
		this.queryString = queryString;
		this.index = index;
	}
	
	public abstract HashSet<String> getResults();
}
