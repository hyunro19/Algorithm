package jv.pg.prbm_graph;

public class Rank {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}


class SolutionRank {
    public int solution(int n, int[][] results) {
        int[][] vertex = new int[n+1][n+1];
        int[] cnt = new int[n+1];
        // �ʱ�ȭ
        for(int[] rst : results) {
            vertex[rst[0]][rst[1]] = 1;
        }
        
        for(int k=1; k<=n; k++) {
            for(int i=1; i<=n; i++) {
                for(int j=1; j<=n; j++) {
                    if(vertex[i][k]==1 && vertex[k][j]==1) {
                        vertex[i][j]=1;
                    }
                }
            }
        }

        int answer = 0;
        for(int i=1; i<=n; i++) {
            int tmp = 0;
            for(int j=1; j<=n; j++) {
                if(vertex[i][j]==1) {
                    ++cnt[i];
                    ++cnt[j];
                }
            }
        }
        
        for(int i=1; i<=n; i++) {
            if(cnt[i]==n-1) ++answer;
        }
        
        return answer;
    }
}