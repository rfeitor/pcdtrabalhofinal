package query;
import java.util.HashSet;

public abstract class AbstractQuery extends Thread{
String queryString;	

	public AbstractQuery(String queryString) {
		this.queryString = queryString; 
	}
	
	public abstract HashSet<String> getResults();
}
