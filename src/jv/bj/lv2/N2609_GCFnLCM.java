package jv.bj.lv2;

import java.util.*;

public class N2609_GCFnLCM {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String nextLine = sc.nextLine();
		sc.close();
		
		String[] split = nextLine.split(" ");
		int[] nums = {Integer.parseInt(split[0]), Integer.parseInt(split[1])};
		int less = Math.min(nums[0], nums[1]);
		int more = Math.max(nums[0], nums[1]);
		
		ArrayList<Integer> primeNums = new ArrayList<>();
		for(int i=1; i<=more; i++)
			if(isPrime(i))
				primeNums.add(i);
		
		int lcm = 1;
		int gcf = 1;
		
		while(less>1 || more>1) {
			for(int i : primeNums) {
				boolean boolLess = less%i==0;
				boolean boolMore = more%i==0;
				
				if(boolLess && boolMore) {
					less /= i;
					more /= i;
					gcf *= i;
					break;
				}
				if(boolLess) {
					less /= i;
					lcm *= i;
					break;
				}
				if(boolMore) {
					more /= i;
					lcm *= i;
					break;
				}
			}
		}
		
		lcm *= gcf;
			
		System.out.println(gcf);
		System.out.println(lcm);
		
	}
	
	public static boolean isPrime(int input) {
	  	if(input==1) return false;

	  	for(int i=2; i<=Math.sqrt(input); i++) {
	  		if(input%i==0)
				return false;
	  	}        

	    return true;
	}
}	