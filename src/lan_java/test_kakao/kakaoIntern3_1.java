package lan_java.test_kakao;

import java.util.HashSet;
import java.util.Set;

public class kakaoIntern3_1 {

	public static void main(String[] args) {
		// ��Ȯ�� �׽�Ʈ SUCCESS
		// ȿ���� �׽�Ʈ FAIL
	}
	
    public int[] solution(String[] gems) {
        int[] answer = new int[2];
        answer[0] = 1;
        answer[1] = gems.length;
        int currentMin = answer[1]-answer[0];
        Set<String> gemSet = new HashSet<>();
        for(String gem : gems) {
        	gemSet.add(gem);
        }
        int kind = gemSet.size();
        
        for(int i=0; i<=gems.length-kind; i++) {
            Set<String> bag = new HashSet<>();
        	for(int j=i; j<Math.min(gems.length, i+currentMin); j++) {                                
        		bag.add(gems[j]);
        		if(bag.size()==kind) {
                    if(j-i>=currentMin) break;
        			answer[0] = i+1;
        			answer[1] = j+1;
                    currentMin=answer[1]-answer[0];
                    break;
        		}
        	}
        }

        
        return answer;
    }
}
