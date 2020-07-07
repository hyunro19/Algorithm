package lan_java.prbm_dp;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class ExpressWithN {

	public static void main(String[] args) {
		System.out.println(solution(5, 12));
//		System.out.println(solution(2, 11));		
	}
	
    public static int solution(int N, int number) {
    	// 5�� �� ���� ����ؼ� ���� �� �ִ� ���ڵ�
    	// 5�� �� �� ����ؼ� ���� �� �ִ� ���ڵ�
    	// 5�� �� �� ����ؼ� ���� �� �ִ� ���ڵ�
    	int answer = -1;
    	ArrayList<Set<Integer>> sets = new ArrayList<>();
    	for(int i=0; i<8; i++) {
//    		System.out.println(i+"/8��°");
    		sets.add(new HashSet<Integer>());

    		// 555, 33333������ ���� �ֱ�
    		String s = ""+N;
    		for(int j=0; j<i; j++) s+=N;
    		sets.get(i).add(Integer.parseInt(s));
    			
    		for(int j=0; j<i; j++) {
    			// j�� i-j�� ���������
//    			System.out.println(j+", "+(i-j-1));
    			for(int m : sets.get(j)) {
    				for(int n : sets.get(i-j-1)) {    					
    					sets.get(i).add(m+n);
    					if(m-n>0) sets.get(i).add(m-n);
    					sets.get(i).add(m*n);
    					if(m/n>0) sets.get(i).add(m/n);
    				}
    			}
    		}
//    		System.out.print("i="+i+"\n");
//    		for(int k : sets.get(i)) System.out.print(k+" ");
//    		System.out.println("");
    		if(sets.get(i).contains(number)) return i+1;    		
    	} 	    	
        return answer;
    }

}
