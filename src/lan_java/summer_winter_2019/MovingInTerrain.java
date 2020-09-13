package lan_java.summer_winter_2019;

import java.util.Iterator;
import java.util.LinkedList;

public class MovingInTerrain {
    static int N;
	static int CNT;
    static int H;


	public static void main(String[] args) {
		// 아무 칸에서나 출발해 모든 칸을 방문하려고 한다.
		// 같은 크기의 이중배열을 선언한다.
		// 그 이중배열의 각 칸에 들어갈 값은 
		// 	1. 인접한 4칸 중 height이하인 칸이 있으면 0,
		//  2. 없으면 height차이 중 가장 작은 값
		// 배열 순회 중 A->B, B->A두 가지 중복될 수 있겠네
		// 잠깐, 위에서부터 순회해서 내려오다가, 만약 아래쪽에 있는 칸에서 연결이 되면(?) 그 구간은 연결 안해도 상관없잖아.
		// 그리고 2개 칸서로는 연결되어 있지만 주변과 고립되어 연결되어 있어도, 그 사이에 다리를 놓아야 하는데 그건 어떻게 처리하지? 

	}
	
    public int solution(int[][] land, int height) {
        H = height;
        N = land.length;
    	boolean[][] visited = new boolean[N][N];
    	int[] min = {0, 0, 10001};
    	int cost = 0;
        LinkedList<int[]> ll = new LinkedList<>();
    	while(CNT<N*N) {   
    		makeChunk(land, visited, min[0], min[1], ll);
    		boolean[][] visitedM = new boolean[N][N];        
            int idx = 0;
		    while(idx<ll.size()) {
			    int[] arr = ll.get(idx);                
                if(visited[arr[0]][arr[1]]==true){
                    ll.remove(idx);
                    continue;
                } else {
                    if(arr[2]<min[2]) {
                       min = arr; 
                    }
                     
			    }            
                idx++;
		    }
    		// getMin(land, visited, visitedM, min, min[0], min[1]);
    		if(min[2]<10001) {
    			cost+=min[2];
    			min[2] = 10001;
    		}    		
    	}
    	
    	return cost;
    }
    
    public static void makeChunk(int[][] land, boolean[][] visited, int r, int c, LinkedList<int[]> ll) {
    	visited[r][c] = true;            
    	CNT++;
    	
    	int[][] ways = {{1,0},{0,1},{-1,0},{0,-1}};    	
    	// 주변을 돌면서 방문
    	for(int[] w : ways) {
    		int nextR = r+w[0];
    		int nextC = c+w[1];
    		
    		if(nextR>=N || nextR<0 || nextC>=N || nextC<0 || visited[nextR][nextC]==true ) { 
                // matrix 밖이거나
                // 이미 방문한 경우
                
            } else { // 아직 방문하지 않은 경우 == NOT_YET                
                // gap이 큰 경우
                int gap = Math.abs(land[nextR][nextC]-land[r][c]);
                if(gap>H) {
                    int[] arr = {nextR, nextC, gap};                    
                    ll.add(arr);
                    continue;
                } else {
                    makeChunk(land, visited, nextR, nextC, ll);    
                }
            	
            }  
    	}
    }

    public static int[] getMin(int[][] land, boolean[][] visited, boolean[][] visitedM, int[] min, int r, int c) {
    	visitedM[r][c] = true;
    	int[][] ways = {{1,0},{0,1},{-1,0},{0,-1}};
    	
    	// 주변을 돌면서 방문
    	for(int[] w : ways) {
    		int nextR = r+w[0];
    		int nextC = c+w[1];
    		
    		if(nextR>=N || nextR<0 || nextC>=N || nextC<0 || visitedM[nextR][nextC]==true) { 
                // matrix 밖이거나 // 이미 방문한 경우
                continue;                
            } else { // 아직 방문하지 않은 경우  visitedM==false
            	if(visited[nextR][nextC]==false) { // visited와 not-visited의 경계부분 // 즉 gap이 H보다 큰 부분
            		int gap = Math.abs(land[r][c]-land[nextR][nextC]);
            		if(min[2]>gap) {
                        
            			min[0] = nextR;
            			min[1] = nextC;
            			min[2]=gap;
                	}
            		continue;
            	} else { // getMin은 방문하지 않았지만 makeChunk는 방문한 경우
            		getMin(land, visited, visitedM, min, nextR, nextC);
            	}
            	            		            	
            }  
    	}
    	return min;
    }
    	
}


