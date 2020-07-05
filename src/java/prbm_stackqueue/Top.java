package prbm_stackqueue;

import java.util.Stack;

public class Top {

	public static void main(String[] args) {
		int[] heights = {3, 9, 9, 3, 5, 7, 2};
		for(int index : solution(heights)) {
			System.out.print(index+" ");
		}		
		
	}
    public static int[] solution(int[] heights) {
    	// 역으로 loop를 돌면되겠는데.. 이게 stack / queue인 이유는?
    	int[] answer = new int[heights.length];
    	for(int i=heights.length-1; i>0; i--) {
    		int receiver = 0;
    		for(int j=i-1; j>=0; j--) {
    			if(heights[j]>heights[i]) {
    				answer[i]=j+1;
    				break; // break안해줘서 처음에 틀림. j+1도 index값이 0이 아닌 1부터 시작해야 함.
    			}
    		}
    	}
        return answer;
    }
    
    // Stack을 사용한 풀이
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

        // 여기서는 loop를 정방향으로 도는게 특징!
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
