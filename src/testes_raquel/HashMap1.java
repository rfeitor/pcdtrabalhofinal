package testes_raquel;

import java.util.Enumeration;
import java.util.HashMap;

public class HashMap1 {

	public static void main(String args[]) {
		HashMap map = new HashMap();
	    map.put(new Integer(2), "two" );
	    map.put(new Integer(4), "four" );
	    System.out.println(map);
	    System.out.println();
	    
	    System.out.println( "Enumerate the HashMap" );
	    Enumeration e = map.elements();
	    while ( e.hasMoreElements() )
	      System.out.println( e.nextElement() );
	    System.out.println();
	}
}
