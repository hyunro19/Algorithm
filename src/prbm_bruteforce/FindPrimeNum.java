package prbm_bruteforce;

import java.util.HashSet;
import java.util.Set;

public class FindPrimeNum {
	static Set<String> combination;
	static Set<Integer> permutation;
		
	public static void main(String[] args) {
		long before = System.currentTimeMillis();
		System.out.println(solution("112233566"));
		long after = System.currentTimeMillis();
		System.out.println((after-before));
	}
	
    public static int solution(String numbers) {
        int cnt=0;
        char[] input = numbers.toCharArray();
        int length = numbers.length();
        boolean[] inOrOut = new boolean[length];
        
        combination = new HashSet<>();
        makeComb(input, inOrOut, 0, length);
	    
        permutation = new HashSet<>();
        for(String s : combination)
            makePerm(s, inOrOut, "", 0, s.length());
        
        for(int i : permutation)
            if(isPrime(i)) cnt++;
        
        return cnt;
    }
    
    public static void makeComb(char[] input, boolean[] inOrOut, int depth, int length) {
    	if(depth==length) {
    		StringBuilder sb = new StringBuilder();    		
    		for(int i=0; i<length; i++) if(inOrOut[i]) sb.append(input[i]);
    		String str = sb.toString();
    		if(str.length()>0) combination.add(sb.toString());
    		return;
    	}
    	inOrOut[depth]=true;
    	makeComb(input, inOrOut, depth+1, length);
    	inOrOut[depth]=false;
    	makeComb(input, inOrOut, depth+1, length);    	
    }    
    
    public static  void makePerm(String inputStr, boolean[] inOrOut, String str, int depth, int length) {
    	if(depth==length) {
    		permutation.add(Integer.parseInt(str));
    		return;    		
    	}
    	for(int i=0; i<length; i++) {
    		if(inOrOut[i]) continue;
    		inOrOut[i]=true;
    		makePerm(inputStr, inOrOut, str+inputStr.charAt(i), depth+1, length);
    		inOrOut[i]=false;
    	}    	
    }
        
    public static boolean isPrime(int input) {
    	if(input==0 || input==1) return false;    
    	for(int i=2; i<=Math.sqrt(input); i++)
    		if(input%i==0) return false;
        return true;
    }
}