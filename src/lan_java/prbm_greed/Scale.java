package lan_java.prbm_greed;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Scale {

	public static void main(String[] args) {
//		int[] weight = {1, 2, 3, 4, 5, 6, 7, 10, 50};
		int[] weight = {3, 1, 6, 2, 7, 30, 1};
		System.out.println(solution(weight));
	}
	
	// 
    public static int solution(int[] weight) {
        int answer = 0;

        Arrays.parallelSort(weight);
        answer += weight[0];

        for (int i = 1; i < weight.length; i++) {
            if (answer+1 < weight[i]) break;
            else answer += weight[i];
        }
        
        return answer+1;
    }

}
