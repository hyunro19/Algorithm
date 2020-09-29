package jv.pg.montly_challenge;

// 시간초과로 실패 ㅠㅠ
public class M09_PB04_CountingEvenRows {

	public static void main(String[] args) {
		int[][] a = {{0,1,0},{1,1,1},{1,1,0},{0,1,1}};
		System.out.println(solution(a));
		// N-Queens문제처럼 풀었는데... 
		// 시간초과 떠서 1/3만 통과했다.

	}
	
    public static int solution(int[][] a) {
        int rows = a.length;
        int cols = a[0].length;
        
        // a의 각 열에 있는 1의 개수를 알아야 겠네
        int[] numOfOneOfA = new int[cols];
        for(int r=0; r<rows; r++)
            for(int c=0; c<cols; c++)
                if(a[r][c]==1) ++numOfOneOfA[c];

        // for(int n : numOfOneOfA) System.out.print(n+", ");
        // System.out.println("");
        // 2 4 2 // 2 0 0 // 2 1 0 1 2       
        
        int[][] b = new int[rows][cols];
        int ans = dfs(b, numOfOneOfA, rows, cols, 0, 0);
        ans = ans%10000019;
        return ans;
    }


        // r행에 대해서 c를 조합한다.
        // c를 조합하는데 numOfOne의 남은 숫자가 c의 남은 숫자와 같으면 무조건 1을 채워야하고
        // 그렇지 않으면 0이 될 수도 1이될 수도 있다.
        // c를 다 채우고 c행의 1의 숫자가 짝수가 아니면 promising하지 않으므로 return 0;

    // 너무 복잡하다.. 2차원 dfs
    public static int dfs(int[][] b, int[] numOfOneOfA, int rows, int cols, int cidx, int ridx) {
    	if(ridx==rows) return 1;
        
        // 이하 ridx < rows    	    	
    	if(cidx==cols) {
    		if(hasEvenOnes(b[ridx])) {
    		    return dfs(b, numOfOneOfA, rows, cols, 0, ridx+1);
    		} else {
    			return 0;
    		}
    	} else { // 이하 cidx < cols
            if(numOfOneOfA[cidx]==rows-ridx) { // 남은 row numOfOne가 모두 1이 되야 하는 경우
                b[ridx][cidx]=1;
                numOfOneOfA[cidx]-=1;
                int cnt = dfs(b, numOfOneOfA, rows, cols, cidx+1, ridx);
                b[ridx][cidx]=0;     
                numOfOneOfA[cidx]+=1;
                return cnt%10000019;
            } else if(numOfOneOfA[cidx]==0) { // 0이어야만 하는 경우
                int cnt =dfs(b, numOfOneOfA, rows, cols, cidx+1, ridx);                    
                return cnt%10000019;
            } else { // 0이어도, 1이어도 되는 경우
                int cnt = 0;
                cnt+=dfs(b, numOfOneOfA, rows, cols, cidx+1, ridx); // 0일 때
                b[ridx][cidx]=1;
                numOfOneOfA[cidx]-=1;
                cnt+=dfs(b, numOfOneOfA, rows, cols, cidx+1, ridx); // 1일 때
                b[ridx][cidx]=0;     
                numOfOneOfA[cidx]+=1;
                return cnt%10000019;
            }	   
        }
    	// cnt= cnt%10000019;
    	// return cnt;
    }
    
    public static boolean hasEvenOnes(int[] row) {
    	int cnt = 0;
    	
    	for(int c=0; c<row.length; c++)
    		if(row[c]==1) 
    			++cnt;

    	if(cnt%2==0) return true;
    	else return false;
    }
}