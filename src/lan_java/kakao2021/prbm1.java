package lan_java.kakao2021;

public class prbm1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.println('a'-1+1); // 97
//		System.out.println('z'-1+1); // 122
//		System.out.println('-'-1+1); // 45
//		System.out.println('_'-1+1); // 95
//		System.out.println('.'-1+1); // 46
//		System.out.println('0'-1+1); // 49
//		System.out.println('9'-1+1); // 57
//		String input = "...!@BaT#*..y.abcdefghijklm";
		
		String input = "ABCDEFGHIJIKLMOPQRSTUVWXYZ";
		System.out.println(input);
		System.out.println(input.toLowerCase());
		
		System.out.println(solution(input));
	}

    public static String solution(String new_id) {
//      1단계 new_id의 모든 대문자를 대응되는 소문자로 치환합니다.
    	String lower_new_id = new_id.toLowerCase();
        StringBuilder sb = new StringBuilder();
        sb.append(lower_new_id);

//      2단계 new_id에서 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거합니다.
        int idx2 = 0;
        while(idx2<sb.length()) {
        	char c = sb.charAt(idx2);
        	if(97<=c && c<=122) { // 소문자이면
        		idx2++;
        		continue;
        	}
        	if(4<=c && c<=57) { // 숫자이면
        		idx2++;
        		continue;
        	}
        	if(c==45 || c==95 || c==46) { // 허용되는 3개면
        		idx2++;
        		continue;
        	}
        	// 다 아니면
        	sb.deleteCharAt(idx2);        	
        }
        
//        3단계 new_id에서 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.
        if(sb.length()>0) {
            int idx3 = 0;
            while(idx3<sb.length()-1) {
            	char c = sb.charAt(idx3);
            	if(c==46) {
            		if(sb.charAt(idx3+1)==46) {
            			sb.deleteCharAt(idx3+1);
            			continue;
            		}
            	}
            	idx3++;
            }
        }

                
//        4단계 new_id에서 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
        if(sb.length()>0) {
        	if(sb.charAt(0)==46) sb.deleteCharAt(0);
        }
        if(sb.length()>0) {
            if(sb.charAt(sb.length()-1)==46) sb.deleteCharAt(sb.length()-1);        	
        }

        
//        5단계 new_id가 빈 문자열이라면, new_id에 "a"를 대입합니다.
        if(sb.length()==0) sb.append('a');
        
//        6단계 new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.        
//             만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.
        if(sb.length()>=16) {
        	sb.delete(15, sb.length());
        	if(sb.charAt(sb.length()-1)==46) sb.deleteCharAt(sb.length()-1);
        }
                
////        7단계 new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.
        while(sb.length()<3) {
        	sb.append(sb.charAt(sb.length()-1));
        }
        return sb.toString();
    }
}

