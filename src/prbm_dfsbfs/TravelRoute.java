package prbm_dfsbfs;

import java.util.Arrays;

public class TravelRoute {
	// route를 하나를 게속 사용하다보니, 값을 넣고, 한 단계 depth가 깊어지고
	// 다시 다른 case를 위해 값에 null을 집어 넣을 때 깊어질 때 사용한 변수와 같은 객체를 참조하다보니 오류가 났다.
	// 깊이 들어갈 때에는 '결과'에 해당하는 변수는 새로운 객체를 생성하자. (이번 문제에서는 Arrays.copyOf(Array1)을 사용)
	// 참조변수가 아닐 때에는 상관없는데, 참조변수 일 때에는 주의!
	// 후.. 이거 때문에 2시간 넘게 이 문제만 붙잡고 있었네...
	static String[][] tickets= 
			{ {"ICN", "SFO"}, 
			  {"ICN", "ATL"}, 
			  {"SFO", "ATL"}, 
			  {"ATL", "ICN"}, 
			  {"ATL", "SFO"} };
	static boolean[] isUsed = new boolean[tickets.length];
	public static void main(String[] args) {
		String[] answer = solution(tickets);
		if(answer != null) 
			for(String s : answer)
				System.out.print(s+" ");
	}
	
    public static String[] solution(String[][] tickets) {
    	String[] answer=null;
    	boolean[] isUsed = new boolean[tickets.length];
    	String[] route = new String[tickets.length+1];
    	answer = flight(tickets, isUsed, route, 0);
    	return answer;
    }
    
    public static String[] flight(String[][] tickets, boolean[] isUsed, String[] route, int depth) {
    	if(depth==tickets.length) return route;
    	
    	if(depth==0) route[0]="ICN";    	
    	String[] ans = null;
    	for(int i=0; i<tickets.length; i++) {
    		if(isUsed[i]) continue;
    		if(tickets[i][0].equals(route[depth])) {
    			isUsed[i]=true;
    			route[++depth]=tickets[i][1];
    			String[] temp = flight(tickets, isUsed, Arrays.copyOf(route, route.length), depth);
    			if(doesntHaveNull(temp))
    				if(ans==null || compare(temp,ans)<0) ans=temp;    		
    			route[depth--]=null;
    			isUsed[i]=false;
    		}    		
    	}
    	return ans;
    }
    
    public static boolean doesntHaveNull(String[] route) {
    	if(route==null) return false;
    	for(String s : route) 
    		if(s==null) return false; 
    	 return true;
    }
    
    public static int compare(String[] strArr1, String[] strArr2) {
    	int len = strArr1.length;
    	for(int i=0; i<len; i++) 
    		if(!strArr1[i].equals(strArr2[i])) return strArr1[i].compareTo(strArr2[i]);
    	return 0;
    }
    
    
}
