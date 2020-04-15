package prbm_dp;

import java.util.Arrays;

public class IntegerTriangle {

	public static void main(String[] args) {
		int[][] triangle = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
		System.out.println(solution3(triangle));
	}
    public static int solution(int[][] triangle) {
    	int lenOut = triangle.length;
    	for(int i=1; i<lenOut; i++) {
    		int lenIn = triangle[i].length;
    		for(int j=0; j<lenIn; j++) {
    			if(j==0) 
    				triangle[i][j] += triangle[i-1][j];
    			else if (j==lenIn-1) 
    				triangle[i][j] += triangle[i-1][j-1];
    			else 
    				triangle[i][j] = Math.max(
    						triangle[i][j]+triangle[i-1][j-1], 
    						triangle[i][j]+triangle[i-1][j]	);
    		}
    	}
    	int answer=0;
    	for(int i=0; i<lenOut; i++)
    		if(triangle[lenOut-1][i]>answer) answer=triangle[lenOut-1][i];
    	
        return answer;
    }
    
    // 깔끔한 다른사람 코드.
    // innerLoop에서 처음과 마지막은 따로 계산해주고 loop는 처음과 마지막을 제외하고 돌려줬다.
    // 마지막에 최댓값도 stream사용해서 뽑아내서 코드가 간결.
    public int solution2(int[][] triangle) {
        for (int i = 1; i < triangle.length; i++) {
            triangle[i][0] += triangle[i-1][0];
            triangle[i][i] += triangle[i-1][i-1];
            for (int j = 1; j < i; j++) 
                triangle[i][j] += Math.max(triangle[i-1][j-1], triangle[i-1][j]);
        }

        return Arrays.stream(triangle[triangle.length-1]).max().getAsInt();
    }
    
    // 내 답안을 조금 더 간결하게
    public static int solution3(int[][] triangle) {
    	int lenOut = triangle.length;
    	for(int i=1; i<lenOut; i++) {
    		int lenIn = triangle[i].length-1;
    		// 처음과 마지막을 loop에서 밖으로 빼냈다.
    		triangle[i][0] += triangle[i-1][0];
    		triangle[i][lenIn] += triangle[i-1][lenIn-1];
    		for(int j=1; j<lenIn; j++)
				triangle[i][j] = Math.max(	triangle[i][j]+triangle[i-1][j-1], 
											triangle[i][j]+triangle[i-1][j]		);
    	}
    	int answer=0;
    	for(int i=0; i<lenOut; i++)
    		if(triangle[lenOut-1][i]>answer) answer=triangle[lenOut-1][i];
    	
        return answer;
    }
}
