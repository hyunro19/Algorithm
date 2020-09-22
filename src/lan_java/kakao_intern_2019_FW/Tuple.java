package lan_java.kakao_intern_2019_FW;

import java.util.*;

public class Tuple {

	// 문제 설명이 너무 이상하다. 이해 하는데 오래 걸림
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "{{2},{2,1},{2,1,3},{2,1,3,4}}";
		int[] ans = solution(s);
		for(int a : ans) System.out.print(a+" ");
	}
	
    public static int[] solution(String s) {
    	StringBuilder sb = new StringBuilder(s);
    	sb.deleteCharAt(sb.length()-1); // }}제거
    	sb.deleteCharAt(sb.length()-1);
    	sb.deleteCharAt(0); // {{제거
    	sb.deleteCharAt(0);
    	
    	// 중괄호를 String안에 사용할 때는 \\로 escaping필요
    	String[] sets = sb.toString().split("\\},\\{");
    	
    	// 정렬하면 이제 차례대로 앞에 없었던 원소만 담기
    	Arrays.parallelSort(sets, (a, b) -> a.length()-b.length());
    	int[] answer = new int[sets.length];
    	Set<String> set = new HashSet<>();
    	for(String tpl : sets) {
    		StringBuilder sb2 = new StringBuilder(tpl);
        	String[] elements = sb2.toString().split(",");
        	for(String e : elements) {
        		if(set.contains(e)) {
        			continue;
        		} else {
        			set.add(e);
        			answer[elements.length-1] = Integer.parseInt(e);
        			break;
        		}
        	}
        	
    		
    	}
    	
        return answer;
    }
    
    

}
