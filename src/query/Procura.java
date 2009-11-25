package query;
import java.util.Scanner;

import index.Indexação;

public class Procura {
Indexação ind = new Indexação();
	
	public void procuraPalavra(){
		String palavra_a_procurar = new String();
		Scanner sc;

		while(true){
			sc = new Scanner(System.in);
			palavra_a_procurar = sc.next();
			System.out.println(">" + palavra_a_procurar);
			System.out.println(ind.findSourcesForWord(palavra_a_procurar));
		}
	}
}
