package jv.pg.prbm_dp;

public class WayToSchool {

	public static void main(String[] args) {
//		long before = System.currentTimeMillis();
		System.out.println(
				solution3(5, 7, new int[][]{{2, 1},{1, 3},{3, 3}})
				);
//		long after = System.currentTimeMillis();
//		System.out.println(after-before);
	}

	// ��� ĭ���� isPuddle�� �����ϴ� �ð��ʰ�
	// isPuddle�����̰ų� �Ǵ� �߰����꿡�� �ȳ������༭�ų�
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
    
    // �ٸ� ��� Ǯ��
    // m*n�迭�� �������� �ʰ� [m+1][n+1]�迭�� �����ߴ�.
    // �̷��� �ϸ� m==0�϶�, n==0�϶��� ���� case�з��� �����൵ �ȴ�.
    // �ֳ��ϸ� int�迭�� 0���� �ʱ�ȭ�Ǳ� ����
    // 
    // else spots[i][j]=(spots[i-1][j]+spots[i][j-1])%1000000007;
    // �� �κе� �Ʒ������ spots[i-1][j]�� spots[i][j-1]�� ����� �������־���.
    // (�̰� �� ������? �ؼ� �׽�Ʈ�غôµ� ���ǹ��� ���̴� ����.)
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
