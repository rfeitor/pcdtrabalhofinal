package query;
import index.Indexa��o;

//import java.util.Scanner;

public class Procura extends AbstractQuery{
	
	Indexa��o ind;
	
	public Procura(String queryString) {
		super(queryString);
	}

	public void run(){
		//Scanner sc;
		ind = new Indexa��o();

		while(true){
			//sc = new Scanner(System.in);
			//palavra_a_procurar = sc.next();
			
			System.out.println(">" + queryString);
			System.out.println(ind.findSourcesForWord(queryString));
		}
	}
	
}
