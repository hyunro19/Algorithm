package jv.bj.lv3;

import java.util.*;

public class N1074_Z {
	// 2 3 1 -> 11
	// 3 7 7 -> 63

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String nextLine = sc.nextLine();
		String[] split = nextLine.split(" ");
		
		int n = Integer.parseInt(split[0]);
		int row = Integer.parseInt(split[1]);
		int col = Integer.parseInt(split[2]);
		int cnt = 0;
		
		while(n>=0) {
			int aHalfSide = (int)Math.pow(2, n-1);
			int aQuarter = aHalfSide*aHalfSide;

			if(col>=aHalfSide) {
				cnt+=aQuarter;
				col-=aHalfSide;
			}
			
			if(row>=aHalfSide) {
				cnt+=aQuarter;
				cnt+=aQuarter;
				row-=aHalfSide;
			}
			
			--n;
		}
		
		System.out.println(cnt);		
		sc.close();
	}

}
