package lan_java.kakao2021;

import java.util.*;

public class prbm2 {

	public static void main(String[] args) {
		String[] orders = {"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"};
		int[] course = {2, 3, 5};
		String[] answer = solution(orders, course);
		for(String s : answer) System.out.print(s+" ");
	}
	static String[] staticOrders;
	static int maxCnt;
    public static String[] solution(String[] orders, int[] course) {
    	staticOrders = orders;
    	
    	// orders를 순회하면서 음식 종류가 모두 몇 종류인지를 구한다. 배열에 넣자.
    	Set<Character> dishes = new HashSet<>();
    	for(String odr : orders) {
    		for(int i=0; i<odr.length(); i++) {
    			dishes.add(odr.charAt(i));
    		}
    	}
    	// A B C D 순으로 정렬
    	Character[] dishesArr = dishes.toArray(new Character[dishes.size()]);
    	boolean[] inOrOut = new boolean[dishesArr.length];
    	Arrays.sort(dishesArr);
    	
//    	for(String s : dishes) System.out.print(s+" "); // 여기까지 OK
    	// 배열에 넣은 애들을 course 숫자에 따라 조합을 만들어 Set에 다시 넣는다.    	
    	ArrayList<String> permComb = new ArrayList<>();
    	for(int c : course) {
    		maxCnt = 0;
    		if(c>dishesArr.length) break; // 조합 수가 음식 수보다 많으면 break;
    		Set<String> tempComb = new HashSet<>();    		
    		ArrayList<String> combWithCnt = new ArrayList<>();
    		comb(dishesArr, inOrOut, 0, c, tempComb, combWithCnt);// c개수만큼 조합을 넣고
    		
        	
        	// 위의 이중배열을 정렬
        	combWithCnt.sort(new Comparator<String>() {        		
    			@Override
    			public int compare(String o1, String o2) {
    				return o2.compareTo(o1); // 점수 내림차순		
    			}    		
        	});

        	for(int j=0; j<combWithCnt.size(); j++) {
        			permComb.add(combWithCnt.get(j));
        	}
    		
    	}  
    	
    	String[] answer = permComb.toArray(new String[permComb.size()]);
    	Arrays.sort(answer, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o1.compareTo(o2);
			} 
    	});
    
        return answer;
    }
    
    public static void comb(Character[] dishesArr, boolean[] inOrOut, int idx, int ram, Set<String> combination, ArrayList<String> combWithCnt) {    	
    	if(ram==0) {    		
    		StringBuilder sb = new StringBuilder();
    		for(int j=0; j<dishesArr.length; j++) { 
    			if(inOrOut[j]) {
    				sb.append(dishesArr[j]);
    			}
    		}
    		
        	// 해당 조합 & orders를 순회하면서, 해당 조합을 주문한 고객이 있으면 해당 조합에 점수를 ++한다.    	
    		String s = sb.toString();
    		int cnt = 0;
    		for(String order : staticOrders) {
    			if(s.length()>order.length()) continue;
    			if(match(s, order)) ++cnt;
    		}
            if(cnt>=2) {
                if (cnt>maxCnt) {
                    maxCnt = cnt;
                    combWithCnt.clear();
    		        combWithCnt.add(s);                    
                } else if (cnt==maxCnt) {
                    combWithCnt.add(s);                    
                }                	                            		    
            }        	
    		return;
    	}

    	if(idx>=dishesArr.length) return;
    	
		// 안넣을 때
		comb(dishesArr, inOrOut, idx+1, ram, combination, combWithCnt);    	
		// 넣을 때
		inOrOut[idx]=true;
		comb(dishesArr, inOrOut, idx+1, ram-1, combination, combWithCnt);
		inOrOut[idx]=false;


    }
    public static boolean match(String comb, String order) {
    	for(int i=0; i<comb.length(); i++) {
    		// String dish = comb.substring(i, i+1);
    		if(order.indexOf(comb.charAt(i))!=-1) {
    			continue;
    		} else {
    			return false;
    		}    		    		
    	}    	
    	return true;
    }
    
}
