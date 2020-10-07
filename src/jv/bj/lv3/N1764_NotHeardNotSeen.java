package jv.bj.lv3;

import java.util.*;

public class N1764_NotHeardNotSeen {
	// Set NotHeard를 만들어서 읽어들이면서 모두 넣는다.
	// Set NotHeardNotSeen을 만들어서 NotHeard.contains()면 넣는다.
	// Set을 배열로 바꾸고 정렬하여 출력
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String nextLine = sc.nextLine();
		String[] split = nextLine.split(" ");
		int numOfNotHeard = Integer.parseInt(split[0]);
		int numOfNotSeen = Integer.parseInt(split[1]);

		Set<String> notHeard = new HashSet<>();
		Set<String> notHeardNotSeen = new HashSet<>();
		for(int i=0; i<numOfNotHeard; i++) {
			nextLine = sc.nextLine();
			notHeard.add(nextLine);
		}
		
		for(int i=0; i<numOfNotSeen; i++) {
			nextLine = sc.nextLine();
			if(notHeard.contains(nextLine))
				notHeardNotSeen.add(nextLine);			
		}
		
		String[] array = notHeardNotSeen.toArray(new String[notHeardNotSeen.size()]);
		Arrays.parallelSort(array);
		System.out.println(array.length);
		for(String str : array) System.out.println(str);
		
		sc.close();
	}

}
