package prbm_greed;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class ConnectIslands1_kruskal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public static int solution(int n, int[][] costs) {
    	// KRUSKAL Algorithm : sort in increasing weight
    	ConnectorComparator c = new ConnectorComparator();
    	Arrays.parallelSort(costs, c);
    	int weight = 0;
    	ArrayList<Set<Integer>> sets = new ArrayList<>();
    	for(int[] bridge : costs) {
    		int a = getInt(sets, bridge[0]);
    		int b = getInt(sets, bridge[1]);
    		
    		if(a<100 && b<100 && a==b) continue; // makes a cycle;
    		
    		weight+=bridge[2];    		
    		
    		if (a>100 && b>100) {
    			Set<Integer> temp = new HashSet<Integer>();
    			temp.add(bridge[0]);
    			temp.add(bridge[1]);    			
    			sets.add(temp);
    		} else if(a<100 && b>100) { // attach b to a;
    			sets.get(a).add(bridge[1]);
    		} else if(a>100 && b<100) { // attach a to b;
    			sets.get(b).add(bridge[0]); 
    		} else { // link a & b
    			sets.get(a).addAll(sets.get(b));
    			sets.remove(b);
    		}
    	}
    	
        return weight;
    }
    
    public static int getInt(ArrayList<Set<Integer>> sets, int n) {
    	for(int i=0; i<sets.size(); i++)
    		if(sets.get(i).contains(n)) return i;
    	return 101;
    }

}

class ConnectorComparator implements Comparator<int[]> {
	@Override
	public int compare(int[] o1, int[] o2) {
		return o2[2] - o1[2];
	}
}