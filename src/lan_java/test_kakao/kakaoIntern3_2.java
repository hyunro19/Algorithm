package lan_java.test_kakao;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class kakaoIntern3_2 {

	public static void main(String[] args) {
		// ���� ����ǰ� �ٽ� Ǯ� �ڵ�
		// Hashing����ؼ� Ǯ���µ�, ���߿� ���α׷��ӽ��� ���� �ö���� ������Ѻ� ����
		
		
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
    		
    		if(num==0) { // ���ο� ������ �߰��ƴٸ�,
    			tempAns[1] = i;
    			ans[0] = tempAns[0];
    			ans[1] = tempAns[1];
    		}
    		m.put(gems[i], num+1); // map�� ���� �߰�
    		
    		while(m.get(q.peek())>1) { // 2�� �̻� �����Ƿ� ���� ��� ���� �� 
    			// ���� �������� 1���� �����ٴ� ���̹Ƿ�
    			// 2��� ��� �ϳ��� �� �߰��ƴٴ� ��. 
    			// ��, gems[i]==q.peek()
    			String g = q.poll();
    			m.put(g, m.get(g)-1); // q���� ����, map������ ���� ����
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
