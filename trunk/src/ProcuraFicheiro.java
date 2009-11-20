import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Scanner;
import java.util.StringTokenizer;

public class ProcuraFicheiro {

	static BufferedReader br;
	static FileReader fr;
	static StringTokenizer st;
	static Scanner scanner;
	static String palavra;
	static String line;
	static int encontradas; 
	static Hashtable<String, HashSet<String>> set_test = new Hashtable<String, HashSet<String>>();
	static File file;
	
	public static void lerFicheiro() {
		try {
			fr = new FileReader(new File("a.txt"));
			file = new File("a.txt");
			br = new BufferedReader(fr);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static void lerFicheiro2() {
		try {
			fr = new FileReader(new File("b.txt"));
			file = new File("b.txt");
			br = new BufferedReader(fr);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static void lerToken() {
		
		try {
		
			System.out.println("ler ficheiro");
			line = br.readLine();

			while (line != null) {
				st = new StringTokenizer(line);
				while (st.hasMoreTokens()) {
					adicionarSource((String)st.nextToken());
					}
				line = br.readLine();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void adicionarSource(String test){
		HashSet<String> teste = new HashSet<String>();
		
		if(set_test.containsKey(test)){
			teste = set_test.get(test);
			teste.add(file.getName());
			set_test.put(test, teste);
		}
		teste.add(file.getName());
		set_test.put(test, teste);
		
	}
	
	public static void main(String args[]) {
		
		lerFicheiro();
		lerToken();
		lerFicheiro2();
		lerToken();
		System.out.println(set_test.toString());
	}
}
