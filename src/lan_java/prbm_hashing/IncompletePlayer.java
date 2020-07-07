package lan_java.prbm_hashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class IncompletePlayer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] participant = {"marina", "josipa", "nikola", "vinko", "filipa"};
		String[] completion = {"josipa", "filipa", "marina", "nikola"};
		System.out.println(solution2(participant, completion));
		Integer integer = new Integer(3);
		System.out.println(integer+3); // 6
		System.out.println(integer==3); // true
		System.out.println(integer>2); // true
		System.out.println(integer<2); // false
		
		// WrapperŬ������ int, double ���̿��� ������� + ==�񱳰� �����ϴ�
	}

	// �̰� ���ķ� Ǫ�� ���
    public static String solution(String[] participant, String[] completion) {
    	Arrays.sort(participant);
    	Arrays.sort(completion);
    	for(int i=0; i<completion.length; i++) {
    		if(participant[i].equals(completion[i])) continue;
    		return participant[i];
    	}
    	return participant[participant.length-1];
    }
    
    // �ؽ����� Ǫ�� �����?
    public static String solution2(String[] participant, String[] completion) {
    	Map map = new HashMap<String, Integer>();
    	for(int i=0; i<participant.length; i++) {
    		Integer integer = (Integer)map.get(participant[i]);    		 
    		if(integer!=null) {
    			int temp = integer.intValue();
    			map.put(participant[i], Integer.valueOf(++temp) );
    		} else {
    			map.put(participant[i], Integer.valueOf(1) );
    		}    		    	
    	}
    	for(int i=0; i<completion.length; i++) {
    		Integer integer = (Integer)map.get(completion[i]);
    		int temp = integer.intValue();
    		if(temp==1) {
    			map.remove(completion[i]);
    		} else {
    			map.put(completion[i], Integer.valueOf(--temp));
    		}    		
    	}
    	
    	String answer = "";
    	Set set = map.keySet();
    	Iterator<String> iter = set.iterator();
    	while(iter.hasNext()) {
    	    answer = iter.next();
    	}
    	return answer;
    }
    
    // ��� �亯
    public static String solution3(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> hm = new HashMap<>();
        // Java�� Map���� getOrDefault��� �޼ҵ尡 �ֱ�
        // Iterator for(String key : Array) �� �ִµ� ����� �ȳ���... Array���� Set�� ���� ����
        // �׳� int�־ Integer�� �˾Ƽ� ����
        for (String player : participant) hm.put(player, hm.getOrDefault(player, 0) + 1);
        for (String player : completion) hm.put(player, hm.get(player) - 1);

        for (String key : hm.keySet()) {
            if (hm.get(key) != 0){
                answer = key;
            }
        }
        return answer;
    }
}
