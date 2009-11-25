package crawler;
import index.Indexa��o;

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
	Indexa��o ind;
	
	public void lerFicheiro(File file) {

		try {
			fr = new FileReader(file);
			br = new BufferedReader(fr);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	
		try {
			line = br.readLine();
			ind = new Indexa��o();
			
			while (line != null) {
				st = new StringTokenizer(line);
				while (st.hasMoreTokens()) {
					ind.addSourceForWord((String)st.nextToken(), file.getName());
					}
				line = br.readLine();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
	
}