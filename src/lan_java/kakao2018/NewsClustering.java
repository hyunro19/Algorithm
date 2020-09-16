package lan_java.kakao2018;

import java.util.*;

public class NewsClustering {

	public static void main(String[] args) {
		System.out.println('A'-1+1);
		System.out.println('Z'-1+1);
		System.out.println(solution("aa1+aa2", "AAAA12"));

	}
	
    public static int solution(String str1, String str2) {
        // map을 두개 만들어야 될듯
        Map<String, Integer> map1 = new HashMap<>();        
        Map<String, Integer> map2 = new HashMap<>();
        
        // loop는 0부터 length-1까지
        // 글자를 2개씩 끊자. substring(i, i+2)하면 될듯
        for(int i=0; i<str1.length()-1; i++) {
        	String twoLetters = str1.substring(i, i+2);
        	// 그리고 대문자로 바꾼다.
        	twoLetters = twoLetters.toUpperCase();
        	
        	// 글자의 char int값이 범위를 벗어나면 버린다.
        	if(twoLetters.charAt(0)<65 || 90<twoLetters.charAt(0))
        		continue;
        	if(twoLetters.charAt(1)<65 || 90<twoLetters.charAt(1))
        		continue;
        	
            // map에 넣는다. 개수가 여러개면 기존값가져와서 +1;
        	map1.put(twoLetters, map1.getOrDefault(twoLetters, 0)+1);        	
        }
        
        // -> 두 개 string에 대해 각각 시행
        for(int i=0; i<str2.length()-1; i++) {
        	String twoLetters = str2.substring(i, i+2);
        	
        	twoLetters = twoLetters.toUpperCase();
        	
        	if(twoLetters.charAt(0)<65 || 90<twoLetters.charAt(0))
        		continue;
        	if(twoLetters.charAt(1)<65 || 90<twoLetters.charAt(1))
        		continue;
        	
        	map2.put(twoLetters, map2.getOrDefault(twoLetters, 0)+1);        	
        }
        
        if(map1.size()==0 && map2.size()==0) return 65536;
        if(map1.size()==0 || map2.size()==0) return 0;

        int Intersection = 0;
        int Difference = 0;
        int Union = 0;
        // 교집합 구하기
        for(String key : map1.keySet()) {
        	// 한 쪽 key에 대해서, 다른쪽 key가 null이 아닐 경우
        	int fromStr1 = map1.get(key);
        	if(map2.get(key)!=null) {
        		// 두 key값에 대해 작은 숫자를 counting한다. Intersection
        		int fromStr2 = map2.get(key);
        		Intersection += Math.min(fromStr1,  fromStr2); // 둘 중 작은 값
        		Union += Math.max(fromStr1,  fromStr2); // 둘 중 큰 값
        	} else { // if map2.get(key) == null
                // 한 쪽 key값에 대해서 다른쪽 key값이 null인 경우 그 개수를 counting한다.
        		Difference += fromStr1;
        	}
        }
        for(String key : map2.keySet()) {
        	// 한 쪽 key값에 대해서 다른쪽 key값이 null인 경우 그 개수를 counting한다.
        	int fromStr2 = map2.get(key);
        	if(map1.get(key)==null) {
        		Difference += fromStr2;
        	}
        }
        
        // Union에는 공통값 중 max가 들어가 있으므로, 차집합만큼만 더해준다.
        Union += Difference;
        double jakad = Intersection/(double)Union;
        
        return (int)(jakad*65536);
        
    }

}

