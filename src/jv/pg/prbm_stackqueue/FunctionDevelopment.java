package jv.pg.prbm_stackqueue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class FunctionDevelopment {

	public static void main(String[] args) {
//		int[] progresses = {93, 30, 55};
//		int[] speeds = {1, 30, 5};
//		int[] progresses = {99, 98, 97, 96, 96, 95, 95};
		int[] progresses = {95, 96, 97, 98, 99, 95, 96};
		int[] speeds = {1, 1, 1, 1, 1, 1 ,1};
		int[] answer = solution2(progresses, speeds);
		System.out.print("answer : ");
		for(int i=0; i<answer.length; i++) {
			System.out.print(answer[i]+" ");
		}

	}
	
    public static int[] solution(int[] progresses, int[] speeds) {
    	Queue<Task> queue = new LinkedList<Task>();
    	ArrayList<Integer> answerInteger = new ArrayList<>();
    	
    	for(int i=0; i<progresses.length; i++) {
    		queue.offer(new Task(progresses[i], speeds[i]));
    	}
    	while(queue.size()>0) {
    		for(Task task: queue) {
    			task.aDayPassed();
    		}
    		
    		if(queue.peek().progress>=100) {
    			int cnt=0;
    			for(Task task: queue) {
    				if(task.progress>=100) ++cnt;
    				else break;
    			}
    			for(int i=0; i<cnt; i++) {
    				queue.poll();
    			}
    			answerInteger.add(cnt);
    		}    		    		
    	}
    	int[] answerInt = new int[answerInteger.size()];
    	for(int i=0; i<answerInteger.size(); i++) {
    		answerInt[i]=answerInteger.get(i);
    	}
        return answerInt;
    }
    
    public static int[] solution2(int[] progresses, int[] speeds) {
    	int[] daysTaken = new int[progresses.length];
    	System.out.print("daysTaken : ");
    	for(int i=0; i<daysTaken.length; i++) {
    		if((double)(100-progresses[i])%speeds[i] == 0) daysTaken[i] = (100-progresses[i])/speeds[i];
    		else daysTaken[i] = (100-progresses[i])/speeds[i]+1;
    		System.out.print(daysTaken[i]+" ");
    	}
    	System.out.println("");
    	ArrayList<Integer> answerInteger = new ArrayList<>();
    	int cnt=1;
    	int max=daysTaken[0];
    	for(int i=1; i<daysTaken.length; i++) {
    		if(max>=daysTaken[i]) {
    			++cnt;
    			System.out.println(cnt);
    		} else {
    			max=daysTaken[i];
    			answerInteger.add(cnt);
    			cnt=1;	
    		}
    		if(i==daysTaken.length-1) answerInteger.add(cnt);
    	}
    	int[] answerInt = new int[answerInteger.size()];
    	for(int i=0; i<answerInteger.size(); i++) {
    		answerInt[i]=answerInteger.get(i);
    	}
        return answerInt;
    }
    
    public static int[] solution3(int[] progresses, int[] speeds) {
        int[] dayOfend = new int[100];
        int day = -1;
        for(int i=0; i<progresses.length; i++) {
            while(progresses[i] + (day*speeds[i]) < 100) {
                day++;
            }
            dayOfend[day]++;
        }
        return Arrays.stream(dayOfend).filter(i -> i!=0).toArray();
    }
}

class Task {
	int progress;
	int speed;
	
	public Task(int start, int speed) {
		this.progress = start;
		this.speed = speed;
	}
	
	public void aDayPassed() {
		progress+=speed;
	}	
}