package lan_java.kakao2019;


public class MujiMukbang {

	public static void main(String[] args) {
		

	}

    public int solution(int[] food_times, long k) {
    	int MAX_TIME = 100000000;
        int[] numOfFoodsPerTimes = new int[MAX_TIME]; // 최대 1000초, 각 초마다 음식이 뭐가 있는지
        // LinkedList<Integer>[] numOfFoodsListPerTimes = new LinkedList[1000];
        
        for(int i=0; i<food_times.length; i++) { // 얘는 최대 2000번 돌겠지
            numOfFoodsPerTimes[food_times[i]-1]++; // 3초 걸리는 음식은 인덱스가'2', 4초짜리는 3
        }
        

        
        int cnt = 0;
        for(int j=MAX_TIME-1; j>=0; j--) { // numOfFoodsPerTimes를 누적합으로 바꾸기
            cnt+=numOfFoodsPerTimes[j]; // 뒤에서부터 
            numOfFoodsPerTimes[j]=cnt;
        }    
        
        // 이제 k번째까지 작동시켜보기
        long cumul = 0;
        for(int i=0; i<numOfFoodsPerTimes.length; i++) {            
            cumul += numOfFoodsPerTimes[i];
            
            // 마지막 바뀌가 오면
            if(cumul>k) {              
                cumul -= numOfFoodsPerTimes[i];
                int idx = (int)(k-cumul);
                int sec = i+1;
                
                // 남은 음식 중에서 몇 번쨰가 필요한지 체크
                for(int j=0; j<food_times.length; j++) {
                    if(food_times[j]>=sec) {
                        if(idx==0) return j+1;
                        --idx;                        
                    }
                }                
            }
        }        
        return -1;
    }
}
