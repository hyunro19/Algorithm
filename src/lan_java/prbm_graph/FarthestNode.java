package lan_java.prbm_graph;

import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class FarthestNode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class SolutionFarthestNode {
    public int solution(int n, int[][] edge) {
        // 2���� �迭�� �ʱ�ȭ (�޸� ����)
        // int[][] vertex = new int[n+1][n+1];
        // for(int[] v : edge) {
        //     vertex[v[0]][v[1]]=1;
        //     vertex[v[1]][v[0]]=1;
        // }
        
        // ��������Ʈ�� ����
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        for(int[] v : edge) {
            ArrayList<Integer> a = map.get(v[0]);
            if(a == null) {
                a = new ArrayList<Integer>();
                a.add(v[1]);            
                map.put(v[0], a);
            } else {
                a.add(v[1]);
            }
                         
            ArrayList<Integer> b = map.get(v[1]);
            if(b == null) {
                b = new ArrayList<Integer>();
                b.add(v[0]);            
                map.put(v[1], b);
            } else {
                b.add(v[0]);     
            }
        }
        
        int[] visited = new int[n+1];
        Queue<Integer> queue = new LinkedList<>();
        
        queue.offer(1);
        visited[1]++;
        while(!queue.isEmpty()) {
            int temp = queue.poll();
            for(int i=1; i<=n; i++) {
                if(map.get(temp)==null) {
                    System.out.println(temp);
                    continue;
                }
                if(map.get(temp).contains(i) && visited[i]==0) {
                    queue.offer(i);   
                    visited[i] = visited[temp]+1;
                }
            }
        }
        int max=0;
        int cnt=0;
        for(int i : visited) {
            if(i<max) {
                continue;
            } else if(i>max) {
                max=i;
                cnt=1;
            } else if(i==max) {
                cnt++;
            }
        }
        return cnt;
    }
}