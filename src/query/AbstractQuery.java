package query;
import java.util.HashSet;
import java.util.Scanner;

import index.Indexação;

public abstract class AbstractQuery extends Thread{
String queryString;	

//public abstract HashSet<String> getResults();

	public AbstractQuery(String queryString) {
		this.queryString = queryString; 
	}
}
