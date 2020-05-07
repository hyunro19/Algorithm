package prbm_trie;
// https://programmers.co.kr/learn/courses/30/lessons/60060



public class LyricSearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

// Trie로 풀기
class Solution2 {
    public int[] solution(String[] words, String[] queries) {
    	
    	
    	
    	return new int[3];
    }
}




// Parsing을 이용한 풀이
// 시간복잡도 m*n으로 통과X
class Solution1 {
    public int[] solution(String[] words, String[] queries) {
        int[] answer = new int[queries.length];
        
        int i = 0;
        for(String query : queries) {
            int len = query.length();
            if(query.charAt(0)=='?' && query.charAt(len-1)=='?') { // "?????"
                for(String word : words) { // 글자수만 체크
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