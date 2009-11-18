import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
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
	static ArrayList<File> test = new ArrayList<File>();
	static HashMap<String, ArrayList<File>> set_test = new HashMap<String, ArrayList<File>>();
	static File file;
	static File file2;
	
	public static void lerFicheiro() {
		try {
			fr = new FileReader(new File("testeeeee.txt"));
			file = new File("testeeeee.txt");
			br = new BufferedReader(fr);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static void lerFicheiro2() {
		try {
			fr = new FileReader(new File("teste.txt"));
			file = new File("teste.txt");
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
					
					if(set_test.put(st.nextToken(),){
						;
					}
				}
				line = br.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static int compara() {
		while (st.hasMoreTokens()) {
			if (st.nextToken().equals(palavra)) {
				encontradas++;
			}
		}
		return encontradas;
	}

	public static void main(String args[]) {

		System.out.print("Palavra : ");
		scanner = new Scanner(System.in);
		palavra = scanner.next();
		lerFicheiro();
		lerToken();
		lerFicheiro2();
		lerToken();
		System.out.println(set_test);
	}
}
