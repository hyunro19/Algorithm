package prbm_dp;

public class WayToSchool {

	public static void main(String[] args) {
//		long before = System.currentTimeMillis();
		System.out.println(
				solution3(5, 7, new int[][]{{2, 1},{1, 3},{3, 3}})
				);
//		long after = System.currentTimeMillis();
//		System.out.println(after-before);
	}

	// 모든 칸마다 isPuddle을 실행하니 시간초과
	// isPuddle때문이거나 또는 중간연산에서 안나누어줘서거나
    public static int solution(int m, int n, int[][] puddles) {
    	// m == width
    	// n == height
    	int[][] spots = new int[n][m];
    	
    	for(int i=0; i<n; i++) {
    		for(int j=0; j<m; j++) {    			
    			if(i==0 && j==0) spots[i][j] = 1;
    			else if(isPuddle(i, j, puddles)) spots[i][j]=0;
    			else if(i==0) spots[i][j]=spots[i][j-1];
    			else if(j==0) spots[i][j]=spots[i-1][j];
    			else spots[i][j]=spots[i-1][j]+spots[i][j-1];
    		}
    	}
    	
        return spots[n-1][m-1]%1000000007;
    }
    
    public static boolean isPuddle(int w, int h, int[][] puddles) {
    	for(int[] puddle : puddles)
    		if(h+1==puddle[0] && w+1==puddle[1]) 
    			return true;
    	return false;
    }
    
    public static int solution2(int m, int n, int[][] puddles) {
    	// m == width
    	// n == height
    	int[][] spots = new int[n][m];
    	spots[0][0]=1;
    
    	for(int[] puddle : puddles)
    		spots[puddle[1]-1][puddle[0]-1]=-1;
    	
    	for(int i=1; i<n; i++) {
    		if(spots[i][0]==-1) spots[i][0]=0;
    		else spots[i][0]=spots[i-1][0];
    	}
    	for(int j=1; j<m; j++) {
    		if(spots[0][j]==-1) spots[0][j]=0;
    		else spots[0][j]=spots[0][j-1];
    	}
    		
    	for(int i=1; i<n; i++) {
    		for(int j=1; j<m; j++) {    			
    			if(spots[i][j]==-1) spots[i][j]=0;
    			else spots[i][j]=(spots[i-1][j]+spots[i][j-1])%1000000007;
    		}
    	}
    	
        return spots[n-1][m-1]%1000000007;
    }
    
    public static int solution3(int m, int n, int[][] puddles) {
    	// m == width
    	// n == height
    	int[][] spots = new int[n][m];
    
    	for(int[] puddle : puddles)
    		spots[puddle[1]-1][puddle[0]-1]=-1;
    		
    	for(int i=0; i<n; i++) {
    		for(int j=0; j<m; j++) {
    			if(i==0 && j==0) spots[i][j]=1;
    			else if(spots[i][j]==-1) spots[i][j]=0;    			
    			else if(i==0) spots[i][j]=spots[i][j-1];
    			else if(j==0) spots[i][j]=spots[i-1][j];
    			else {
    				spots[i][j]=(spots[i-1][j]+spots[i][j-1])%1000000007;
//    				spots[i][j]+=spots[i-1][j]%1000000007;
//    				spots[i][j]+=spots[i][j-1]%1000000007;
    			}
    		}
    	}
    	
        return spots[n-1][m-1]%1000000007;
    }
    
    // 다른 사람 풀이
    // m*n배열을 선언하지 않고 [m+1][n+1]배열을 선언했다.
    // 이렇게 하면 m==0일때, n==0일때를 따로 case분류를 안해줘도 된다.
    // 왜냐하면 int배열은 0으로 초기화되기 때문
    // 
    // else spots[i][j]=(spots[i-1][j]+spots[i][j-1])%1000000007;
    // 이 부분도 아랫사람은 spots[i-1][j]과 spots[i][j-1]를 나누어서 연산해주었다.
    // (이게 더 빠른가? 해서 테스트해봤는데 유의미한 차이는 없다.)
    public static int solution4(int m, int n, int[][] puddles) {
        int[][] dp = new int[m+1][n+1];
        
        for(int i=0;i<puddles.length;i++)
            dp[puddles[i][1]][puddles[i][0]]=-1;
        

        dp[1][1]=1; 
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(dp[i][j]==-1){
                    dp[i][j]=0;
                    continue;
                }
                if(i!=1)    dp[i][j]+=dp[i-1][j]%1000000007;
                if(j!=1)    dp[i][j]+=dp[i][j-1]%1000000007;
            }
        }
        
        return dp[m][n]%1000000007;
    }
}
