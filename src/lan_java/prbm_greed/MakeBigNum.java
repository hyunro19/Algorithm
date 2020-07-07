package lan_java.prbm_greed;

import java.util.Stack;

public class MakeBigNum {

	public static void main(String[] args) {
		String number = "999";
		int k = 2;
		System.out.println(solution2(number, k));		
	}
	
    public static String solution(String number, int k) {
    	StringBuilder sb = new StringBuilder();

    	int numLen = number.length();
    	int startIndex=0;
    	
    	for(int i=k; i<numLen; i++) {
    		char tempMax=number.charAt(startIndex);
    		int tempMaxIndex=startIndex;
    		for(int j=startIndex; j<=i; j++) {
    			if(number.charAt(j)>tempMax) {
    				tempMax=number.charAt(j);
    				tempMaxIndex=j;
    				
    			}
    		}
    		sb.append(number.charAt(tempMaxIndex));
    		startIndex=tempMaxIndex+1;
    	}
    	return sb.toString();  	    	
    }
    
    public static String solution2(String number, int k) {
        char[] result = new char[number.length() - k];
        Stack<Character> stack = new Stack<>();

        for (int i=0; i<number.length(); i++) {
            char c = number.charAt(i);
            while (!stack.isEmpty() && stack.peek() < c && k-- > 0) {
                stack.pop();
            }
            stack.push(c);
        }
        
        for (int i=0; i<result.length; i++) {
            result[i] = stack.get(i);
        }
        return new String(result);
    }
}
