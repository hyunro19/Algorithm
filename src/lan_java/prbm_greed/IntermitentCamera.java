package lan_java.prbm_greed;

import java.util.Arrays;
import java.util.Comparator;

public class IntermitentCamera {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Integer.MIN_VALUE);
	}
	
    public int solution(int[][] routes) {
        RouteComparator c = new RouteComparator();        
        Arrays.sort(routes, c);
        int left=routes[0][0];
        int right=routes[0][1];
        int cnt=0;
        int i=0;
        for(int[] route : routes) {
            if(right<route[0]) {
                left=route[0];
                right=route[1];
                ++cnt;
            } else {
                left=Math.max(left, route[0]);
                right=Math.min(right, route[1]);
            }
        }
        return ++cnt;
    }

}

class RouteComparator implements Comparator<int[]> {
    @Override
    public int compare(int[] rt1, int[] rt2) {
        if(rt1[0]==rt2[0]) return rt1[1] - rt2[1];
            return rt1[0] - rt2[0];
    }    
}