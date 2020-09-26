package jv.pg.prbm_sort;

import java.util.Arrays;

public class Hindex {

	public static void main(String[] args) {
		int[] citations = {3, 3, 3, 2, 5, 5, 5, 5, 5};
//		int[] citations = {5, 5, 5, 5};
		System.out.println(solution(citations));
	}

    public static int solution(int[] citations) {
    	if(citations.length==0) return 0;
        Arrays.parallelSort(citations);
//        for(int i=citations.length-1; i>=0; i--) {
//        	System.out.print(citations[i]+" ");
//        }
//        System.out.println("");
        int cnt=0;
        for(int i=citations.length-1, n=1; i>=0; i--, n++) {
        	if(citations[i]>=n) cnt++;
        }
        return cnt;
    }
	
    public static int solution2(int[] citations) {
	    int result = 0;
	    for(int i=0; i<citations.length; i++){
	        int smaller = Math.min(citations[i], citations.length-i);
	        result = Math.max(result, smaller);
	    }
	    return result;
    }
	
}

