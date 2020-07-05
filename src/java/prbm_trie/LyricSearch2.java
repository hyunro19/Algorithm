package prbm_trie;

import java.util.Arrays;
public class LyricSearch2 {
	public static void main(String[] args) {
		String[] words = { "a","b","frodo", "front", "frost", "frozen", "kakao", "frame" };
		String[] queries = { "?","fro??", "????o", "fr???", "fro???", "pro??", "??ont", "????o" };
		
		int[] answer = new int[queries.length];
		
		// 접미사(subffix)용 트라이 구조
		Trie[] tries = new Trie[10001]; // 한 단어의 길이가 10000을 넘지 않으므로, 10001로 만듬
		// 접두사(prefix)용 트라이 구조
		Trie[] rtries = new Trie[10001];
		
		// words 길이 별 분류
		for(String word : words) {
			int size = word.length();
			// 길이에 해당하는 트라이 만들기
			try {
				tries[size].insert(word.toCharArray());
			}catch(Exception e) { // if로 분기처리를 안하고 예외로 잡았네...
				tries[size] = new Trie();
				tries[size].insert(word.toCharArray());
			}
			
			// 반대 문자도 트라이 생성
			word = (new StringBuffer(word)).reverse().toString();
			try {
				rtries[size].insert(word.toCharArray());
			}catch(Exception e) {
				rtries[size] = new Trie();
				rtries[size].insert(word.toCharArray());
			}
		}
		
		// trie 이용하여 해당 쿼리에 맞는 갯수들 찾기
		for(int i=0; i<queries.length; ++i) {
			String query = queries[i];
			if(query.indexOf('?')==0) {
				// prefix
				try {
					query = (new StringBuffer(query)).reverse().toString();
					answer[i] = rtries[query.length()].search(query.toCharArray());
				}
				catch(Exception e) {
					continue;
				}
				
				
			} else {
				// suffix
				try {
					answer[i] = tries[query.length()].search(query.toCharArray());
				}
				catch(Exception e) {
					continue;
				}
				
				
			}
		}
		
		System.out.println(Arrays.toString(answer));

	}

}

// Trie Node
class Trie {

	int count;
	Trie[] childList;

	Trie() {
		childList = new Trie[26]; // 알파벳은 26자
		count = 0;
	}

	void insert(char[] word) {
		Trie current = this;
		for (char no : word) {
			++current.count; // 해당 노드를 거치는 단어가 몇 개 있는지를 체크
			if (current.childList[no - 'a'] != null) {
				current = current.childList[no - 'a']; // child로 depth를 한 단계 내려간다.
			} else {
				current.childList[no - 'a'] = new Trie();
				current = current.childList[no - 'a']; // child로 depth를 한 단계 내려간다.
			}
		}
	}

	int search(char[] query) {
		Trie current = this;
		for (char no : query) {
			if (no == '?')
				return current.count; // 재귀의 basecase같은 역할, 첫'?' 이하는 탐색하지 않는다.

			if (current.childList[no - 'a'] != null) 
				current = current.childList[no - 'a'];  // child로 depth를 한 단계 내려간다.
			else // 아무 단어도 매칭이 안될 때 (해당 abc???에서 ab를 지나 내려왔지만, 3번째 char가 d, e, f등만 있고 c가 없을 경우
				return 0;
		}
		
		return current.count;
	}

}