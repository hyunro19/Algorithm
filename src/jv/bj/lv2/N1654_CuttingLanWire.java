package jv.bj.lv2;

import java.util.*;

public class N1654_CuttingLanWire {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 첫 줄 -> 이미 가지고 있는 랜선의 개수 K, 필요한 랜선의 개수 N
		String nextLine = sc.nextLine();
		String[] split = nextLine.split(" ");
		int K = Integer.parseInt(split[0]);
		int N = Integer.parseInt(split[1]);

		// K개의 랜선을 합하고 N으로 나눈 수에서부터 시작 -> int maxLen
		int[] wires = new int[K];
		for(int i=0; i<K; i++) {
			nextLine = sc.nextLine();
			wires[i] = Integer.parseInt(nextLine);
		}
		int len = 0;
		// manLen을 1씩 감소시켜가며 만들 수 있는지 확인 안되면 --&continue 되면 break
		while(isAvailable(wires, len+1, N)) {
			++len;
		};			
		System.out.println(len);
		sc.close();
	}
	
	public static boolean isAvailable(int[] wires, int len, int N) {
		int cnt = 0;
		for(int w : wires) {
			cnt += w/len;
		}
		if(cnt>=N) return true;
		return false;
	}
}