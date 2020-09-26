package jv.pg.kakao2018;

public class DartGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("0 = "+('0'-1+1));
		System.out.println("9 = "+('9'-1+1));
		int cnt = solution("1D2S3T*");
		System.out.println(cnt);
	}

    public static int solution(String dartResult) {
    	// 일단 문자열을 pasing해서 각 단계별로 점수, 보너스, 옵션을 구분
    	// S냐, D냐, T냐
    	// *이 있냐 없냐
    	int[][] scoreTable = new int[3][3];
    	int rIdx = -1;
    	
    	// 1회차, 2회차, 3회차 // 각회차 {점수, S1/D2/T3, X0/*2/#-1 }
    	for(int i=0; i<dartResult.length(); i++) {
    		char c = dartResult.charAt(i);
    		if(48<=c && c<=57) {
    			++rIdx;
    			char nextC = dartResult.charAt(i+1);    			
    			if(48<=nextC && nextC<=57) {    				
    				scoreTable[rIdx][0] = Integer.parseInt(dartResult.substring(i, i+2));
    				i++;
    			} else {
    				scoreTable[rIdx][0] = Integer.parseInt(dartResult.substring(i, i+1));
    			}
    		} else if(c=='S') {
    			scoreTable[rIdx][1] = 1;
    		} else if(c=='D') {
    			scoreTable[rIdx][1] = 2;
    		} else if(c=='T') {
    			scoreTable[rIdx][1] = 3;
    		} else if(c=='*') {
    			scoreTable[rIdx][2] = 2;      			
    		} else if(c=='#') {
    			scoreTable[rIdx][2] = -1;
    		}     			
    		    	    		
    	}
    	
    	int cnt = 0;
    	for(int i=0; i<3; i++) {
    		int base = (int)Math.pow(scoreTable[i][0], scoreTable[i][1]);
    		
    		// *이냐 #이냐
    		if(scoreTable[i][2]!=0) {
    			base*=scoreTable[i][2];
    		}
    		
    		// *중복 조건 여부 확인
    		if(i<2 && scoreTable[i+1][2]==2) {
    			base*=2;
    		}
    		
    		cnt+=base;
    	}
        return cnt;
    }
}
