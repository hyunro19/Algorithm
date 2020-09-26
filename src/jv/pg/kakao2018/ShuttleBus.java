package jv.pg.kakao2018;

import java.util.*;

public class ShuttleBus {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String start = "09:00";
		int min = timeToMin(start);
		String time = minToTime(min);
		System.out.println(min+", "+time);
	}
	
    public static String solution(int n, int t, int m, String[] timetable) {
        Arrays.sort(timetable); // timetable이 정렬이 안되있는 예시가 있다.
    	String startTime = "09:00";
    	int startMin = timeToMin(startTime);
    	// t만큼 순회할 예정이다. for문
    	// 각 for문의 시작점에 현재까지 온 사람들을 Queue에 넣는다.
    	// 셔틀이 출발할 때 queue에서 m만큼 사람을 태우는데
    	// queue의 size보다 m이 작다면 ans는 다음 셔틀 시간이 된다.
    	// queue의 size보다 m이 크거나 같다면 ans는 m번째 사람 -1이 된다.    	    	
    	Queue<Integer> queue = new LinkedList<>();
    	int idx = 0;
    	int latestMin = 0;
    	// t만큼 순회할 예정이다. for문
    	for(int i=0; i<n; i++) {
    		int shuttleMin = startMin+i*t;
    		
    		// 각 for문의 시작점에 현재까지 온 사람들을 Queue에 넣는다.
    		for(int j=idx; j<timetable.length; j++) {
    			int arrivalMin = timeToMin(timetable[j]);
    			if(arrivalMin<=shuttleMin) {
    				queue.add(arrivalMin);
    				idx++;
    			} else { // 아직 다음 사람이 도착할 시간이 안되면
    				break;
    			}
    		}
    		
    		// 셔틀이 출발할 때 queue에서 m만큼 사람을 태우는데    		
    		if(queue.size()<m) {
    	    	// queue의 size보다 m이 작다면 ans는 다음 셔틀 시간이 된다.
    			// 단 이번 버스시간이 마지막이라면 지금 버스시간    			
    			latestMin = shuttleMin+t;
    			if(i==n-1) latestMin = shuttleMin;
    			queue.clear();
    			
    		} else {
    			// queue의 size보다 m이 크거나 같다면 ans는 m번째 사람 -1이 된다.
    			int lastPassengerOfThisBus = 0;
    			for(int k=0; k<m; k++) { // m명
    				lastPassengerOfThisBus = queue.poll();
    			}
    			latestMin = lastPassengerOfThisBus-1;    			    			
    		}
    	}
        String answer = minToTime(latestMin);
        return answer;
    }
    
    public static int timeToMin(String time) {
    	String[] splitTime = time.split(":");
    	int HH = Integer.parseInt(splitTime[0]);
    	int MM = Integer.parseInt(splitTime[1]);
    	return 60*HH+MM;
    }
    public static String minToTime(int min) {    	
    	String HH = min/60+"";
    	String MM = min%60+"";
    	String ans = "";
    	if(HH.length()==1) HH="0"+HH;
    	if(MM.length()==1) MM="0"+MM;
    	return HH+":"+MM;
    }

}
