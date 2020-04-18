package Line;

public class Line1 {

	public static void main(String[] args) {


	}

}

class Solution1 {
    public int solution(String inputString) {
        int answer = -1;
    	int cnt = 0;
    	int length = inputString.length();
    	int small=0;
    	int middle=0;
    	int large=0;
    	int extra=0;
    	for(int i=0; i<length; i++) {
    	    switch(inputString.charAt(i)){
            case '(' : 
                ++small; 
                break;
            case '{' : 
            	++middle;   
            	break;
            case '[' : 
            	++large;
            	break;
            case '<' : 
            	++extra;   
            	break;
            case ')' : 
            	if(--small<0) return answer;
            	++cnt;
            	break;
            case '}' : 
            	if(--middle<0) return answer;
            	++cnt;
            	break;
            case ']' : 
            	if(--large<0) return answer;
            	++cnt;
            	break;
            case '>' : 
            	if(--extra<0) return answer;
            	++cnt;
            	break;
    	    }
    		
    	}
    	answer = cnt;
        return answer;
    }
}