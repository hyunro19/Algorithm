package jv.pg.kakao_intern_2019_FW;

import java.util.*;

public class CrossingSteppingBridge {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] stones = null;
		int k = 0;

		int ans = solution(stones, k);
		System.out.println(ans);
	}
	
    public static int solution(int[] stones, int k) {
        int answer=0;
        Queue<Integer> que = new PriorityQueue<>(Collections.reverseOrder());
        if(stones.length<=k){
            for (int i = 0; i < stones.length; i++) {
                que.add(stones[i]);
            }
            return que.peek();
        }
        
//        ArrayList<Integer> l = Arrays.asList(stones);
//        que.addAll(Arrays.asList(stones));
//        que.addAll(Arrays.asList(stones));
//        que.addAll(Arrays.asList(stones));
        
        answer = que.peek();
        for (int i = 1; i <= stones.length-k; i++) {
            que.remove(stones[i - 1]);
            que.add(stones[i + k - 1]);
            answer = Math.min(answer, que.peek());
        }
        return answer;
    }

}
