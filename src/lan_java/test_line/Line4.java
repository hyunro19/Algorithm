package lan_java.test_line;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Line4 {

	public static void main(String[] args) {
		String[][] snapshots = {{"ACCOUNT1", "100"}, {"ACCOUNT2", "150"}};
		String[][] transactions = { {"1", "SAVE", "ACCOUNT2", "100"}, 
		                            {"2", "WITHDRAW", "ACCOUNT1", "50"}, 
		                            {"1", "SAVE", "ACCOUNT2", "100"}, 
		                            {"4", "SAVE", "ACCOUNT3", "500"}, 
		                            {"3", "WITHDRAW", "ACCOUNT2", "30"} };
		// result = [["ACCOUNT1", "50"], ["ACCOUNT2", "220"], ["ACCOUNT3", "500"]]
		ArrayList<String[]> answer = solution(snapshots, transactions);

		for(String[] outer : answer) {
			for(String inner : outer)
				System.out.print(inner+", ");
			System.out.println("");
		}
	}
	
	public static ArrayList<String[]> solution(String[][] snapshots, String[][] transactions) {
		Map<String, Integer> map = new HashMap<>();
		for(String[] snapshot : snapshots)
			map.put(snapshot[0], Integer.parseInt(snapshot[1]));			
		
		Set<String> set = new HashSet<>();
		for(String[] transaction : transactions) {
			if(set.contains(transaction[0])) continue;
			
			set.add(transaction[0]);
			if(transaction[1].equals("SAVE"))
				map.put(transaction[2], map.getOrDefault(transaction[2], 0)+Integer.parseInt(transaction[3]));
			else
				map.put(transaction[2], map.getOrDefault(transaction[2], 0)-Integer.parseInt(transaction[3]));				
		}
		ArrayList<String[]> ans = new ArrayList<>(map.size());
		
		for(String s : map.keySet()) {
			ans.add(new String[]{s, map.get(s)+""});
		}		
		ans.sort(new Comparator<String[]>() {
			@Override
			public int compare(String[] o1, String[] o2) {
				return o1[0].compareTo(o2[0]);
			}
		});
		return ans;
	}

}
