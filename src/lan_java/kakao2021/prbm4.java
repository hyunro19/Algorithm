package lan_java.kakao2021;
import java.util.*;
public class prbm4 {

	public static void main(String[] args) {
		// CASE 1 // 82
		int n = 6, s = 4, a = 6, b = 2;
		int[][] fares = { { 4, 1,10}, { 3, 5,24},{ 5,6 ,2},{ 3, 1,41},{ 5, 1,24},{ 4, 6,50},{ 2, 4,66},{ 2, 3,22},{ 1, 6,25}, };
		
		// CASE 2 // 14
//		int n = 7, s = 3, a = 4, b = 1;
//		int[][] fares = { {5,7,9}, {4,6,4}, {3,6,1}, {3,2,3}, {2,1,6}};
		
		// CASE 3 // 18
//		int n = 6, s = 4, a = 5, b = 6;
//		int[][] fares = {{2,6,6},{6,3,7},{4,6,7},{6,5,11},{2,5,12},{5,3,20},{2,4,8}};
		solution(n, s, a, b, fares);
	}	
	
    public static int solution(int n, int s, int a, int b, int[][] fares) {
    	// 연결행렬
    	Map<Integer, Integer>[] map = new HashMap[n+1];
    	
    	
//    	int[][] maps = new int[n+1][n+1];
    	for(int[] f : fares) {
    		int oneNode = f[0];
    		int twoNode = f[1];
    		int fare = f[2];
    		
    		if(map[oneNode]==null) map[oneNode] = new HashMap<Integer, Integer>();
    		if(map[twoNode]==null) map[twoNode] = new HashMap<Integer, Integer>();
    		
    		map[oneNode].put(twoNode, fare);
    		map[twoNode].put(oneNode, fare);
    	} // 연결배열 완료
    	    	
    	int[] fromA = new int[n+1];
    	int[] fromB = new int[n+1];
    	int[] fromS = new int[n+1];

    	find(fromA, map, a);
    	find(fromB, map, b);
    	find(fromS, map, s);
    	
//    	for(int ai=1; ai<n+1; ai++) System.out.print("a->"+ai+" "+fromA[ai]+" / ");
//    	System.out.println("");
//    	for(int ai=1; ai<n+1; ai++) System.out.print("b->"+ai+" "+fromB[ai]+" / ");
//    	System.out.println("");
//    	for(int ai=1; ai<n+1; ai++) System.out.print("s->"+ai+" "+fromS[ai]+" / ");
//    	System.out.println("");
    	
    	int min = 100000;
    	for(int i=1; i<n+1; i++) {
    		if(i!=s && fromS[i]==0) continue;
    		int temp = fromS[i]+fromA[i]+fromB[i];
    		if(temp<min) min = temp;
    	}
    	System.out.println(min);
        return min;
    }
    public static void find(int[] fromX, Map<Integer, Integer>[] map, int x) {
    	Queue<Integer> q = new LinkedList<>();
    	q.add(x);
    	while(q.size()>0) {
    		int from = q.poll();
    		Map<Integer, Integer> fromMap = map[from];
        	for(Integer i : fromMap.keySet()) {
        		// 0이면 자기꺼 + 나랑의 비용을 넣음
        		// 값이 있는데 자기꺼 + 나랑의 비용보다 크면 바꿔넣음 // q에 넣음
        		// 값이 있는데 자기꺼+나랑의 비용보다 같거나 작으면 pass // q에도 안넣음
        		
        		// 자기꺼 + 나부터의 비용
        		int cost = fromX[from]+fromMap.get(i);
        		
        		if(i==x) continue;
        		if(fromX[i] == 0 || fromX[i] > cost ) {
        			fromX[i] = cost;
        			q.add(i);
        			
        		} else if (fromX[i] < cost) {
        			continue;
        		}        		     		
        	}    		
    	}    	
    }
	

}
