package thry_trie;

public class Trie {
	static TrieNode nRoot;
	static TrieNode node;
	static String s;
	static String[] nArr;
	static char c;
	
	public static void main(String[] args) {
		nRoot = new TrieNode();
		node = nRoot;
		for(int i=0; i<n; ++i) {
			node = nRoot;
			s = nArr[i];
			for(int j=0; j<s.length(); ++j) {
				c = s.charAt(j);
				if(node.child[c - 'a'] == null) {
					node.child[c - 'a'] = new TrieNode();
				}
				if(j == s.length()-1) {
					node.isTerminal = true;
				}else {						
					node = node.child[c-'a'];
				}
			}
		}
	}
}

class TrieNode{
	TrieNode[] child;
	boolean isTerminal;
	
	public TrieNode() {
		this.child = new TrieNode[26];
		this.isTerminal = false;
	}
}

class Node{
	Node[] subs;
	boolean isEnd;
	
	public Node() {
		this.subs = new Node[26];
		this.isEnd = false;
	}
}

