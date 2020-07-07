package lan_java.prbm_heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class DiskController {

	public static void main(String[] args) {
		int[][] jobs = {{0, 3}, {2, 6}, {1, 9}, {2, 4}, {25, 5}, {35, 5}};
		int answer = solution(jobs);
		System.out.println(answer);
	}
	
    public static int solution(int[][] jobs) {
//    	for(int[] job: jobs) System.out.println(job[0]+", "+job[1]);
    	
    	Arrays.parallelSort(jobs, new Comparator<int[]>() {
	    		@Override
	    		public int compare(int[] a, int[] b) {
	    			return a[0]==b[0] ? a[1]-b[1] : a[0]-b[0];
	    		}    		
	    	});
//    	System.out.println("");
//    	for(int[] job: jobs) System.out.println(job[0]+", "+job[1]);
//    	System.out.println("");

    	
    	PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
	    		@Override
	    		public int compare(int[] a, int[] b) {
	    			return a[1]==b[1] ? a[0]-b[0] : a[1]-b[1];
	    		}    		
	    	}
    	);
//    	for(int[] job: jobs) pq.add(job);
//    	while(!pq.isEmpty())  {
//    		int[] job = pq.poll();
//    		System.out.println(job[0]+", "+job[1]);
//    	}
    	
    	// ��Ƴ� �켱 �� ���� �ϳ��� �۾��� ��û�� ���´ٰ� ��������
    	// ���ÿ� ���� ���� ��û���� ��...
    	int currentMs = 0;
    	int eachTimes = 0;
    	for(int[] job: jobs) {
    		if(currentMs<job[0]) {
    			while(currentMs<job[0] && !pq.isEmpty()) {
        			int[] tempJob = pq.poll();
//        			System.out.println(tempJob[0]+", "+tempJob[1]);
        			eachTimes+= currentMs>tempJob[0] ? currentMs-tempJob[0] : 0;
        			eachTimes+= tempJob[1];
        			currentMs= Math.max(currentMs+tempJob[1], tempJob[0]+tempJob[1]); 				
    			}
    		}
    		pq.add(job);
    	}
    	while(!pq.isEmpty()) {
			int[] tempJob = pq.poll();
//			System.out.println(tempJob[0]+", "+tempJob[1]);
			eachTimes+= currentMs>tempJob[0] ? currentMs-tempJob[0] : 0;
			eachTimes+= tempJob[1];
			currentMs= Math.max(currentMs+tempJob[1], tempJob[0]+tempJob[1]);    				
    	}
    	
    	return eachTimes/jobs.length;
    }

}
