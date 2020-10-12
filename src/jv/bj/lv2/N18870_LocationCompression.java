package jv.bj.lv2;

import java.util.*;

public class N18870_LocationCompression {

	public static void main(String[] args) {
		// 문제 잘못 읽고 헛짓했네 ^^
		// 다 Set에 집어넣고, 정렬한 뒤에
		// Map에 누적합을 넣자.
		
		Scanner sc = new Scanner(System.in);
		String nextLine = sc.nextLine();
		nextLine = sc.nextLine();
		String[] split = nextLine.split(" ");
		Set<Integer> set = new HashSet<>();
		for(String str : split)
			set.add(Integer.parseInt(str));
		Integer[] keyArr = set.toArray(new Integer[set.size()]);
		Arrays.sort(keyArr);
		
		Map<Integer, Integer> cntMap = new HashMap<>();
		cntMap.put(keyArr[0], 0);
		for(int i=1; i<keyArr.length; i++)
			cntMap.put(keyArr[i], i);
		StringBuilder sb = new StringBuilder();
		for(String str : split) {
			sb.append(cntMap.get(Integer.parseInt(str))).append(" ");
		}
		System.out.println(sb.deleteCharAt(sb.length()-1));
		sc.close();
	}

}
