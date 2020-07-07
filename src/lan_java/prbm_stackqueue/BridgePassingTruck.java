package lan_java.prbm_stackqueue;

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
    	// Ʈ�� 1�밡 ������ �ð��� ������ bridge_length+1
    	// �и� Queue���� ������, ������ �����θ� �ǳʰ��°� ����Ʈ
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
