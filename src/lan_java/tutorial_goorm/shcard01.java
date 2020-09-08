package lan_java.tutorial_goorm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class shcard01 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input1 = br.readLine();		
		String input2 = br.readLine();
		if(Integer.parseInt(input1)<3) {
			System.out.println("NO");
			return;
		}
		String[] problems = input2.split(" ");
		Set<String> set = new HashSet<>();
		for(String p : problems) {
			set.add(p);
			if(set.size()>=3) {
				System.out.println("YES");
				return;
			}
		}
		System.out.println("NO");
		return;
	}
}
