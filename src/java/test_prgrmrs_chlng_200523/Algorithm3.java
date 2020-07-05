package test_prgrmrs_chlng_200523;

import java.util.ArrayList;
import java.util.Arrays;

public class Algorithm3 {
	public static void main(String[] args) {
		int[][] skills = {{3, 4}, {3, 5}, {3, 6}, {1, 2}, {1, 3}, {6, 7}, {1, 8}};
		int total_sp = 121;
		Solution3 solution = new Solution3();
		int[] ans = solution.solution(total_sp, skills);
		System.out.println(Arrays.toString(ans));		
	}
}

class Solution3 {
    public int[] solution(int total_sp, int[][] skills) {
        Node[] tree = new Node[skills.length+1];
		// Initialize
		for(int i=0; i<tree.length; i++)
			tree[i] = new Node(i);
        
		// Make a Tree
		for(int[] skill : skills)
			tree[skill[0]-1].subSkills.add(tree[skill[1]-1]);
		
		// Travelsal
		boolean[] isVisited = new boolean[skills.length+1];
		for(int i=0; i<tree.length; i++)
			search(tree[i], isVisited);
        
        // Formatting
		int numerator = 0;
		for(Node node : tree)
			numerator+= node.points;
		
		int multiplier = total_sp / numerator;
		int[] answer = new int[skills.length+1];
		for(Node node : tree) {
			answer[node.index] = node.points*multiplier;
		}
        
        return answer;
    }
    
    	public int search(Node node, boolean[] isVisited) {
		// if this node is already visited
		if(isVisited[node.index]==true) return node.points;
		
		// if this is a leaf node
		ArrayList<Node> subSkills = node.subSkills;
		if(subSkills.size()==0) {
			isVisited[node.index] = true;
			node.points = 1;
			return 1;			
		}
		
		// if not visited yet and not a leaf node
		int points = 0;
		for(int j=0; j<subSkills.size(); j++) {
			points += search(subSkills.get(j), isVisited); 
		}
		node.points = points;
		isVisited[node.index] = true;
		return points;
	}
}

class Node {
	int index;
	int points;
	ArrayList<Node> subSkills;
	
	public Node(int index) {
		this.index = index;
		subSkills = new ArrayList<>();
	}	
}
