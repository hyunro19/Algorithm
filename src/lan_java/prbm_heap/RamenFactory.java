package lan_java.prbm_heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class RamenFactory {
	
	public static void main(String[] args) {
		int stock = 4;
		int[] dates = new int[] {4, 10, 10, 15, 20, 25};
		int[] supplies = new int[] {15, 5, 10, 10, 5, 1};
		int k = 30;
		
		int answer = solution(stock, dates, supplies, k);
		System.out.println(answer);
	}
	// pq���°Ŵϱ�...
	// �� heap�̳� �ٵ�..?
	

    public int solution(int stock, int[] dates, int[] supplies, int k) {
		int len = dates.length;
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		int cnt=0;
        
        // dates의 마지막 index에 해당하는 날짜까지 부족하지 않게 처리
		for(int i=0; i<len; i++) {            
			if(stock < dates[i]) {
				stock += pq.poll();
				++cnt;
			}
			pq.add(supplies[i]);
		}
		
        // 마지막 index이후에 부족하다면, 추가로 더 poll
		while(stock<k) {
			stock+=pq.poll();
			++cnt;
		}
		
        return cnt;
    }

}
