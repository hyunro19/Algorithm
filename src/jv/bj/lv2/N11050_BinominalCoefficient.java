package jv.bj.lv2;

import java.util.*;

public class N11050_BinominalCoefficient {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String nextLine = sc.nextLine();
		String[] split = nextLine.split(" ");
		int a = Integer.parseInt(split[0]);
		int b = Integer.parseInt(split[1]);
		
		int ans = 1;
		for(int i=0; i<b; i++) {
			ans*=(a--);
		}
		for(int j=1; j<=b; j++) {
			ans/=j;
		}
		System.out.println(ans);
		sc.close();
	}

}
