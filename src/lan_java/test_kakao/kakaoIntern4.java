package lan_java.test_kakao;

import java.util.LinkedList;
import java.util.Queue;


// �Ϻ� �����鿡�� �ð��ʰ�
// ������ �ڵ忡�� 58������ ���µ�, �̰� �߰��Ǹ� ������� ������? ���߿� ���α׷��ӽ��� ���� �ö���� ������Ѻ� ����
public class kakaoIntern4 {
	static Queue<int[]> q = new LinkedList<>(); 
	static int[][] directions = {
			{-1, 0}, // �� 0
			{0, +1}, // �� 1
			{+1, 0}, // �� 2
			{0, -1}, // �� 3
	};
	static int N = 0;
	static int[][] boards;
	static int answer = Integer.MAX_VALUE;
	public static void main(String[] args) {
		int[][] board = //{{0,0,0},{0,0,0},{0,0,0}};
				{{0,0,0,0,0,0,0,1},{0,0,0,0,0,0,0,0},{0,0,0,0,0,1,0,0},{0,0,0,0,1,0,0,0},{0,0,0,1,0,0,0,1},{0,0,1,0,0,0,1,0},{0,1,0,0,0,1,0,0},{1,0,0,0,0,0,0,0}};
		System.out.println(solution(board));

	}
    public static int solution(int[][] board) {
    	boards = board;
    	N = boards.length;  
        q.add(new int[]{0,0});
        int[] current = new int[2];
        int befores = 0;
        boards[0][0] = 1;
        
        // �������� �����ϴ� ���
        if(boards[0][1] ==0) {
        	befores = 1;
            current[0]=0;
            current[1]=1;
            boards[0][1] = 1;
            bfs(befores, current, 100);
            boards[0][1] = 0;
        }
        
        // �������� �����ϴ� ���
        if(boards[1][0] == 0) {
        	befores = 2;
            current[0]=1;
            current[1]=0;
            boards[1][0] = 1;
            bfs(befores, current, 100);
            boards[1][0] = 0;
        }
              
        return answer;
    }
    
    public static void bfs(int before, int[] current, int sum) {
    	if(sum>answer) return; // �̰� �־����... �ð��ʰ��� �ȵ�����.
    	if(current[0]==N-1 && current[1]==N-1) {
    		if(sum<answer) {
    			answer = sum;
    		}
    		return;
    	}
    	for(int i=0; i<4; i++) {
    		int[] dir = directions[i];
    		if( current[0]+dir[0] < N && current[0]+dir[0] >= 0 && 
    				current[1]+dir[1] < N && current[1]+dir[1] >= 0 ) {
				if (boards[ current[0]+dir[0] ][ current[1]+dir[1] ] == 0) {
					boards[ current[0]+dir[0] ][ current[1]+dir[1] ] = 1;
					if(before == i) {
						current[0]+=dir[0];
						current[1]+=dir[1];
						bfs(i, current, sum+=100);
						current[0]-=dir[0];
						current[1]-=dir[1];
					} else {
						current[0]+=dir[0];
						current[1]+=dir[1];
						bfs(i, current, sum+=600);
						current[0]-=dir[0];
						current[1]-=dir[1];
					}
					boards[ current[0]+dir[0] ][ current[1]+dir[1] ] = 0;
				}
    			
    		}

    	}
    }
}


