package jv.pg.kakao_intern_2019_FW;

import java.util.*;

public class CraneDollDraw {

	public static void main(String[] args) {
		int[][] board = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
		int[] moves = {1,5,3,5,1,2,1,4};
		System.out.println(solution(board, moves));
	}
	
    public static int solution(int[][] board, int[] moves) {
    	int N = board.length;
    	int cnt = 0;
    	Stack<Integer> stack = new Stack<>();
    	
    	// moves를 차례대로 순회함
    	for(int m : moves) {
    		int row = 0;
    		int col = m-1;
    		// moves에 해당하는 row에서 0부터 차례대로 0이아닌걸 만날때까지 row를 ++한다.
    		while(row<N && board[row][col]==0) {
    			row++;
    		}
    		
    		if(row>=N) continue;
    		// 0이 아닌걸 만나면 해당 cell은 0으로 바꿈. 인형은 따로 참조해두고
    		int temp = board[row][col];
    		board[row][col] = 0;
    		
    		// 만들어둔 stack을 peek해서 인형과 비교,
    		if(!stack.isEmpty() && stack.peek()==temp) {
    			// 동일할 경우 stack을 pop하면서 cnt를 2개 추가
    			stack.pop();
    			cnt+=2;
    		} else {
    			// 다를 경우 stack에 push
    			stack.push(temp);
    		}
    		
    	}
    	
        return cnt;
    }

}
