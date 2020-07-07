package lan_java.prbm_heap;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Hotter {

	public static void main(String[] args) {
		int[] scoville = new int[]{1, 2, 3, 9, 10, 12};
		int K = 7;
		int answer = solution(scoville, K);
		System.out.println(answer);
	}
	
    public static int solution(int[] scoville, int K) {
    	Comparator<Integer> comp = new Comparator<Integer>() {
    		@Override
    		public int compare(Integer a, Integer b) {
    			return -1;
    		};    		
    	};
    	if(K==0) return 0;
    	PriorityQueue<Integer> pq = new PriorityQueue<>(comp);
    	
    	for(int i : scoville)
    		pq.add(i);
    	
    	int cnt=0;
    	while(pq.peek() < K) {
    		if(pq.size()<=1) return -1;
    		int firstSmallest = pq.poll();
    		int secondSmallest = pq.poll();
    		int newFood = firstSmallest + secondSmallest*2;
    		pq.add(newFood);
    		++cnt;
    	}
    	
        return cnt;
    }
}
