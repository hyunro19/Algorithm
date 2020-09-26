package jv.pg.prbm_sort;

import java.util.ArrayList;
import java.util.Comparator;

public class BiggestNum {
	
	public static void main(String[] args) {
//		int[] numbers = {0, 0, 0, 0, 0};
//		int[] numbers = {21, 212};
//		int[] numbers = {12, 121};
//		int[] numbers= {0, 1000, 0, 0};
		int[] numbers = {1, 1177, 177, 3, 30};
		String answer = solution(numbers);
		System.out.println(answer);
	}

    public static String solution(int[] numbers) {
    	Comparator<String> comparator = new Comparator<String>() {
    		public int compare(String str1, String str2) {
    			if(str1.length() == str2.length()) {
    				return str1.compareTo(str2);
    			}
    			String left = str1+str2;
    			String right = str2+str1;
                return (left.compareTo(right)>0) ? 1 : -1;    			
    			
//    			String shorterStr;
//    			String longerStr;
//    			int shorterLen=0;
//    			int longerLen=0;
//    			
//    			if (str1.length() > str2.length()){
//    				longerStr = str1;
//    				longerLen = str1.length();
//    				shorterStr = str2;
//    				shorterLen = str2.length();    				
//    			} else { // if (str1.length() < str2.length())
//    				longerStr = str2;
//    				longerLen = str2.length();
//    				shorterStr = str1;
//    				shorterLen = str1.length();    				
//    			}
//    			
//    			int i=0;
//    			while(i<shorterLen) {
//    				if( str1.charAt(i) != str2.charAt(i) ) {
//    					return str1.charAt(i) - str2.charAt(i);
//    				}
//    				i++;
//    			}
//    			
//    			if(longerStr.charAt(i) >= shorterStr.charAt(0)) {
//    				return (longerStr == str1) ? 1 : -1; 
//    			} else {
//    				return (longerStr == str1) ? -1 : 1;
//    			}
//    
    		}
    	};
    	
		ArrayList<String> array = new ArrayList<String>(numbers.length);
        for(int i=0; i<numbers.length; i++) {
            array.add(String.valueOf(numbers[i]));
        }
		array.sort(comparator);
		StringBuilder sb = new StringBuilder();;
		for(int i=array.size()-1; i>=0; i--) {
			sb.append(array.get(i));
		}
		return sb.charAt(0) == '0' ? "0" : sb.toString();
//		String answer = sb.toString();
//		if(answer.equals("")) answer = "0";
//        return answer;
	}

}