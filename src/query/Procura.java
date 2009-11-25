package query;
import index.Indexação;

//import java.util.Scanner;

public class Procura extends AbstractQuery{
	
	Indexação ind;
	
	public Procura(String queryString) {
		super(queryString);
	}

	public void run(){
		//Scanner sc;
		ind = new Indexação();

		while(true){
			//sc = new Scanner(System.in);
			//palavra_a_procurar = sc.next();
			
			System.out.println(">" + queryString);
			System.out.println(ind.findSourcesForWord(queryString));
		}
	}
	
}
