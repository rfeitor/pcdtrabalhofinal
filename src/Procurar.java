import java.util.HashSet;


public class Procurar extends Thread {
	TestHash hashtest;
	String test;
	HashSet<String> Testar = new HashSet<String>();
	String testar;
	
	public Procurar(String test) {
		this.testar = test;
	}
	
	public void run(){
		Testar = hashtest.getHash(testar);
		System.out.println(Testar);
	}
}
