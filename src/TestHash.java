import java.util.HashSet;
import java.util.Hashtable;
import java.util.StringTokenizer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class TestHash {

	HashSet<String> coleccao = new HashSet<String>();
	HashSet<String> coleccao2 = new HashSet<String>();
	HashSet<String> coleccao3 = new HashSet<String>();
	
	Hashtable<String, HashSet<String>> tabela = new Hashtable<String, HashSet<String>>();
	
	HashSet<String> results = new HashSet<String>();
	
	ExecutorService executor;	
	
//	public void testar(String testar){
//		HashSet<String> Testar = new HashSet<String>();
//		Testar = tabela.get(testar);
//		
//		if(results.isEmpty())
//			results = tabela.get(testar);
//
//		results.retainAll(Testar);
//		System.out.println(results);
//		
//	}
	
	public synchronized HashSet<String> getHash(String testar){
		HashSet<String> Testar = new HashSet<String>();	
		
		System.out.println(tabela);
		Testar = tabela.get(testar);

		return Testar;
	}
	
	public void procuraPartilhada(String string_procurar) {
		StringTokenizer st = new StringTokenizer(string_procurar);
		results = null;
		//Ter cuidado quando devolve nulls
		executor = Executors.newFixedThreadPool(st.countTokens());
		
		//executor = new Executors.newFixedThreadPool(st.countTokens());
		
		while(st.hasMoreElements()) {
			executor.execute(new Procurar(st.nextToken(),this));
		}
	}
	
	public void pop(HashSet<String> hs) throws InterruptedException {
		if(results.isEmpty()){
			results = hs;
		}
		results.retainAll(hs);
	}
	
	public void correr(){
		coleccao.add("rato");
		coleccao.add("rei");
		coleccao.add("carro");
		coleccao.add("ola");
		coleccao.add("adeus");
		
		coleccao2.add("rato");
		coleccao2.add("carro");
		coleccao2.add("fuck");
		
		coleccao3.add("rato");
		coleccao3.add("rei");
		coleccao3.add("adeus");
	
		tabela.put("colect1", coleccao);
		tabela.put("colect2", coleccao2);
		tabela.put("colect3", coleccao3);
		
		procuraPartilhada("colect1 colect2 colect3");
	}
	
	public static void main(String args[]){
		 TestHash test = new TestHash();
		 test.correr();
	}

}