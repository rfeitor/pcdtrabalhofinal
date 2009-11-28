package gui;

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

	//tretas para experiencias MVP
	
	public static void Palav (String palavra2){
		palavra = palavra2;
	}
	
	public static void retira_encontradas(){
		encontradas=0;
	}
	
	//fim
	
	public static void lerFicheiro(String fich) {
		try {
			fr = new FileReader(new File(fich));
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
		System.out.println(encontradas);
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
		//modificado MVP - O método lerFicheiro foi modificado
		//para receber a string com o nome do ficheiro a abrir
		lerFicheiro(palavra);
		lerToken();
		System.out.println(encontradas);
	}
}
