package jv.bj.lv3;

import java.util.*;

public class N11724_CountConnectedComponents {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String nextLine = sc.nextLine();
		String[] nodesEdges = nextLine.split(" ");
		int numOfNodes = Integer.parseInt(nodesEdges[0]);
		int numOfEdges = Integer.parseInt(nodesEdges[1]);
		LinkedList<Set<Integer>> outerList = new LinkedList<>();
		
		// 아무 Edge에도 속하지 않은 Node들은 별개의 Components로 Count해주어야 한다.
		for(int i=0; i<numOfNodes; i++) {
			Set<Integer> node = new HashSet<>();
			node.add(i+1);
			outerList.add(node);
		}
		
		for(int i=0; i<numOfEdges; i++) {
			nextLine = sc.nextLine();
			String[] split = nextLine.split(" ");
			int nodeA = Integer.parseInt(split[0]);
			int nodeB = Integer.parseInt(split[1]);
			Set<Integer> setA=null;
			Set<Integer> setB=null;
			for(Set<Integer> innerSet : outerList) {				
				if(innerSet.contains(nodeA)) setA = innerSet;
				if(innerSet.contains(nodeB)) setB = innerSet;
				if(setA!=null && setB!=null) break;
			}
			if(setA!=setB){
				outerList.remove(setA);
				setB.addAll(setA);
			}
		}
		System.out.println(outerList.size());
		sc.close();
	}

}