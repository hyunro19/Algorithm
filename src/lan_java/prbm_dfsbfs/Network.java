package lan_java.prbm_dfsbfs;

import java.util.LinkedList;
import java.util.Queue;

public class Network {

	public static void main(String[] args) {
//		int n = 3;
//		int[][] computers = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
		int n = 3;
		int[][] computers = {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}};
		
		System.out.println(solution(n, computers));

	}
	
    public static int solution(int n, int[][] computers) {
    	int NOT_YET = 0;
    	int VISITED = 1;
    	int CONNECTED = 1;
    	int cnt=0;
    	int[] visited = new int[n]; // 0 not yet, 1 visited
    	Queue<Integer> queue = new LinkedList<>();
    	for(int i=0; i<n; i++) {
    		if(visited[i]==NOT_YET) {
    			queue.offer(i);
    			visited[i]=VISITED;
    			while(queue.size()>0) {
        			int j = queue.poll();
        			int[] temp = computers[j];
        			for(int k=0; k<n; k++) {
        				if(temp[k]==CONNECTED && visited[k]==NOT_YET) {
        					queue.offer(k);
        					visited[k]=VISITED;
        				}
        			}
        		}
    			++cnt;
    		}
    	
    	}
    	
    	return cnt;
    }

}