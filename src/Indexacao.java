import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.filechooser.FileSystemView;


public class Indexacao extends Thread {
	ArrayList<String> list = new ArrayList<String>();
	File file;
	
	public Indexacao(){
		
	}
	
	// method that calls the search method
	public void search(String name, File dir){
	     ArrayList<String> list = new  ArrayList<String>();
	     search(dir, list);	
	}
	
	public void search(File dir){
	     //ArrayList<String> list = new  ArrayList<String>();
	     search(dir, list);	
	}
	
	// recursive method
	public ArrayList<String> search(String name, File dir, ArrayList<String> list){
		File [] children = dir.listFiles();
		
		for(int n = 0; n < children.length; n++){
			System.out.println(children.length);
			File file = children[n];
		    
			if(file.getName().equalsIgnoreCase(name)){
		    	list.add(file.getAbsolutePath());
		    }
		    
			else
				if(file.isDirectory()){
		    	
		    	search(name, file);
		    }
		 }
		 return list;
	}
	
	public ArrayList<String> search(File dir, ArrayList<String> list){
		File [] children = dir.listFiles();
		
		for(int n = 0; n < children.length; n++){
			File file = children[n];
		    
			if(file.isDirectory()){
		    	
		    	search(file);
		    }
			else if(file.getName().endsWith(".txt")){
			list.add(file.getAbsolutePath());
	        System.out.println(file.getAbsolutePath());
			//break;
			}
		 }
		 return list;
	}
	
	public void executa(){
		String userDir = System.getProperty("user.dir");
		
		File file = new File(userDir);
		search(file , list);
	}
	
	public static void main(String args[]){
		Indexacao a = new Indexacao();
		
			a.executa();
	}
}
