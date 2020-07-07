package lan_java.test_prgrmrs_chlng_200523;

import java.util.HashSet;
import java.util.Set;

public class Algorithm1 {
	public static void main(String[] args) {
		int p = 2015;
		Solution1 solution = new Solution1();
		int ans = solution.solution(p);
		System.out.println(ans);
	}
	
    
}

class Solution1 {
    public int solution(int p) {
    	++p;
    	while(!isBeautiful(p))
    		++p;
        
        return p;
    }
    
    public boolean isBeautiful(int year) {
        int a = year%10;
        int b = year%100/10;
        int c = year%1000/100;
        int d = year/1000;

        Set<Integer> set = new HashSet<>();
        set.add(a);
        set.add(b);
        set.add(c);
        set.add(d);
        if(set.size()==4)
            return true;
	
	return false;
    }
}