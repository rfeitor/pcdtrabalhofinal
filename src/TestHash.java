import java.util.HashSet;
import java.util.Hashtable;
import java.util.StringTokenizer;


public class TestHash {
	HashSet<String> coleccao = new HashSet<String>();
	HashSet<String> coleccao2 = new HashSet<String>();
	HashSet<String> coleccao3 = new HashSet<String>();
	
	Hashtable<String, HashSet<String>> tabela = new Hashtable<String, HashSet<String>>();
	
	HashSet<String> results = new HashSet<String>();
	
	
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
	
	public HashSet<String> getHash(String testar){
		HashSet<String> Testar = new HashSet<String>();	
		
		System.out.println(tabela);
		Testar = tabela.get(testar);

		return Testar;
	}
	
	public void procuraPartilhada(String string_procurar) {
		StringTokenizer st = new StringTokenizer(string_procurar);
		//HashSet<String> hash = new HashSet<String>();
		
		while(st.hasMoreElements()) {
			Procurar procurar = new Procurar(st.nextToken());
			procurar.run();
		}
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
