package jv.bj.lv2;

import java.util.*;

public class N1920_FindNum {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String nextLine = sc.nextLine();		
		nextLine = sc.nextLine();		
		Set<String> set = new HashSet<>();
		String[] split = nextLine.split(" ");
		for(String s : split)
				set.add(s);
			
		nextLine = sc.nextLine();
		nextLine = sc.nextLine();
		String[] split2 = nextLine.split(" ");
		for(String s : split2) {
			if(set.contains(s)) {
				System.out.println(1);
			} else {
				System.out.println(0);
			}
		}
		sc.close();
	}

}
