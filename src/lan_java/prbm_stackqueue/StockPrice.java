package lan_java.prbm_stackqueue;

public class StockPrice {

	public static void main(String[] args) {
		int[] prices = {1,2,3,2,3};
		int[] answers = solution(prices);
		for(int i : answers) {
			System.out.print(i+" ");
		}
	}
	
    public static int[] solution(int[] prices) {
    	int[] answer = new int[prices.length];
    	for(int i=0; i<prices.length; i++) {
    		int j=i+1;
    		int sec=0;
    		while(j<prices.length) {
    			++sec;
    			if(prices[i]>prices[j++]) break;
    		}
    		answer[i]=sec;    
    	}
        return answer;
    }

}
