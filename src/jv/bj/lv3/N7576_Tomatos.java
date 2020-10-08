package jv.bj.lv3;

import java.util.*;

public class N7576_Tomatos {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String nextLine = sc.nextLine();
		String[] rowCol = nextLine.split(" ");
		int row = Integer.parseInt(rowCol[1]);
		int col = Integer.parseInt(rowCol[0]);
		
		int[][] box = new int[row][col];
		Queue<int[]> queue = new LinkedList<>();
		
		for(int i=0; i<row; i++) {
			nextLine = sc.nextLine();
			String[] split = nextLine.split(" ");
			for(int j=0; j<col; j++) {
				box[i][j] = Integer.parseInt(split[j]);
				
				if(box[i][j]==1) {
					int[] ripeCell = {i, j};
					queue.add(ripeCell);
				}
			}
		}
		if(isAllRipe(box)) {
			System.out.println(0);
			sc.close();
			return;
		}
		int cnt = -1;
		while(!queue.isEmpty()) {
			// queue의 상하좌우를 살피고, 0이면 queue에 넣기
			Queue<int[]> nextQueue = new LinkedList<>();
			bfs(queue, box, nextQueue);
			queue = nextQueue;
			cnt++;
		}
		if(isAllRipe(box)) {
			System.out.println(cnt);
		} else {
			System.out.println(-1);
		}
		sc.close();
	}
	// 토마토 상자를 검사해서, 0이 하나라도 있으면 false, 없으면 true를 반환하는 메소드
	public static boolean isAllRipe(int[][] box) {
		int row = box.length;
		int col = box[0].length; 
		for(int i=0; i<row; i++) {
			for(int j=0; j<col; j++) {
				if(box[i][j]==0) return false;
			}
		}
		return true;
	}
	public static void bfs(Queue<int[]> queue, int[][] box, Queue<int[]> nextQueue) {
		while(!queue.isEmpty()) {
			int r = box.length;
			int c = box[0].length;
			int[] cell = queue.poll();
			int row = cell[0];
			int col = cell[1];
			if(cell[0]>0) {
				if(box[row-1][col]==0) {
					box[row-1][col]=1;
					int[] ripeCell = {row-1, col};
					nextQueue.add(ripeCell);
				}
			}
			if(cell[0]<r-1) {
				if(box[row+1][col]==0) {
					box[row+1][col]=1;
					int[] ripeCell = {row+1, col};
					nextQueue.add(ripeCell);
				}
			}
			if(cell[1]>0) {
				if(box[row][col-1]==0) {
					box[row][col-1]=1;
					int[] ripeCell = {row, col-1};
					nextQueue.add(ripeCell);
				}
			}
			if(cell[1]<c-1) {
				if(box[row][col+1]==0) {
					box[row][col+1]=1;
					int[] ripeCell = {row, col+1};
					nextQueue.add(ripeCell);
				}
			}
		}		
	}
}
