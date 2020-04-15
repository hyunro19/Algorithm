package prbm_dp;

public class TileDecoration {

	public static void main(String[] args) {
		// 피보나치 수열문제네. 쉬운문제다.
		// 지난번 에 강의에서 Caching방법이 있었고, dp방법이 있었는데
		System.out.println(solution(80));
	}
	
    public static long solution(int N) {
        // 왜 long이지? 그렇게 값이 큰가?
    	// int가 생각보다 큰 값을 못담는구나.
        long[] array = new long[N];
        int i=0;
        while(i<N) {
        	if(i==0 || i==1) array[i]=1;
        	else array[i]=array[i-1]+array[i-2];
        	++i;
        };
        return (4*array[N-1]+2*array[N-2]);
    }

}
