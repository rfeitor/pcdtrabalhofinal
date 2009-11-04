import java.io.File;
import java.util.ArrayList;


public class Indexacao extends Thread {
	ArrayList<String> list = new ArrayList<String>();
	
	public Indexacao(){
		
	}
	
	// method that calls the search method
	public void search(String name, File dir){
	     ArrayList<String> list = new  ArrayList<String>();
	     search(name, dir, list);	
	}
	
	// recursive method
	public ArrayList<String> search(String name, File dir, ArrayList<String> list){
		File [] children = dir.listFiles();
		
		for(int n = 0; n < children.length; n++){
		
			File file = children[n];
		    
			if(file.getName().equalsIgnoreCase(name)){
		    	list.add(file.getAbsolutePath());
		        break;
		    }
		    
			else if(file.isDirectory()){
		    	
		    	search(name, file);
		    }
		 }
		 return list;
	}
	
	public void executa(){
	//	search("ola",  , list);
	}
	
	public static void main(){
		Indexacao a = new Indexacao();
		a.executa();
	}
}
