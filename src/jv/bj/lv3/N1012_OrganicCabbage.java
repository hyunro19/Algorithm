package jv.bj.lv3;

import java.util.*;

public class N1012_OrganicCabbage {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String nextLine = sc.nextLine();
		int caseNum = Integer.parseInt(nextLine);
		for(int i=0; i<caseNum; i++) {
			int numOfWorm = 0;
			nextLine = sc.nextLine();
			String[] split = nextLine.split(" ");
			int width = Integer.parseInt(split[0]);
			int height = Integer.parseInt(split[1]);
			int cabbageNum = Integer.parseInt(split[2]);
			int[][] matrix = new int[width][height];
			boolean[][] visited = new boolean[width][height];
			for(int j=0; j<cabbageNum; j++) {
				nextLine = sc.nextLine();
				split = nextLine.split(" ");
				int w = Integer.parseInt(split[0]);
				int h = Integer.parseInt(split[1]);
				matrix[w][h] = 1;
			}
			// 여기까지 밭 다 만듬
			for(int a=0; a<width; a++) {
				for(int b=0; b<height; b++) {
					if(matrix[a][b]==1 && visited[a][b]==false) {
						++numOfWorm;
						bfs(matrix, visited, a, b, width, height);
					}
				}
			}
			System.out.println(numOfWorm);
		}
			
			
		sc.close();
	}
	public static void bfs(int[][] matrix, boolean[][] visited, int w, int h, int width, int height) {
		if(visited[w][h]==true) return;
		
		// 이하 visited[w][h] == false
		visited[w][h]=true;
		
		if(matrix[w][h]==0) {
			return;
		} else { // matrix[w][h]==1, 인접 4개 셀에 대해 bfs실행			
			if(w>0) bfs(matrix, visited, w-1, h, width, height);
			if(h>0) bfs(matrix, visited, w, h-1, width, height);
			if(w<width-1) bfs(matrix, visited, w+1, h, width, height);
			if(h<height-1) bfs(matrix, visited, w, h+1, width, height);			
		}
	}

}