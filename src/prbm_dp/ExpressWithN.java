package prbm_dp;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class ExpressWithN {

	public static void main(String[] args) {
		System.out.println(solution(5, 12));
//		System.out.println(solution(2, 11));		
	}
	
    public static int solution(int N, int number) {
    	// 5를 한 번만 사용해서 만들 수 있는 숫자들
    	// 5를 두 번 사용해서 만들 수 있는 숫자들
    	// 5를 세 번 사용해서 만들 수 있는 숫자들
    	int answer = -1;
    	ArrayList<Set<Integer>> sets = new ArrayList<>();
    	for(int i=0; i<8; i++) {
//    		System.out.println(i+"/8번째");
    		sets.add(new HashSet<Integer>());

    		// 555, 33333형태의 숫자 넣기
    		String s = ""+N;
    		for(int j=0; j<i; j++) s+=N;
    		sets.get(i).add(Integer.parseInt(s));
    			
    		for(int j=0; j<i; j++) {
    			// j와 i-j를 맞춰줘야함
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
