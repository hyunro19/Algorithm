package lan_java.tutorial_goorm;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class shcard02 {

	public static void main(String[] args) throws Exception {
		// 가장 작은 수를 중심으로 왼쪽으로 퍼져나가게, 오른쪽으로 퍼져나가게 하면 되네.
		// 가장 작은 수가 여러개면? 아니구나 1을 기준으로 좌우로 나누면 된다.
		// 1이 어디에 위치하는지 파악하고 1부터 왼쪽으로 -n, -n, 다음으로는 오른쪽으로 +n, +n하면 된다.
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input1 = br.readLine();
		String input2 = br.readLine();
		// 아얘 2번째 라인은 읽을 필요도 없는 문제
		String[] splittedInput1 = input1.split(" ");
		
		int N = Integer.parseInt(splittedInput1[0]);
		int K = Integer.parseInt(splittedInput1[1]);

		// 삽질을 굉장히 많이했다.
		// /는 '몫'이다. 나머지가 있는 상황을 항상 고려하자.
		int cnt = (N-1)/(K-1);
		if((N-1)%(K-1)!=0) ++cnt;
		System.out.println(cnt+"");
		
		// String[] nums = input2.split(" ");
		// int idx = 0;
		// for(int i=0; i<N; i++) {
		// 	if(nums[i].equals("1")) {
		// 		idx = i;
		// 		break;
		// 	}
		// }
		// // 이제 i 좌우로 -> 이건 잘못, N이 7일 때, 첫 그룹을 i를 가운데 두고 좌/우로 3개씩 근묵자흑 시키는게 더 나을 수 있기 때문
		// int cnt = idx/(K-1) + (N-idx-1)/(K-1);		
		// if(idx%(K-1)!=0) ++cnt;
		// if((N-idx-1)%(K-1)!=0) ++cnt;
		// System.out.println(""+cnt);
	}
}
