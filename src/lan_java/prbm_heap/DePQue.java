package lan_java.prbm_heap;

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
    
    // ���� �׳� ��ũ�帮��Ʈ�� ���Ľ��Ѽ� ����ߴµ�, PQ2���� ������ ����� Ǯ�̰� ����.
}
