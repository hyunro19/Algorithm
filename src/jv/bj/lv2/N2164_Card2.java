package jv.bj.lv2;

import java.util.*;

public class N2164_Card2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int nextInt = sc.nextInt();
		sc.close();
		LinkedList<Integer> deck = new LinkedList<>();
		for(int i=1; i<=nextInt; i++)
			deck.offer(i);
		
		while(deck.size()>1)
			process(deck);
		
		System.out.println(deck.peek());
	}
	
	public static void process(LinkedList<Integer> deck) {
		// throw-away
		deck.poll();
		
		// move to btm
		deck.offer(deck.poll());
	}

}
 