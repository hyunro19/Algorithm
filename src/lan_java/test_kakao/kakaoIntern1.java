package lan_java.test_kakao;

public class kakaoIntern1 {

	public static void main(String[] args) {


	}
	
    public static String solution(int[] numbers, String hand) {
    	boolean isLeftHanded = true;
    	if(hand.equals("right")) isLeftHanded = false;
    	StringBuilder sb = new StringBuilder();
    	int currentL = 10; // *
    	int currentR = 12; // #
    	
    	for(int num : numbers) {
    		if(num == 1 || num == 4 || num == 7) {
    			currentL = num;
    			sb.append("L");
    			
    		} else if (num == 3 || num == 6 || num == 9) {
    			currentR = num;
    			sb.append("R");
    			
    		} else {
    			if(num==0) num=11;
    			int distanceFromL;
    			int distanceFromR;
    			if(Math.abs(currentL-num)%3==0)
    				distanceFromL = Math.abs(currentL-num)/3;
    			else 
    				distanceFromL = Math.abs(currentL+1-num)/3+1;
    			
    			if(Math.abs(currentR-num)%3==0)
    				distanceFromR = Math.abs(currentR-num)/3;
    			else 
    				distanceFromR = Math.abs(currentR-1-num)/3+1;
    			
    			if(distanceFromL==distanceFromR) {
    				if(isLeftHanded) {
    					currentL = num;
    					sb.append("L");
    				} else {
    					currentR = num;
    					sb.append("R");
    				}
    				
    			} else if (distanceFromL < distanceFromR ){
					currentL = num;
					sb.append("L");
    				
    			} else { // distanceFromL > distanceFromR
					currentR = num;
					sb.append("R");
    			}
    					
    		}
    	}
        String answer = sb.toString();
        return answer;
    }

}
