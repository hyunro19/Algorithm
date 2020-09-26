package jv.pg.prbm_dfsbfs;

import java.util.Arrays;

public class TravelRoute {
	// route�� �ϳ��� �Լ� ����ϴٺ���, ���� �ְ�, �� �ܰ� depth�� ��������
	// �ٽ� �ٸ� case�� ���� ���� null�� ���� ���� �� ������ �� ����� ������ ���� ��ü�� �����ϴٺ��� ������ ����.
	// ���� �� ������ '���'�� �ش��ϴ� ������ ���ο� ��ü�� ��������. (�̹� ���������� Arrays.copyOf(Array1)�� ���)
	// ���������� �ƴ� ������ ������µ�, �������� �� ������ ����!
	// ��.. �̰� ������ 2�ð� �Ѱ� �� ������ ����� �־���...
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
