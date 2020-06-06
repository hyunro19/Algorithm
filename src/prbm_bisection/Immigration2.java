package prbm_bisection;

import java.util.Arrays;
import java.util.LinkedList;

public class Immigration2 {

	public static void main(String[] args) {
//		int[] times = {7, 10};
//		int n = 6;
		
		int[] times = {7};
		int n = 10;
		
//		int[] times = {7, 10, 16, 10, 7};
//		int n = 3;
		System.out.println(solution3(n, times));
	}
	
    public static long solution(int n, int[] times) {
//    	Arrays.parallelSort(times);
    	long[] queues = new long[times.length];
    	for(int i=0; i<times.length; i++)
    		queues[i]=times[i];

        while(n>0) {
        	System.out.println("n: "+n);
        	for(int i=0; i<times.length-1; i++) {
        		if(times[i]+queues[i]<times[i+1]+queues[i+1]) {
        			queues[i]+=times[i];
        			--n;
        			System.out.println("i, q[i] : "+i+", "+queues[i]);
        			break;
        		} else {
        			queues[i+1]+=times[i+1];
        			--n;
        			System.out.println("i, q[i] : "+(i+1)+", "+queues[i+1]);
        			break;
        		}
        	}
        }
        long max = queues[0];
        for(int i=1; i<queues.length; i++)
            if(queues[i]>max) max=queues[i];

        return max;
    }
    
    public static long solution2(int n, int[] times) {
    	if(times.length==1) {
    		long answer = 0;
    		for(int time: times) answer+=time;
    		return answer;
    	}
    	
    	Arrays.parallelSort(times);
//    	long[] queues = new long[times.length];
    	LinkedList<Box> queues = new LinkedList<>();
    	for(int i=0; i<times.length; i++) {
    		queues.add(new Box(times[i], times[i]));
    		System.out.println(times[i]);
    	}
        while(n>0) {
        	System.out.println(n);
        	int min = 0;
        	int max = times.length-1;
        	int mid = (min+max)/2;
        	
        	Box box = queues.get(0);
        	box.totalTime+=box.time;
        	int cnt=0;
        	while(mid!=times.length ||!(queues.get(mid).totalTime<box.totalTime && box.totalTime<=queues.get(mid+1).totalTime)) {
        		System.out.println("n : "+n+", mid : "+mid);
        		System.out.print("before");
            	for(int i=0; i<times.length; i++) System.out.print(queues.get(i).totalTime+" ");
            	System.out.println("");
        		if(box.totalTime<queues.get(mid).totalTime) {
        			max=mid-1;
        			mid = (min+max)/2;  
        			System.out.println("box<mid : min, mid, max : "+min+", "+mid+", "+max);
        		} else {//if(queues.get(mid).totalTime<box.totalTime) {
        			min=mid+1;
        			mid = (min+max)/2;
        			System.out.println("mid<box : min, mid, max : "+min+", "+mid+", "+max);
        		}
        		if(++cnt>10) break;
        	}
    		queues.add(mid+1, box);
    		queues.pollFirst();
        	--n;
        	System.out.print("after");
        	for(int i=0; i<times.length; i++) System.out.print(queues.get(i).totalTime+" ");
        	System.out.println("");
        }
        
        System.out.println("answer : ");
        return queues.peekLast().totalTime-queues.peekLast().time;
    }
    
    public static long solution3(int n, int[] times) {
    	
    	Arrays.parallelSort(times);
    	long[] queues = new long[times.length];
    	for(int i=0; i<times.length; i++)
    		queues[i] = times[i];
    	
    	while(n>0) {
        	queues[0]+=times[0];
        	long temp = queues[0];
    		for(int i=0; i<times.length-1;i++) {
    			if(queues[i]>queues[i+1]) {
    				long tempLong = queues[i+1];
    				queues[i+1] = queues[i];
    				queues[i] = tempLong;
    				
    				int tempInt = times[i+1];
    				times[i+1] = times[i];
    				times[i] = tempInt;
    			} else {
    				break;
    			}
    		}
    		--n;    		
    	}
    	for(int i=0; i<times.length; i++)
    		queues[i] -= times[i];
    	
    	long max=queues[0];
    	for(int i=1; i<times.length; i++)
    		if(queues[i]>max) max=queues[i];
    	
    	return max;

    }

}

class Box {
	int time;
	long totalTime;
	public Box(int time, long totalTime) {
		this.time = time;
		this.totalTime = totalTime;		
	}
}
