package prbm_stackqueue;

import java.util.LinkedList;
import java.util.Queue;

public class BridgePassingTruck {

	public static void main(String[] args) {
		System.out.println(
				solution(2, 
						10, 
						new int[]{1,4,5,6})
				);

	}

    public static int solution(int bridge_length, int weight, int[] truck_weights) {
    	// 트럭 1대가 지나는 시간은 무조건 bridge_length+1
    	// 분명 Queue쓰는 문젠데, 정해진 순서로만 건너가는게 포인트
    	Queue<Truck> queue = new LinkedList<Truck>();
    	
    	int totalTruck = truck_weights.length;    	
    	int sec=0;
    	int beforeIndex = 0;
    	int afterIndex = 0;
    	int onBridge=0;
    	
    	while(beforeIndex<totalTruck) {
    		++sec;
    		for(Truck truck : queue) {
    			truck.sec+=1;
    		}
    		if(queue.peek()!=null && queue.peek().sec>bridge_length) {
    			queue.remove();
    			onBridge-=truck_weights[afterIndex];
    			++afterIndex;
    		}
    		if(onBridge+truck_weights[beforeIndex] <= weight) {
    			queue.offer(new Truck());
    			onBridge+=truck_weights[beforeIndex];
    			++beforeIndex;
    		}
    	}    	    
    	return sec+bridge_length;
    }

}

class Truck {
	int sec=1;
}
