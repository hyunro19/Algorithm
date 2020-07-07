package lan_java.test_line;

public class Line3 {
	static boolean[] rawRoad;
	static boolean[] visited;
	static int one;
	static int zero;
	static int ans;
	
	public static void main(String[] args) {
//		String road = "111011110011111011111100011111";
//		int n = 3; // 18
		
		String road = "001100";
		int n = 5; // 6
		
		System.out.println(solution(road, n));
	}
	
    public static int solution(String road, int n) {
    	one = 0; // normal
    	zero = 0; // damaged
    	rawRoad = new boolean[road.length()];
    	visited = new boolean[road.length()]
    			;
    	for(int i=0; i<rawRoad.length; i++) {
    		if(road.charAt(i)=='1') {
    			rawRoad[i]=true;
    			++one;
    		} else {
    			// roadRoad[i]=false;
    			++zero;
    		}
    	}
    	// 2��° �׽�Ʈ ���̽� �Ÿ�
    	if(zero<=n) return road.length();
        
    	roadFixer(0, n);
    	
        return ans;
    }
    public static int roadFixer(int depth, int n) {
    	if(depth==n) {
    		int temp = maxLength(rawRoad);
    		if(temp>ans) ans=temp;
    	}
    	
    	for(int i=0; i<rawRoad.length; i++) {
    		if(!rawRoad[i] && !visited[i]) {
    			rawRoad[i]=true;
    			visited[i]=true;
    			roadFixer(depth+1, n);
    			rawRoad[i]=false;
    			visited[i]=false;
    		}
    	}    	
    	return 0;
    }
    
    public static int maxLength(boolean[] rawRoad) {
    	int max = 0;
    	int temp = 0;
    	for(int i=0; i<rawRoad.length; i++) {
    		if(rawRoad[i]) {
    			++temp;
    		} else {
    			if(temp>max) max=temp;
    			temp=0;
    		}
    	}
    	return max;
    }

}



class Solution {

}