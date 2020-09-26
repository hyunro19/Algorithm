package jv.pg.prbm_greed;

import java.util.Arrays;

public class SafetyBoat {

public static void main(String[] args) {
	
}

public int solution(int[] people, int limit) {
	int cnt=0;
	Arrays.parallelSort(people);
	int peopleLeft = people.length;
	int startIndex = 0;
	int endIndex = people.length-1;
	while(peopleLeft>0) {
		if(people[endIndex]+people[startIndex]<=limit) {
    		--endIndex;
    		++startIndex;        		
    		peopleLeft-=2;
    	} else {
    		--endIndex;
    		peopleLeft-=1;
    	}
		++cnt;
	}
    return cnt;
}
}