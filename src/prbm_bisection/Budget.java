package prbm_bisection;

import java.util.Arrays;

public class Budget {

	public static void main(String[] args) {
		int[] budgets = {120, 110, 140, 150};
		int M = 485;
		System.out.println(solution(budgets, M));
	}
	
    public static int solution(int[] budgets, int M) {
    	Arrays.parallelSort(budgets);
    	
    	// 모든 도시가 예산을 신청한 만큼 배정받지 못하는 경우 // TestCase9
        if(M<budgets.length*budgets[0]) return M/budgets.length;
        
    	long cumulative = 0;
        long expected =0;
    	int min = 0;
    	int mid = budgets[budgets.length-1];
    	int max = 0;    	
    	int r = 0;
    	for(int i=1; i<budgets.length; i++) {
    		cumulative += budgets[i-1];
    		max = budgets[i];
    		expected = cumulative+max*(budgets.length-i);    
    		if(M<expected) {    			
    			min = budgets[i-1];
    			mid = (min+max)/2;
    			r=i;
    			expected = cumulative+mid*(budgets.length-r);
    			break;
    		}
    	}
        if(mid == budgets[budgets.length-1]) return mid;
        
    	// 여기서부터 이분탐색
		while(true) {
            if(expected<=M) {
				min = mid;
				mid = (min+max)/2;
			} else if(M<expected) {
				max = mid;
				mid = (min+max)/2;
			}
			expected = cumulative+mid*(budgets.length-r);
            if(expected<=M && M<expected+budgets.length-r) break;
		}
        return mid;
    }

}
