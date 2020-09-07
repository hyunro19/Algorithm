package lan_java.kakao2019;

import java.util.*;

public class FailureRate {

	public static void main(String[] args) {

		
	}
	
    public int[] solution(int N, int[] stages) {
        // 실패율을 구하고
        // 스테이지 만큼 int배열 선언
        // 단 N+1은 마지막 스테이지까지 클리어한 사용자를 나타낸다. 이 설명 안봐서 헤멤....
        
        int[] cmlStg = new int[N+1];        
        for(int s : stages) ++cmlStg[s-1];
        // cmlStg = [1, 3, 2, 1, 0, 1];
        
        double[][] failRate = new double[N][2]; // [stageLevel, failureRate]
        int numOfPlayer = stages.length;
        for(int i=0; i<N; i++) {
            // numOfPlayer가 0이 되더라도 stageLevel값은 채워줘야 정렬 가능함.           
            failRate[i][0]=i+1;
            if(numOfPlayer>0) {
                failRate[i][1]=cmlStg[i]/(double)numOfPlayer;            
                numOfPlayer-=cmlStg[i];                
            }            
        }
        
        Arrays.sort(failRate, new Comparator<double[]>() {
            public int compare(double[] a, double[] b) {                
                double frGap = a[1]-b[1];
                if(frGap>0) return -1;
                else if(frGap<0) return 1;
                else {
                    double stgGap = a[0]-b[0];
                    if(stgGap>0) return 1;
                    else return -1;
                }  
            };        
        });
            
        int[] answer = new int[N];
        for(int j=0; j<N; j++) 
            answer[j]=(int)failRate[j][0];
        
        return answer;        
    }
	
}