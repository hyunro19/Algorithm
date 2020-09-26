package jv.custom_library;

import java.util.*;

public class CombAndPerm {

	public static void main(String[] args) {
		String[] arr = {"A", "B", "C", "D"};
		int n = 3;
		boolean[] visited = new boolean[arr.length];
		Set<String> set = new HashSet<>();
//		makePerm(arr, n, set, "", visited);
		makeComb(arr, n, set, "", 0);
		for(String s : set) {
			System.out.println(s);
		}

	}
	
	public static void makePerm(String[] arr, int n, Set<String> set, String str, boolean[] visited) {
		if(n==0) {
			set.add(str);
			return;
		}
		
		for(int i=0; i<arr.length; i++) {
			if(visited[i]==true) {
				continue;
			} else {
				visited[i] = true;
				makePerm(arr, n-1, set, str+arr[i], visited);
				visited[i] = false;
			}
		}		 
	}
	
	public static void makeComb(String[] arr, int n, Set<String> set, String str, int idx) {
		if(n==0) {
			set.add(str);
			return;
		}
		if(idx>=arr.length) return;
		
		// 넣을 때
		makeComb(arr, n-1, set, str+arr[idx], idx+1);
		
		// 안넣을 때
		makeComb(arr, n, set, str, idx+1);
	}
}
