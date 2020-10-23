package jv.bj.lv2;

import java.util.*;

public class N1436_MovieDirectorShom {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int nth = sc.nextInt();
		int i = 0;
		int num = 665;
		while(i<nth) {
			if( hasThreeOrMoreConsecutiveSixes(++num) ) {
				i++;
			}
		}
		System.out.println(num);
		sc.close();
	}
	
	// 어떤 수에 6이 적어도 3개이상 연속으로 들어가는 수 // '연속으로' 들어가야 한다.
	public static boolean hasThreeOrMoreConsecutiveSixes(int n) {
		int cnt = 0;
		while(n>0) {
			int namoji = n%10;
			if(namoji==6) {
				cnt++;
			} else {
				cnt=0;
			}
			if(cnt>=3) return true;
			n /= 10;			
		}
		return false;
	}

}