package jv.pg.montly_challenge;

public class M09_PB02 {

	public static void main(String[] args) {
		// 숫자 n이 주어질 때,
		// 피라미드 모양으로 맨 윗줄부터 한 줄씩 1칸, 2칸, 3칸, 4칸 ... 박스를 쌓을 때
		// 맨 윗칸부터 반시계방향으로 & 안쪽으로 1, 2, 3, 4, 5, ... 번호를 매긴다.
		// 그렇게 다 매긴 후 맨 윗줄부터, 그리고 왼쪽에서부터 매긴 번호를 다시 써내려가면?
		
		// input = 4
		//    1
		//   2 9
		//  3 10 8  
		// 4 5  6 7
		
		// output
		// 1, 2, 9, 3, 10, 8, 4, 5, 6, 7
		
		int n = 4;
		System.out.println(n*(n+1)/2);
	}
	
	public int[] solution(int n) {
        int[][] tower = new int[n][n];
        int max = n*(n+1)/2;
        int row = 0;
        int col = 0;
        
        int status = 0; // 0, 1, 2
        
        for(int i=1; i<=max; i++) {
            if(status==0) {
                // System.out.print("0 ");
                tower[row][col]=i;
                if(row+1>=n || tower[row+1][col]!=0) {
                    status = 1;
                    col++;
                    continue;                    
                }
                row++;
            } else if (status==1) {
                // System.out.print("1 ");
                tower[row][col]=i;
                if(col+1>row || tower[row][col+1]!=0) {
                    status = 2;
                    col--;
                    row--;
                    continue;
                }
                col++;
            } else if (status==2) {
                // System.out.print("2 ");
                tower[row][col]=i;
                if(tower[row-1][col-1]!=0) {
                    status = 0;
                    row++;
                    continue;
                }
                row--;
                col--;
            }
        }
        // System.out.println("");
        // for(int i=0; i<n; i++) {
        //     for(int j=0; j<n; j++) {
        //         System.out.print(tower[i][j]+", ");
        //     }
        //     System.out.println("");
        // }
        
        int[] answer = new int[max];
        int idx = 0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(tower[i][j]!=0) {
                    answer[idx++]=tower[i][j];
                } else { // if tower[i][j]==0
                    continue;
                }
                
            }
        }
        // for(int a : answer) 
        //     System.out.print(a+", ");
        
        return answer;
    }
    
}
