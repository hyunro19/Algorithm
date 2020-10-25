package jv.bj.lv2;

import java.util.*;

public class N1929_FindPrimeNums {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String nextLine = sc.nextLine();
		sc.close();
		String[] split = nextLine.split(" ");
		int min = Integer.parseInt(split[0]);
		int max = Integer.parseInt(split[1]);
		
		for(int i=min; i<=max; i++) {
			if(isPrime(i)) System.out.println(i);
		}
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
