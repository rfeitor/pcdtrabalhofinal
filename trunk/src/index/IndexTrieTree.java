package index;

import java.util.HashSet;

public class IndexTrieTree implements Index {

	private No raiz;

	class No{
		char key;
		HashSet<String> sources;
		No lokid, eqkid, hikid;
	}

	public No raiz(){
		return raiz;
	}

	public HashSet<String> search(String palavra){
		No t;
		t = raiz();
		int pos = 0;

		while(t != null){
			if( palavra.charAt(pos) < t.key)
				t = t.lokid;
			else if(palavra.charAt(pos) == t.key){
				if((++pos) == palavra.length()){
					if(t.eqkid == null)
						return t.sources;
					else
						return null;
				}
				t = t.eqkid;
			} else
				t = t.hikid;
		}
		return null;
	}

	public No insert(No t, String s, String source){
		if( t == null){
			t = new No();
			t.key = s.charAt(0);
			t.lokid = t.eqkid = t.hikid = null;
		}
		if( s.charAt(0) < t.key)
			t.lokid = insert(t.lokid, s, source);
		else if(s.charAt(0) == t.key){
			if( s.length() > 1)
				t.eqkid = insert(t.eqkid, s.substring(1), source);
			else
			{
				if(t.sources == null)
					t.sources = new HashSet<String>();
				t.sources.add(source);
			}
		} else
			t.hikid = insert(t.hikid, s, source);

		return t;
	}

	@Override
	public void addSourceForWord(String word, String source) {
		raiz = insert(raiz(), word, source);
	}

	@Override
	public HashSet<String> findSourcesForWord(String words) {
		return search(words);
	}

	public static void main(String[] args){
		IndexTrieTree tree = new IndexTrieTree();
		tree.addSourceForWord("carro", "a");
		tree.addSourceForWord("carro", "b");
		System.out.println(tree.findSourcesForWord("caro"));
		System.out.println(tree.findSourcesForWord("carro"));
		System.out.println(tree.findSourcesForWord("c"));
	}
}
