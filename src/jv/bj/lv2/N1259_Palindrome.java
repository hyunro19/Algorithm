package jv.bj.lv2;

import java.util.*;

public class N1259_Palindrome {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			String nextLine = sc.nextLine();
			if(nextLine.equals("0")) {
				break;
			}
			boolean isPalindrome = true;
			for(int i=0; i<nextLine.length()/2; i++) {
				char fromLeft = nextLine.charAt(i);
				char fromRight = nextLine.charAt(nextLine.length()-1-i); 
				if(fromLeft!=fromRight) {
					isPalindrome = false;
					break;
				}
			}
			
			if(isPalindrome) System.out.println("yes"); 
			else System.out.println("no");
		}		
		sc.close();
	}

}
