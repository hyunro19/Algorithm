package jv.pg.kakao2019;

import java.util.HashSet;
import java.util.Set;

public class CandidateKey {
	
	public static void main(String[] args) {
		
	}
	
    public int solution(String[][] relation) {
		// 후보키군을 담을 Set
		Set<String> candidateKeys = new HashSet<String>();
		int numOfAttributes = relation[0].length;
		// 1~n까지 루프를 돌면서 후보키인지 아닌지 찾을 조합을 구한다.
		for(int i=1; i<=numOfAttributes; i++) {			
			Set<String> comb = new HashSet<String>();			
	        int[] comArr = new int[i];
	        // numOfAttributes 중 i개를 뽑는 경우
	        combination(comb, comArr, numOfAttributes, i, 0, 0);
	        
	        for(String value : comb) {
	        	if(isMinimum(candidateKeys, value) && isUnique(relation, value)) { 
                    candidateKeys.add(value);
	        	} // 아니면 pass
	        }
		}
			// Set을 돌면서 Set원소를 구성하는 숫자들이 모두 후보키인지 검사할 키 안에 있으면, 얘는 최소성을 만족 못하니 out
			// 최소성 테스트를 통과하면 각 루프 끝에 n자리 숫자 조합이 나오면 차례대로 후보키인지 아닌지 검색한다. 유일성 테스트
        
        return candidateKeys.size();
    }
    
	// comArr에 속성수만큼의 배열 0~n-1
	// 조합 n개 중 r개를 뽑는 조합 함수
    public static void combination(Set<String> set, int[] comArr, int n, int r, int index, int target) {
        if(r==0){
        	StringBuilder sb = new StringBuilder();
            for(int i : comArr) sb.append(i);
            set.add(sb.toString());
            return;
        }
        if(target == n) return;
         
        comArr[index] = target;
        combination(set, comArr, n, r-1, index+1, target+1);//뽑는경우
        combination(set, comArr, n, r, index, target+1);//안뽑는경우
         
    }
    
    public static boolean isMinimum(Set<String> candidateKeys, String value) {
        // value가 135일 때, candidateKeys에 1, 3, 5, 13, 5가 있으면
    	for(String candidate : candidateKeys) {
            int cnt = 0;
            // boolean[] flags = new boolean[value.length()];
    		for(int i=0; i<candidate.length(); i++) {
    			if(value.contains(candidate.substring(i, i+1))) 
    				++cnt;
    		}
            if (cnt==candidate.length()) return false;            
    	}    	
    	return true;
    }
    
    public static boolean isUnique(String[][] relation, String value) {
    	Set<String> set = new HashSet<>();
    	for(int i=0; i<relation.length; i++) {
    		StringBuilder sb = new StringBuilder();
    		for(int j=0; j<value.length(); j++) {
    			int idx = Integer.parseInt(value.substring(j, j+1));
    			sb.append(relation[i][idx]);
    		}
    		set.add(sb.toString());
    		
    		if(set.size()<=i) {
    			return false;
    		}
    	}
    	
    	return true;
    }
    

}
