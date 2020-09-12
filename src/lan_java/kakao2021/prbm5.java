package lan_java.kakao2021;

import java.util.*;

public class prbm5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a = "02:03:55";
		String log = "01:20:15-01:45:14";
        String[] ab = {"69:59:59-89:59:59", "01:00:00-21:00:00", "79:59:59-99:59:59", "11:00:00-31:00:00"};
        Arrays.sort(ab);
        for(String s : ab) System.out.println(s+" ");
        System.out.println();
		System.out.println(getSec(a));
		System.out.println(getGap(log));
	}
	
    public String solution(String play_time, String adv_time, String[] logs) {
    	if(getSec(play_time)<=getSec(adv_time)) return "00:00:00";
    	
    	// 작은 것부터 뱉는다.
    	Arrays.sort(logs);
    	Queue<Integer> begTimes = new LinkedList<>();
    	PriorityQueue<Integer> endTimes = new PriorityQueue<>(Collections.reverseOrder());
    	
    	int[][] table = new int[logs.length*2][2];
    	int idx = 0;
    	int stack = 0;
    	if(getBegFromLog(logs[0])>0) {
			int[] temp = {0, stack};
			table[idx++] = temp;
		} 
    	for(int i=0; i<logs.length; i++) {
    		stack++;
    		int beg = getBegFromLog(logs[i]);
    		int end = getEndFromLog(logs[i]);

    		if(beg == getBegFromLog(logs[i+1])) {
    			endTimes.add(end);
    			continue;
    		} else {
        		begTimes.add(beg);
        		endTimes.add(end);
        		int[] temp = {beg, stack};
        		table[idx++] = temp;
        		if(endTimes.peek()<=getBegFromLog(logs[i+1])) { // 다음 시작 전에 end가 나와
        			
        		}
    		}

    		
    		
    		// 시작이 0일 때, 0이 아닐 때 처리
    		
    		// 마지막에 0이면 처리
    	}    	

    	
        String answer = "";
        return answer;
    }
	public static int getSec(String time) {
		int HH = Integer.parseInt(time.substring(0, 2));
		int MM = Integer.parseInt(time.substring(3, 5));
		int SS = Integer.parseInt(time.substring(6, 8));
		return HH*3600+MM*60+SS;
	}
	public static int getGap(String times) {
		String beg = times.substring(0, 8);
		String end = times.substring(9, 17);
		return getSec(end)-getSec(beg);
	}
	public static int getBegFromLog(String times) {
		return getSec(times.substring(0, 8));
	}
	public static int getEndFromLog(String times) {
		return getSec(times.substring(9, 17));
	}
}
