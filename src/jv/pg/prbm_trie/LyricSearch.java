package jv.pg.prbm_trie;
// https://programmers.co.kr/learn/courses/30/lessons/60060



public class LyricSearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

// Trie�� Ǯ��
class Solution2 {
    public int[] solution(String[] words, String[] queries) {
    	
    	
    	
    	return new int[3];
    }
}




// Parsing�� �̿��� Ǯ��
// �ð����⵵ m*n���� ���X
class Solution1 {
    public int[] solution(String[] words, String[] queries) {
        int[] answer = new int[queries.length];
        
        int i = 0;
        for(String query : queries) {
            int len = query.length();
            if(query.charAt(0)=='?' && query.charAt(len-1)=='?') { // "?????"
                for(String word : words) { // ���ڼ��� üũ
                    if(query.length()==word.length()) 
                        ++answer[i];
                }
                
            } else if (query.charAt(0)=='?') { // "???ab"
                int index = query.lastIndexOf("?")+1;
                String key = query.substring(index);
                for(String word : words) {                        
                    if(query.length()==word.length()) {
                        String hole = word.substring(index);
                        if(key.equals(hole))
                            ++answer[i];
                    }                             
                }
            } else {  // "ab???"
                int index = query.indexOf("?");
                String key = query.substring(0, index);
                for(String word : words) {                        
                    if(query.length()==word.length()) {
                        String hole = word.substring(0, index);
                        if(key.equals(hole))
                            ++answer[i];
                    }                             
                }
            }
            ++i;
        }
        return answer;
    }
}