package lan_java.prbm_hashing;

import java.util.Arrays;
import java.util.Comparator;

public class PhoneNumList {

	public static void main(String[] args) {
		String[] phone_book = {"119", "97674223", "1195524421"};
		System.out.println(solution(phone_book));		
	}
	
    public static boolean solution(String[] phone_book) {
    	// comparator�� ���ٷ� �����ϰ� ����!
        // Arrays.sort(phoneBook, (String a, String b) -> a.length()-b.length() );
    	
    	
    	// ���ڼ� ������� ����
    	// ������ ������ �ϴϱ� �ð��ʰ��� ���. ���� ���ϸ� ���
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

    	// ���� ���ڼ����� �����ؼ� for-for-loop����

    	for(int i=0; i<phone_book.length-1; i++) {
    		for(int j=i+1; j<phone_book.length; j++) {
    	    	// �������ڼ��������� �տ������� substring�ϰ� .equals
    			int length = Math.min(phone_book[i].length(), phone_book[j].length());
    			if(phone_book[i].substring(0, length).equals(phone_book[j].substring(0, length))) return false;
    		}
    	}
    	return true;
    }
    
    // �ٸ� ����� Ǯ�� startsWith ���
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
