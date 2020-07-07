package lan_java.test_kakao;

import java.util.LinkedList;

public class kakaoIntern2 {

	public static void main(String[] args) {
		String expression = "100-200*300-500+20";
		System.out.println(solution(expression));

	}

    public static long solution(String expression) {
    	
    	LinkedList<Long> numQ = new LinkedList<>();
    	LinkedList<Character> charQ = new LinkedList<>();
    	char[][] calcComb = {{'*', '-', '+'}, 
    					{'*', '+', '-'}, 
    					{'-', '+', '*'}, 
    					{'-', '*', '+'}, 
    					{'+', '*', '-'}, 
    					{'+', '-', '*'}};
    	
    	int len = expression.length();
    	int beforeIndex = 0;
    	for(int i=0; i<len; i++) {
    		if(i == len-1) {
    			numQ.add(Long.parseLong(expression.substring(beforeIndex)));
    			break;
    		}
    		if(expression.charAt(i)=='*' || expression.charAt(i)=='-' || expression.charAt(i)=='+') {
    			numQ.add(Long.parseLong(expression.substring(beforeIndex, i)));
    			beforeIndex = i+1;
    			charQ.add(expression.charAt(i));
    		}
    	}

    	long tempMax = 0;
    	for(char[] calc : calcComb) {
            LinkedList<Long> tempNumQ = new LinkedList<>();
            LinkedList<Character> tempCharQ = new LinkedList<>();
            for(Long l : numQ)
                tempNumQ.add(l.longValue());
            for(Character c : charQ)
                tempCharQ.add(c.charValue());
            
    		for(char c: calc) {
    	    	int i=0;
    	    	while(tempCharQ.size()>0 && i<tempCharQ.size() ) {
    	    		if(c==tempCharQ.get(i)) {
    	    			if(c=='*') {
    	    				Long l1 = tempNumQ.get(i);
    	    				Long l2 = tempNumQ.get(i+1);
                            tempNumQ.remove(i);
                            tempNumQ.remove(i);
                            tempNumQ.add(i, l1*l2);
    	    			} else if (c=='+') {
    	    				Long l1 = tempNumQ.get(i);
    	    				Long l2 = tempNumQ.get(i+1);
                            tempNumQ.remove(i);
                            tempNumQ.remove(i);
                            tempNumQ.add(i, l1+l2);
    	    			} else { // c=='-'
    	    				Long l1 = tempNumQ.get(i);
    	    				Long l2 = tempNumQ.get(i+1);
                            tempNumQ.remove(i);
                            tempNumQ.remove(i);
                            tempNumQ.add(i, l1-l2);
    	    			}
    	    			tempCharQ.remove(i);
    				} else {
    					i++;
    				}
    	    		
    	    	}

    		}
            long t = Math.abs(tempNumQ.get(0));
            if(t>tempMax) tempMax=t;
    	}
    	
    	
        long answer = tempMax;
        return answer;
    }
}
