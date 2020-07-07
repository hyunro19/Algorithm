package lan_java.test_prgrmrs_chlng_200523;

public class Algorithm2 {
	public static void main(String[] args) {
		long n = 10L;
		Solution2 solution = new Solution2();
		long ans = solution.solution(n);
		System.out.println(ans);		
	}
	
   
}

class Solution2 {
    public long solution(long n) {
    	String binary = Long.toBinaryString(n);

    	long j=1L;
    	long answer = 0L;
        
    	for(int i=binary.length()-1; i>=0; i--) {
    		if(binary.charAt(i)=='1')
    			answer += j;
    		j*=3;
    	}
        return answer;
    }
}
