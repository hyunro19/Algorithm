package prbm_heap;

import java.util.LinkedList;

public class DePQue {

	public static void main(String[] args) {
		
	}
	
    public static int[] solution(String[] operations) {
    	LinkedList<Integer> ll = new LinkedList<>();
    	
    	for(String op : operations) {
    		String[] commands = op.split(" ");
    		if(commands[0].equals("I")) {
    			insert(ll, Integer.parseInt(commands[1]));
    		} else {
    			if(ll.isEmpty()) continue;
    			
    			if(commands[1].equals("1")) {
    				ll.pollLast();
    			} else {
    				ll.pollFirst();
    			}
    		}
    	}
    	
    	if(ll.isEmpty())
    		return new int[]{0, 0};
    	else
    		return new int[] {ll.peekLast(), ll.peekFirst()};
    }
    
    public static void insert(LinkedList<Integer> ll, int n) {
    	int i=0;
    	for(int element : ll) {
    		if(element>n) break;
    		i++;
    	}
    	ll.add(i, n);    	
    }
    
    // 나는 그냥 링크드리스트를 정렬시켜서 사용했는데, PQ2개를 가지고 사용한 풀이가 많다.
}
