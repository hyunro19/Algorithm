package lan_java.prbm_greed;

import java.util.Deque;
import java.util.LinkedList;

public class JoyStick {

	public static void main(String[] args) {
//		System.out.println("A : "+(int)'A');
//		System.out.println("L : "+(int)'L');
//		System.out.println("M : "+(int)'M');
//		System.out.println("N : "+(int)'N');
//		System.out.println("O : "+(int)'O');
//		System.out.println("Z : "+(int)'Z');
//		System.out.println(65%26);
//		System.out.println(90%26);
		System.out.println(solution("JEROEN")); // 56
		System.out.println(solution("JAN")); // 23
		System.out.println(solution("NNNN")); // 55
	}
	
    public static int solution(String name) {
    	int length = name.length();
    	int cnt=0;
    	Deque<Integer> deque = new LinkedList<Integer>();
    	
    	for(int i=0; i<length; i++) {    		
    		char c = name.charAt(i);
    		if(c!='A') {
    			if(c<=78) cnt+=(c-65);
    			else cnt+=(91-c);
    			deque.offer(i);
    		}    		    	
    	}

    	if(deque.size()==0) return cnt;	// AAAA�� ��� NullPointException �ȶ߰� ����.
    	if(deque.peekFirst()==0) deque.pollFirst();
    	
    	int crntX = 0;

    	while(deque.size()>0) {
    		int leftDistance = deque.peekFirst()-crntX;
    		if(leftDistance<0) leftDistance+=length;
    		if(leftDistance>=length) leftDistance-=length;
    		int rightDistance = length-deque.peekLast()+crntX;
    		if(rightDistance<0) rightDistance+=length;
    		if(rightDistance>=length) rightDistance-=length;
    		
    		// ���⼭ <= ��� <�� ���� 11���� ��� ���Ѵ�. ����?
    		// �ٸ������ �ȵȴٰ� �Ѵ�. �����ִµ�.
    		if(leftDistance <= rightDistance) { 
    			cnt+=leftDistance;
    			crntX = deque.pollFirst();
    		} else {
    			cnt+=rightDistance;
    			crntX = deque.pollLast();
    		}
    	}
        return cnt;
    }

}
