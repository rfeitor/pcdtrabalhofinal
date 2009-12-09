import java.util.HashSet;


public class Procurar extends Thread {
	TestHash hashtest;
	HashSet<String> Testar = new HashSet<String>();
	String testar;
	
	public Procurar(String testar, TestHash test) {
		this.testar = testar;
		this.hashtest = test;
	}
	
	public void run(){
		try {
			sleep((int)(Math.random()*1000));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Testar = hashtest.getHash(testar);
		System.out.println(Testar);
	}
	
	public HashSet<String> getHashSet(){
		return Testar;
	}
}