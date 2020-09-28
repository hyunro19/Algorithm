package jv.pg.montly_challenge;

import java.util.*;

public class M09_PB03_PoppingBalloons {

	public static void main(String[] args) {

		// 풍선 터뜨리기
		// 인접한 풍선들을 하나씩 터뜨린다. 하나만 남을때까지
		// 단 두 풍선 중 숫자가 작은 풍선을 터뜨리는 건 한 번만
		// 나머지 경우는 모두 숫자가 큰 풍선을 터뜨려야 한다.
		
		int[] a = {9, -1, -2};
		System.out.println(solution(a));
	}
	
    public static int solution(int[] a) {
        // 맨 앞 풍선과, 맨 뒤 풍선은 뭐가 남던지 가능
        // 1번~마지막-1번 풍선까지는 양 옆의 풍선들을 번호가 큰 풍선들만 터뜨린 후 -> 가장 작은 풍선만 남음
        // 양 옆 두 풍선이 i번째 보다 둘 다 작으면 i번째 풍선은 무조건 터저야함
        // 양 옆 풍선 중 하나라도 i번째보다 작다면 남길 수 있음
        
    	int len = a.length;
    	
    	int[] leftMinArr = new int[len];
    	int[] rightMinArr = new int[len];
    	
    	int leftMin = a[0];
    	int rightMin = a[len-1];
        
        // leftMinArr[i] == a[i]번째 원소의 왼쪽 원소들 중 가장 작은 수
        // rightMinArr[i] == a[i]번째 원소의 오른쪽 원소들 중 가장 작은 수
        leftMinArr[0] = leftMin;
        rightMinArr[len-1] = rightMin;
        for(int i=1; i<len; i++) {
            if(a[i-1]<leftMin) leftMin=a[i-1];
            leftMinArr[i] = leftMin;
            if(a[len-i]<rightMin) rightMin=a[len-i];
            rightMinArr[len-1-i] = rightMin;
        }      
        
        // 남길 수 없는 풍선 수 카운트
        // i번째 풍선 양 옆 두 풍선이 i번째 보다 둘 다 작으면 i번째 풍선은 무조건 터저야함
    	int cnt=0;
    	for(int i=1; i<len-1; i++) {
    		if(a[i]>leftMinArr[i] && a[i]>rightMinArr[i]) {
                ++cnt;
            }
    			
    	}
        
        // 전체 풍선 - 반드시 터지는 풍선 = 남길 수 있는 풍선
    	return len-cnt;
    }
}
