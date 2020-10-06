package jv.bj.lv3;

import java.util.Scanner;

// 정수 X에 사용할 수 있는 연산은 다음과 같이 세 가지 이다.
// 1. X가 3으로 나누어 떨어지면, 3으로 나눈다.
// 2. X가 2로 나누어 떨어지면, 2로 나눈다.
// 3. 1을 뺀다.
// 정수 N이 주어졌을 때, 위와 같은 연산 세 개를 적절히 사용해서 1을 만들려고 한다. 
// 연산을 사용하는 횟수의 최솟값을 출력하시오.

// dfs를 이용하여 재귀로 풀면 시간초과가 난다. → dp를 이용해서 풀어야 함.

public class N1463_MakeItOne {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int nextInt = sc.nextInt();
		int[] dp = new int[nextInt+1];
		if(nextInt==1) {
			dp[nextInt] = 0;
		} else if(nextInt<=3) {
			dp[nextInt] = 1; 
		} else { // nextInt>=4
			dp[1] = 0;
			dp[2] = 1;
			dp[3] = 1;
			for(int i=4; i<=nextInt; i++) {
				int divByTwo = Integer.MAX_VALUE;
				int divByThree = Integer.MAX_VALUE;
				int minusOne = dp[i-1]+1;
				
				if(i%2==0) divByTwo = dp[i/2]+1;
				
				if(i%3==0) divByThree = dp[i/3]+1;
				
				dp[i]=Math.min(minusOne, Math.min(divByTwo,  divByThree));
			}
		}
		System.out.println(dp[nextInt]);
		sc.close();
	}	

}