package test_kakao;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class kakaoIntern3_2 {

	public static void main(String[] args) {
		// 시험 종료되고 다시 풀어본 코드
		// Hashing사용해서 풀었는데, 나중에 프로그래머스에 문제 올라오면 실행시켜볼 예정
		
		
//		String[] gems = {"A", "D", "B", "C", "C", "D", "A", "A", "D", "B", "C", "D"};
//		String[] gems = {"A", "A", "A", "A"};
//		String[] gems = {"", "", "", "", "", "", "", "", "", "", ""};
		String[] gems = {"A", "A", "A", "D", "C", "A", "B", "E", "C", "A", "A"};
		int[] ans = solution(gems);
		System.out.println(ans[0]+", "+ans[1]);
		
	}
    public static int[] solution(String[] gems) {
    	Queue<String> q = new LinkedList<>();
    	Map<String, Integer> m = new HashMap<>();
    	int[] tempAns = new int[2];
    	int[] ans = new int[2];
    	
    	for(int i=0; i<gems.length; i++) {
    		q.add(gems[i]);
    		int num = m.getOrDefault(gems[i], 0);
    		
    		if(num==0) { // 새로운 보석이 추가됐다면,
    			tempAns[1] = i;
    			ans[0] = tempAns[0];
    			ans[1] = tempAns[1];
    		}
    		m.put(gems[i], num+1); // map에 개수 추가
    		
    		while(m.get(q.peek())>1) { // 2개 이상 있으므로 빼도 상관 없을 때 
    			// 이전 루프에서 1개로 끝났다는 뜻이므로
    			// 2라면 방금 하나가 더 추가됐다는 뜻. 
    			// 즉, gems[i]==q.peek()
    			String g = q.poll();
    			m.put(g, m.get(g)-1); // q에서 빼고, map에서도 개수 감소
    			tempAns[0]++;
    			tempAns[1]++;
    		}
    		
    		if(tempAns[1]-tempAns[0] < ans[1]-ans[0]) {
    			ans[0] = tempAns[0];
    			ans[1] = tempAns[1];
    		}
    		System.out.println("------- "+i);
    		System.out.println("tempAns : "+tempAns[0]+", "+tempAns[1]);
    		System.out.println("ans : "+ans[0]+", "+ans[1]);
    	}
    	
   
    	return ans;
    }
}
