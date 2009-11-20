package crawler;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Crawler {
	FileReader fr;
	BufferedReader br;
	String line;
	StringTokenizer st;
	
	public void lerFicheiro(String source) {
		
		try {
			fr = new FileReader(new File(source));
			br = new BufferedReader(fr);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	
		try {
			
			System.out.println("ler ficheiro");
			line = br.readLine();

			while (line != null) {
				st = new StringTokenizer(line);
				while (st.hasMoreTokens()) {
					//index.Index.this.addSourceForWord((String)st.nextToken(), source);
					}
				line = br.readLine();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
}