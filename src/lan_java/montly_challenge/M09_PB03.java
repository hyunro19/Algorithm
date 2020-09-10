package lan_java.montly_challenge;

import java.util.*;

public class M09_PB03 {

	public static void main(String[] args) {

		// 풍선 터뜨리기
		// 인접한 풍선들을 하나씩 터뜨린다. 하나만 남을때까지
		// 단 두 풍선 중 숫자가 작은 풍선을 터뜨리는 건 한 번만
		// 나머지 경우는 모두 숫자가 큰 풍선을 터뜨려야 한다.
		
		// 맞게 푼 것 같은데 시간 오바돼서 제출 못함
		int[] a = {9, -1, -2};
		System.out.println(solution(a));
	}
	
    public static int solution(int[] a) {
    	int len = a.length;
    	
    	int[] leftMinArr = new int[len];
    	int[] rightMinArr = new int[len];
    	
    	int leftMin = a[0];
    	int rightMin = a[len-1];
    	for(int i=0; i<len; i++) {
    		if(a[i]<leftMin) leftMin=a[i];
    		if(a[len-1-i]<rightMin) rightMin=a[len-1-i];
    		leftMinArr[i] = leftMin;
    		rightMinArr[len-1-i] = rightMin;    		
    	}
    	int cnt=0;
    	for(int i=1; i<len-1; i++) {
    		if(a[i-1]<leftMinArr[i] && a[i]<rightMinArr[i+1])
    			++cnt;    	
    	}
        
    	return len-cnt;
    }
    	
}
