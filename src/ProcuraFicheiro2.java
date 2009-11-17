import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class ProcuraFicheiro2 {

	static BufferedReader br;
	static FileReader fr;
	static StringTokenizer st;
	static Scanner scanner;
	static String palavra;
	static String line;
	static int encontradas;

	public static void lerFicheiro() {
		try {
			fr = new FileReader(new File("testeeeee.txt"));
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
					if (st.nextToken().equals(palavra)) {
						encontradas++;
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
		System.out.println(encontradas);
	}
}
