package lan_java.kakao2018;

public class ThansGivingDayTraffic {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] lines = {
				"2016-09-15 20:59:57.421 0.351s",
				"2016-09-15 20:59:58.233 1.181s",
				"2016-09-15 20:59:58.299 0.8s",
				"2016-09-15 20:59:58.688 1.041s",
				"2016-09-15 20:59:59.591 1.412s",
				"2016-09-15 21:00:00.464 1.466s",
				"2016-09-15 21:00:00.741 1.581s",
				"2016-09-15 21:00:00.748 2.31s",
				"2016-09-15 21:00:00.966 0.381s",
				"2016-09-15 21:00:02.066 2.62s",				
				};
		int max = solution(lines);
		System.out.println(max);
	}
    public static int solution(String[] lines) {
    	int[][] linesInInt = new int[lines.length][2];
    	for(int i=0; i<lines.length; i++) {
    		linesInInt[i] = getTime(lines[i]);
    	}
    	int max = 0;
    	for(int i=lines.length-1; i>=0; i--) {
    		int endTime = linesInInt[i][1];
    		int endTimePlusOneSec = endTime+999;
    		int cnt = 1;
    		int j = i+1;
    		while(j<lines.length && linesInInt[j][1]-3000<endTimePlusOneSec) {
                if( withinSec(endTime, endTimePlusOneSec, linesInInt[j] ) )
    			    ++cnt;
                 j++;
    		}
    		if(cnt>max) {                
                max = cnt;   
                
            }
    	}
        return max;
    }
    
    public static int[] getTime(String line) {
    	String[] splitLine = line.split(" ");
    	String[] HHMMSS = splitLine[1].split(":");
    	int HH = Integer.parseInt(HHMMSS[0])*1000;
    	int MM = Integer.parseInt(HHMMSS[1])*1000;
    	int SS = (int)(1000*Double.parseDouble(HHMMSS[2]));
    	int DD = (int)(1000*Double.parseDouble(splitLine[2].substring(0, splitLine[2].length()-1)));    	
    	int endTime = 3600*HH+60*MM+SS;
    	int startTime = endTime-DD+1;
        if(startTime<0) startTime=0;
    	int[] ret = new int[2];
    	ret[0] = startTime;
    	ret[1] = endTime;
    	return ret;
    }
    public static boolean withinSec(int endTime, int endTimePlusOneSec, int[] gap) {
    	int start = gap[0];
    	int end = gap[1];
    	if(endTime<=start && start<=endTimePlusOneSec) {
    		return true;
    	}
    	if(endTime<=end && end<=endTimePlusOneSec) {
    		return true;
    	}
    	if(start<=endTime && endTimePlusOneSec<=end) {
    		return true;
    	}
    	return false;
    }
}