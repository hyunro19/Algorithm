package prbm_stackqueue;

import java.util.LinkedList;
import java.util.Queue;

public class Printer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public static int solution(int[] priorities, int location) {
    	int cnt=0;
    	int max=0;
    	Queue<Integer> queue = new LinkedList<Integer>();
    	for(int i : priorities) {
    		if(i>max) max=i;
    		queue.offer(i);
    	}
    	while(location >= 0) {
    		if(queue.peek()==max) {
            	queue.poll();
            	++cnt;
            	--location;
            	max=0;
            	for(int i: queue) if(i>max) max=i;            	
            } else {
            	queue.offer(queue.poll());
            	if(--location == -1) location = queue.size()-1;
            }    		
    	}
    	return cnt;
        
    }
}
