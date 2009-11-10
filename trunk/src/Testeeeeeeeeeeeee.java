import java.util.HashSet;

public class Testeeeeeeeeeeeee {
	
	public static void main(String args[]) {
		
		HashSet<String> set_test = new HashSet<String>();
		String[] args_test = {"i","came","i","came","i","conquered"};
		
		for(int i = 0; i < args_test.length; i++) {
			if(!set_test.add(args_test[i]))
				System.out.println("Duplicate detected: " + args_test[i]);
		}
		
		System.out.println(set_test.size() + " distinct words detected : " + set_test);
	}
}
