package test;

import java.util.ArrayList;
import java.util.Arrays;

public class ArrayCopyTest {

	public static void main(String[] args) {
//		ArrayList<Node> ar = new ArrayList<>();
//		ar.add(new Node("one"));
//		ar.add(new Node("two"));
//		ar.add(new Node("three"));
//		ar.add(new Node("four"));
//		
//		ArrayList<Node> ar2 = (ArrayList<Node>) ar.clone();
//		for(Node node : ar2) System.out.println(node.name);
//		
//		ar2.remove(3);
//		System.out.println("");
//		for(Node node : ar) System.out.println(node);
//		System.out.println("");
//		for(Node node : ar2) System.out.println(node);
		
		
//		Node[] arr = new Node[4];
//		arr[0] = new Node("one");
//		arr[1] = new Node("two");
//		arr[2] = new Node("one");
//		arr[3] = new Node("one");
//		
//		Node[] arr2 = Arrays.copyOf(arr, arr.length);
//		
//		for(Node node : arr2) System.out.println(node.name);
//		arr[2]=new Node("two");
//		
//		System.out.println("");
//		for(Node node : arr) System.out.println(node);
//		System.out.println("");
//		for(Node node : arr2) System.out.println(node);
		
		Node a = new Node("hello");
		Node b = new Node("hello");
		System.out.println(a.name==b.name);
		a.name = "michael";
		System.out.println(a.name+", "+b.name);
		
		// trie는 Node일 경우 어떻게 clone하지???
	}


}


class Node {
	String name;
	
	public Node() {
		
	}
	
	public Node(String name) {
		this.name = name;
	}
}

