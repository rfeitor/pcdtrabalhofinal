import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class ProcuraFicheiro {

	static BufferedReader br;
	static FileReader fr;
	static StringTokenizer st;

	public static void ler_ficheiro() {
		try {
			fr = new FileReader(new File(
					"/TrabalhoFinalPCD/src/ficheiro_teste.txt"));
			br = new BufferedReader(fr);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static void passar_para_token() {
		try {
			st = new StringTokenizer(br.readLine());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String args[]) {
		ler_ficheiro();
		passar_para_token();
	}
}
