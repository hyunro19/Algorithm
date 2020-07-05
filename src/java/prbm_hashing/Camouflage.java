package prbm_hashing;

import java.util.HashMap;
import java.util.Map;

public class Camouflage {

	public static void main(String[] args) {
		// 그냥 수학문제 아닌가?
		// n가지+안입는 경우 (n+1)*(n+1)*... 아무것도 안입는 경우 -1
		// 그 경우 맞는데, 일단 해싱처리를 해야함. inputData때문에
		String[][] clothes = 
					{ {"yellow_hat", "headgear"}, 
					{"blue_sunglasses", "eyewear"}, 
					{"green_turban", "headgear"} };
		System.out.println(solution(clothes));
		

	}

    public static int solution(String[][] clothes) {
    	Map<String, Integer> map = new HashMap<String, Integer>();
    	for(int i=0; i<clothes.length; i++) 
    		map.put( clothes[i][1], map.getOrDefault(clothes[i][1], 0)+1 );     		
    	int i = 1;
    	for(String key : map.keySet())
    		i*=(map.get(key)+1);    	
    	i-=1;
        return i;
    }

}
