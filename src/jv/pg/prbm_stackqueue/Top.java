package jv.pg.prbm_stackqueue;

import java.util.Stack;

public class Top {

	public static void main(String[] args) {
		int[] heights = {3, 9, 9, 3, 5, 7, 2};
		for(int index : solution(heights)) {
			System.out.print(index+" ");
		}		
		
	}
    public static int[] solution(int[] heights) {
    	// ������ loop�� ����ǰڴµ�.. �̰� stack / queue�� ������?
    	int[] answer = new int[heights.length];
    	for(int i=heights.length-1; i>0; i--) {
    		int receiver = 0;
    		for(int j=i-1; j>=0; j--) {
    			if(heights[j]>heights[i]) {
    				answer[i]=j+1;
    				break; // break�����༭ ó���� Ʋ��. j+1�� index���� 0�� �ƴ� 1���� �����ؾ� ��.
    			}
    		}
    	}
        return answer;
    }
    
    // Stack�� ����� Ǯ��
    class Tower {
        int idx;
        int height;

        public Tower(int idx, int height) {
            this.idx = idx;
            this.height = height;
        }
    }

    public int[] solution2(int[] heights) {
        Stack<Tower> st = new Stack<>();
        int[] answer = new int[heights.length];

        // ���⼭�� loop�� ���������� ���°� Ư¡!
        for (int i = 0; i < heights.length; i++) {
            Tower tower = new Tower(i + 1, heights[i]);
            int receiveIdx = 0;

            while (!st.isEmpty()) {
                Tower top = st.peek();

                if (top.height > tower.height) {
                    receiveIdx = top.idx;
                    break;
                }

                st.pop();
            }

            st.push(tower);
            answer[i] = receiveIdx;
        }

        return answer;
    }
}
