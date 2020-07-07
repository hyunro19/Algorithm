package lan_java.prbm_bruteforce;

public class NumberBaseball {

	public static void main(String[] args) {
		int[][] baseball = {{123, 1, 1}};
		System.out.println(solution(baseball));
	}
	
    public static int solution(int[][] baseball) {
    	int[] candidates = new int[9*8*7];
    	int cnt=0;
    	for(int i=1; i<10; i++) {
        	for(int j=1; j<10; j++) {
                if(i==j) continue;
            	for(int k=1; k<10; k++) {
                    if(i==k || j==k ) continue;
            		candidates[cnt++]=100*i+10*j+k;
            	}        		
        	}    		
    	}
    	
    	int answer = 0;
    	for(int i: candidates) {
    		boolean allRoundFlag = true;
    		for(int[] round: baseball) {
    			if(!oneRound(i, round)) {
    				allRoundFlag = false;
    				break;
    			}
    		}
    		if(allRoundFlag) ++answer;
    	}        
        return answer;
    }

    	public static boolean oneRound(int ans, int[] round) {
    		int[] ansArray = {ans/100,(ans%100)/10, ans%10};
    		int[] roundArray = {round[0]/100, round[0]%100/10, round[0]%10};
			int strike = 0, ball = 0;
			
			for(int j=0; j<3; j++) {
				for(int k=0; k<3; k++) {
					if(ansArray[j]==roundArray[k]) {
						if(j==k) ++strike;
						else ++ball;
					}
				}
			}
			if(strike==round[1] && ball==round[2]) return true;    		    		
    		return false;
    	}
}
