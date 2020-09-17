package lan_java.kakao2018;

import java.util.*;

public class Cache {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public static int solution(int cacheSize, String[] cities) {
        // if(cacheSize==0) return cities.length*5;
    	int time = 0;
    	
    	// set을 만들어서 cache hit인지 아닌지 구분하자.
    	Set<String> cacheSet = new HashSet<>();
    	LinkedList<String> cacheList = new LinkedList<>();
    	
    	for(String city : cities) {
    		String key = city.toUpperCase();
    		
    		if(cacheSet.contains(key)) { // cache hit
    			time += 1;
    	    	// linkedList의 해당 원소 제거
    			// linkedList의 마지막에 새 원소 추가
    			cacheList.remove(key);
    			cacheList.add(key);
    			
    		} else { // cache miss
    			time += 5;
      			// set과 linkedList의 마지막에 새 원소 추가    				    				
				cacheSet.add(key);
				cacheList.add(key);   			
    			if(cacheList.size()>cacheSize) { // cache overflow
    				// linkedList의 첫 번째 원소 poll()하면서, set에서 제거
    				String leastUsedCity = cacheList.pollFirst();
    				cacheSet.remove(leastUsedCity);
    			}
    			
    			// 제거를 먼저하고, 추가할 경우 
    			// 조건문도 cacheList.size()>=cacheSize로 되야하고
    			// cacheSize가 0일 때 문제 여지 있음.
   				
    		}
    	}
        return time;
    }

}