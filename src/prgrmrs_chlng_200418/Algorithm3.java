package prgrmrs_chlng_200418;

import java.util.Arrays;

public class Algorithm3 {
	static int[] num;
	static int diff;
	static boolean possible;
	
	public static void main(String[] args) {
//		int[] numbers = {10, 20, 15, 35};
		int[] numbers = {3, 7, 2, 8, 6, 4, 5, 1};
		int K = 3;
		
		System.out.println(solution(numbers, K));
	}
	
    public static int solution(int[] numbers, int K) {
    	num = numbers;
    	diff = K;
    	
    	// �־��� ���ڰ� 1���� ���
    	if(numbers.length==1) return 0;
    	
    	// �̹� ������ �����ϴ� ���
    	if(getMaxDiff(numbers)<=diff) return 0;
    	
    	// �� ���� swap�� �ϴ��� ������ ������ �� ���� ���
    	int[] numbers2 = Arrays.copyOf(numbers, numbers.length);
        Arrays.parallelSort(numbers2);
        if(getMaxDiff(numbers2)>diff) return -1;
        
        // ���� ��츦 ����ߴٸ� swap�� ������ ���� �� ���� ���� ���� (���ѷ���X)
        int i=0;
        while(possible!=true)
        	dfs(0, ++i);
        
        return i;
    }
    
    public static void dfs(int depth, int cnt) {
    	if(depth==cnt)    		
    		if(getMaxDiff(num)<=diff) possible=true;    		
    			    	
    	for(int i=0; i<num.length-1; i++) {
    		for(int j=i+1; j<num.length; j++) {
    			swap(i, j);
    			if(swappable(i, j)) dfs(depth+1, cnt);
    			swap(i, j);    			
    		}
    	}
    }
    
    public static void swap(int i, int j) {
    	int temp = num[i];
    	num[i] = num[j];
    	num[j] = temp;
    }
    
    public static boolean swappable(int i, int j) {
    	if(i==0 && j==num.length-1) {
    		if(Math.abs(num[i]-num[i+1])<=diff 
				&& Math.abs(num[j-1]-num[j])<=diff) 
    			return true;
    	} else if (i==0) {
    		if(Math.abs(num[i]-num[i+1])<=diff 
				&& Math.abs(num[j]-num[j+1])<=diff 
				&& Math.abs(num[j]-num[j-1])<=diff)
    			return true;
    	} else if (j==num.length-1) {
    		if(Math.abs(num[j]-num[j-1])<=diff 
				&& Math.abs(num[i]-num[i-1])<=diff 
				&& Math.abs(num[i]-num[i+1])<=diff) 
    			return true;
    	} else {
    		if(Math.abs(num[j]-num[j+1])<=diff 
				&& Math.abs(num[j]-num[j-1])<=diff 
				&& Math.abs(num[i]-num[i-1])<=diff 
				&& Math.abs(num[i]-num[i+1])<=diff) 
    			return true;
    	}
    	return false;    	
    }
    
    public static int getMaxDiff(int[] numbers) {
        int maxDiff = 0;
        for(int i=0; i<numbers.length-1; i++) {
        	int diff = Math.abs(numbers[i+1]-numbers[i]);
        	if(diff>maxDiff) maxDiff=diff;
        }    	
    	return maxDiff;
    }

}
