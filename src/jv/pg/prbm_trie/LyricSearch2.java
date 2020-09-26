package jv.pg.prbm_trie;

import java.util.Arrays;
public class LyricSearch2 {
	public static void main(String[] args) {
		String[] words = { "a","b","frodo", "front", "frost", "frozen", "kakao", "frame" };
		String[] queries = { "?","fro??", "????o", "fr???", "fro???", "pro??", "??ont", "????o" };
		
		int[] answer = new int[queries.length];
		
		// ���̻�(subffix)�� Ʈ���� ����
		Trie[] tries = new Trie[10001]; // �� �ܾ��� ���̰� 10000�� ���� �����Ƿ�, 10001�� ����
		// ���λ�(prefix)�� Ʈ���� ����
		Trie[] rtries = new Trie[10001];
		
		// words ���� �� �з�
		for(String word : words) {
			int size = word.length();
			// ���̿� �ش��ϴ� Ʈ���� �����
			try {
				tries[size].insert(word.toCharArray());
			}catch(Exception e) { // if�� �б�ó���� ���ϰ� ���ܷ� ��ҳ�...
				tries[size] = new Trie();
				tries[size].insert(word.toCharArray());
			}
			
			// �ݴ� ���ڵ� Ʈ���� ����
			word = (new StringBuffer(word)).reverse().toString();
			try {
				rtries[size].insert(word.toCharArray());
			}catch(Exception e) {
				rtries[size] = new Trie();
				rtries[size].insert(word.toCharArray());
			}
		}
		
		// trie �̿��Ͽ� �ش� ������ �´� ������ ã��
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
		childList = new Trie[26]; // ���ĺ��� 26��
		count = 0;
	}

	void insert(char[] word) {
		Trie current = this;
		for (char no : word) {
			++current.count; // �ش� ��带 ��ġ�� �ܾ �� �� �ִ����� üũ
			if (current.childList[no - 'a'] != null) {
				current = current.childList[no - 'a']; // child�� depth�� �� �ܰ� ��������.
			} else {
				current.childList[no - 'a'] = new Trie();
				current = current.childList[no - 'a']; // child�� depth�� �� �ܰ� ��������.
			}
		}
	}

	int search(char[] query) {
		Trie current = this;
		for (char no : query) {
			if (no == '?')
				return current.count; // ����� basecase���� ����, ù'?' ���ϴ� Ž������ �ʴ´�.

			if (current.childList[no - 'a'] != null) 
				current = current.childList[no - 'a'];  // child�� depth�� �� �ܰ� ��������.
			else // �ƹ� �ܾ ��Ī�� �ȵ� �� (�ش� abc???���� ab�� ���� ����������, 3��° char�� d, e, f� �ְ� c�� ���� ���
				return 0;
		}
		
		return current.count;
	}

}