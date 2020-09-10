package lan_java.montly_challenge;

import java.util.*;

public class M09_PB01 {

	public static void main(String[] args) {
		// 주어진 정수 배열을 중복을 제거하여 오름차순으로 정렬
	}
	
    public static int[] solution(int[] numbers) {
        Set<Integer> set = new HashSet<>();
        
        for(int i=0; i<numbers.length-1; i++) {
        	for(int j=i+1; j<numbers.length; j++) {
        		set.add(numbers[i]+numbers[j]);
        	}
        }
        int[] arr = new int[set.size()];
        int idx = 0;
        for(int itg : set) {
        	arr[idx++]=itg;
        }
        Arrays.parallelSort(arr);
        return arr;
    }
}
