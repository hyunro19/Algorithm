package prbm_hashing;

import java.util.Arrays;
import java.util.Comparator;

public class PhoneNumList {

	public static void main(String[] args) {
		String[] phone_book = {"119", "97674223", "1195524421"};
		System.out.println(solution(phone_book));		
	}
	
    public static boolean solution(String[] phone_book) {
    	// comparator를 람다로 간단하게 구현!
        // Arrays.sort(phoneBook, (String a, String b) -> a.length()-b.length() );
    	
    	
    	// 글자수 순서대로 정렬
    	// 오히려 정렬을 하니까 시간초과가 뜬다. 정렬 안하면 통과
//    	Comparator<String> comparator = new Comparator<String>() {
//			@Override
//			public int compare(String o1, String o2) {
//				int l1 = o1.length();
//				int l2 = o2.length();
//				if(l1>l2) return 1;			
//				return -1;
//			}    		
//    	};
//    	Arrays.sort(phone_book, comparator);

    	// 낮은 글자수부터 시작해서 for-for-loop돌림

    	for(int i=0; i<phone_book.length-1; i++) {
    		for(int j=i+1; j<phone_book.length; j++) {
    	    	// 낮은글자수기준으로 앞에서부터 substring하고 .equals
    			int length = Math.min(phone_book[i].length(), phone_book[j].length());
    			if(phone_book[i].substring(0, length).equals(phone_book[j].substring(0, length))) return false;
    		}
    	}
    	return true;
    }
    
    // 다른 사용자 풀이 startsWith 사용
    public static boolean solution2(String[] phone_book) {
        for(int i=0; i<phone_book.length-1; i++) {
            for(int j=i+1; j<phone_book.length; j++) {
                if(phone_book[i].startsWith(phone_book[j])) {return false;}
                if(phone_book[j].startsWith(phone_book[i])) {return false;}
            }
        }
        return true;
    }

}
