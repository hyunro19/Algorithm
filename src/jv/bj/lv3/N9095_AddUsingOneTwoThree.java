package jv.bj.lv3;

import java.util.*;

public class N9095_AddUsingOneTwoThree {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int nextInt = sc.nextInt();
		int[] arr = new int[12];
		for(int i=0; i<nextInt; i++) {
			int number = sc.nextInt();
			if(arr[number]==0) arr[number]=comb(number);
			System.out.println(arr[number]);
		}
		sc.close();
	}
	public static int comb(int number) {
		int cnt = 0;
		
		int mok3 = number/3;						
		for(int i=0; i<=mok3; i++) {
			int afterThree = number-3*i;
			int mok2 = afterThree/2;
			for(int j=0; j<=mok2; j++) {
				int k = afterThree-2*j;
				
				// i, j, k의 factorial을 구해서
				int fac = factorial(i+j+k);
				fac /= factorial(i);
				fac /= factorial(j);
				fac /= factorial(k);
				cnt+=fac;
			}
		}
		
		return cnt;
	}
	
	public static int factorial(int number) {
		if(number<=1) return 1;
		
		int fac = 1;
		for(int i=2; i<=number; i++) {
			fac*=i;
		}
		return fac;
	}

}
