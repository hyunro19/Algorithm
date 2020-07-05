package prbm_stackqueue;

public class SteelPipe {

	public static void main(String[] args) {
		String arrangement = "()(((()())(())()))(())";
		System.out.println(solution(arrangement));
		
		
	}
	
    public static int solution(String arrangement) {
    	int length = arrangement.length();
    	int stack = 0;    
    	int cnt = 0;
    	boolean isOpen = true;
    	
    	for(int i=0; i<length; i++) {
    		if (arrangement.charAt(i) == '(' ) {
    			++stack;
    			isOpen = true;
    		} else {
    			--stack;
    			if(isOpen == true) {
    				cnt+=stack;
    			} else {
    				++cnt;
    			}    			
    			isOpen = false;
    		}
    	}
    	
        return cnt;
    }
}
