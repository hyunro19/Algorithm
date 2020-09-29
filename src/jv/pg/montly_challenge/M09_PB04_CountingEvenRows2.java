package jv.pg.montly_challenge;

import java.util.*;

// 메모리 초과로 실패 ㅠㅠ
public class M09_PB04_CountingEvenRows2 {

	public static void main(String[] args) {
		int[][] a = {{0,1,0},{1,1,1},{1,1,0},{0,1,1}};
		System.out.println(solution(a));
		// N-Queens문제처럼 풀었는데... 
		// 시간초과 떠서 1/3만 통과했다.

	}
	
    static int ans = 0;
    static int rows;
    static int cols;
    public static int solution(int[][] a) {
        rows = a.length;
        cols = a[0].length;
        
        // a의 각 열에 있는 1의 개수를 알아야 겠네
        int[] numOfOneOfA = new int[cols];
        for(int r=0; r<rows; r++)
            for(int c=0; c<cols; c++)
                if(a[r][c]==1) ++numOfOneOfA[c];
        
        Map<Integer, ArrayList<int[]>> map = new HashMap<>();
        for(int i=0; i<numOfOneOfA.length; i++) {
            if(map.get(numOfOneOfA[i])==null) {
                map.put(numOfOneOfA[i], new ArrayList<int[]>());
                ArrayList<int[]> arr = map.get(numOfOneOfA[i]);
                int[] inOrOut = new int[rows];
                comb(inOrOut, 0, rows, numOfOneOfA[i], arr);
            }                    
        }
        
        int[][] b = new int[cols][rows];                
        
        perm(b, numOfOneOfA, map, 0);
                
        return ans;
    }
    public static void perm(int[][] b, int[] numOfOneOfA, Map<Integer, ArrayList<int[]>> map, int depth) {
        if(depth == cols) {            
            if(isEven(b)) {
                // System.out.println(depth+" 0");
                ++ans;
                ans = ans%10000019;
            }
            return;
        }
        

        ArrayList<int[]> combination = map.get(numOfOneOfA[depth]);
        for(int j=0; j<combination.size(); j++) {
            // System.out.println(depth+", "+j);
            b[depth] = combination.get(j);
            perm(b, numOfOneOfA, map, depth+1);
        }

    }
    public static void comb(int[] inOrOut, int depth, int n, int r, ArrayList<int[]> arr) {
        if(r==0) {
            arr.add(Arrays.copyOf(inOrOut, inOrOut.length));
            return;
        }
        if(depth==n) {
            return;
        }
        
        inOrOut[depth] = 1;
        comb(inOrOut, depth+1, n, r-1, arr);
        inOrOut[depth] = 0;
        comb(inOrOut, depth+1, n, r, arr);        
    }
    
    public static boolean isEven(int[][] b) { // int[cols][rows];
        for(int r=0; r<rows; r++) {        
            int cnt = 0;
            for(int c=0; c<cols; c++) {    
                if(b[c][r]==1) ++cnt;                
            }
            if(cnt%2==0) continue;
            else return false;
        }
        
        // for(int r=0; r<rows; r++) {
        //     for(int c=0; c<cols; c++) {
        //         System.out.print(b[c][r]+" ");
        //     }
        //     System.out.println("");
        // }
        // System.out.println("--print b");
        return true;
    }
}