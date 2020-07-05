package prbm_greed;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class ConnectIslands2_prim {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public int solution(int n, int[][] costs) {
        int answer = 0;
        int[][] map = new int[n][n];
        for(int i = 0; i < costs.length; i++) {
            map[costs[i][0]][costs[i][1]] = costs[i][2];
            map[costs[i][1]][costs[i][0]] = costs[i][2];            
        }
        boolean[] connected = new boolean[n];
        connected[0] = true;
        answer = prim(map, connected, 0, 1);
        return answer;
    }   

    // prim을 사용한 다른사람 풀이
    public static int prim(int[][] map, boolean[] connected, int value, int count) {
        if (count == connected.length) return value; 
        int to = -1;
        int min = Integer.MAX_VALUE; 
        for (int i = 0; i < connected.length; i++) {
            if (connected[i]) { 
                for (int j = 0; j < map.length; j++) { 
                    if (!connected[j] && map[i][j] != 0 && min > map[i][j]) { 
                        to = j; 
                        min = map[i][j]; 
                    }
                }
            }
        }
        connected[to] = true;
        value += min; 
        count++; 
        return prim(map, connected, value, count);
    }

}
