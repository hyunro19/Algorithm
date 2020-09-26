package jv.bj.lv3;

import java.util.Scanner;

public class Fibonacci {

	public static void main(String[] args) throws Exception {
		Scanner s = new Scanner(System.in);
		int num = s.nextInt();
		for(int i=0; i<num; i++) {
			int[] cnt = new int[2]; // 0출력 횟수, 1출력횟수
			int n = s.nextInt();
			fibonacci(n, cnt);
			System.out.println(cnt[0]+" "+cnt[1]);			
		}

	}
	
	public static int fibonacci(int n, int[] cnt) {
	    if (n == 0) {
//	        System.out.println("0");
	        return 0;
	    } else if (n == 1) {
//	    	System.out.println("0");
	        return 1;
	    } else {
	        return fibonacci(n-1, cnt) + fibonacci(n-2, cnt);
	    }
	}

}
