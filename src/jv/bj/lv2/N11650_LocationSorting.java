package jv.bj.lv2;

import java.util.*;

public class N11650_LocationSorting {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);				
		int nextInt = Integer.parseInt(sc.nextLine());
		ArrayList<int[]> list = new ArrayList<>(nextInt);
		for(int i=0; i<nextInt; i++) {
			String nextLine = sc.nextLine();
			String[] split = nextLine.split(" ");
			int[] loc = {Integer.parseInt(split[0]), Integer.parseInt(split[1])}; 
			list.add(loc);
		}
		StringBuilder sb = new StringBuilder();
		list.stream().sorted((a, b) -> {
			if(a[0]==b[0]) return a[1]-b[1];
			else return a[0]-b[0];
		}).forEach(a -> sb.append(a[0]).append(" ").append(a[1]).append("\n"));
		System.out.println(sb);
		sc.close();
	}

}
