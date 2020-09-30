package jv.bj.lv2;

import java.util.*;

public class N1081_WordSorting {

	// 조건에 따라 정렬하여 단어들을 출력한다. 
	// 단, 같은 단어가 여러 번 입력된 경우에는 한 번씩만 출력한다.	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        String nextLine = sc.nextLine();
		Set<String> set = new HashSet<>();
		while(sc.hasNext()) {
			nextLine = sc.nextLine();
			set.add(nextLine);
		}
		String[] arr = set.toArray(new String[set.size()]);
		
		Arrays.parallelSort(arr, new Comparator<String>() {
			@Override
			public int compare(String a, String b) {
				if(a.length()==b.length()) return a.compareTo(b);
				else return a.length()-b.length();
			}
		});		
		
		for(String str : arr) System.out.println(str);
		sc.close();
	}

}
