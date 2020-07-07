package lan_java.prbm_bisection;

import java.util.Arrays;

public class Budget {

	public static void main(String[] args) {
		int[] budgets = {120, 110, 140, 150};
		int M = 485;
		System.out.println(solution(budgets, M));
	}
	
    public static int solution(int[] budgets, int M) {
    	Arrays.parallelSort(budgets);
    	
    	// ��� ���ð� ������ ��û�� ��ŭ �������� ���ϴ� ��� // TestCase9
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
        
    	// ���⼭���� �̺�Ž��
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
