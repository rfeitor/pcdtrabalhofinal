import java.util.HashSet;


public class Procurar extends Thread {
	
	TestHash hashtest = null;
	HashSet<String> Testar = new HashSet<String>();
	
	public void run(String testar){
		
		
		Testar = hashtest.getHash(testar);
		System.out.println(Testar);
	}
}
