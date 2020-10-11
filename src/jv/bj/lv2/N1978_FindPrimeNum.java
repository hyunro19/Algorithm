package jv.bj.lv2;

import java.util.*;

public class N1978_FindPrimeNum {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String nextLine = sc.nextLine();
		nextLine = sc.nextLine();
		String[] split = nextLine.split(" ");
		Map<String, Boolean> map = new HashMap<>();
		int cnt = 0;
		for(String s : split) {
			Boolean isPrime = map.get(s);
			if(isPrime==null) {
				isPrime = isPrime(Integer.parseInt(s));
				map.put(s, isPrime);
			}
			if(isPrime) {
				++cnt;
			}
		}
		System.out.println(cnt);
		sc.close();
	}

	public static boolean isPrime(int input) {
	  	if(input==1) return false;

	  	for(int i=2; i<=Math.sqrt(input); i++) {
	  		if(input%i==0)
				return false;
	  	}        

	    return true;
	}
}
