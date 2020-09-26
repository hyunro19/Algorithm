package jv.pg.kakao2019;

import java.util.*;

public class FineRouteOnBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    static int postIdx = 0;
public int[][] solution(int[][] nodeinfo) {
        int N = nodeinfo.length;
        Node[] nodeArr = new Node[N];
        for(int i=0; i<N; i++) {
            nodeArr[i] = new Node(i+1, nodeinfo[i][0], nodeinfo[i][1]);
        }
		
		// 정렬을 먼저 시켜야겠다.
		Arrays.sort(nodeArr, new Comparator<Node>(){

			@Override
			public int compare(Node o1, Node o2) {
				// y좌표 내림차순 -> x좌표 오름차순
				if(o1.y==o2.y) {
					return o1.x-o2.x;
				} else {
					return o2.y-o1.y;	
				}				
			}
			
		});
		
		// root 설정
		Node root = nodeArr[0];
		// for(int i=0; i<N; i++) System.out.print(nodeArr[i].num+", ");
		// System.out.println("");
		
        for(int i=1; i<nodeArr.length; i++) {
        	Node node = nodeArr[i];
        	Node current = root;        	

        	while(true) {
        		if(node.x<current.x) { // 왼쪽
        			if(current.left==null) {
        				current.left= node;
        				break;
        			} else {
        				current = current.left;
        			}
        			
        		} else { // 오른쪽
        			if(current.right==null) {
        				current.right= node;
        				break;
        			} else {
        				current = current.right;
        			}        			    		
        		}
        	}        
        }
        // 전위순회하기
        int[] preOrder = new int[N];
        int preIdx = 0;
        Node pre = root;
        Stack<Node> preStack = new Stack<>();
        while(preIdx<N) {        	
        	preOrder[preIdx++] = pre.num;
        	if(pre.right!=null) {
        		preStack.push(pre.right);
        	}        	
        	if(pre.left!=null) {
        		pre = pre.left;
        	} else { // pre.left==null
        		if(!preStack.isEmpty()) {
        			pre = preStack.pop();
        		}
        	}
        }
        
        
        
        // 후위순회하기
        int[] postOrder = new int[N];        
        Node post = root;
        postIdx = 0;
        postOrder(root, postOrder);                    
        
        int[][] answer = new int[2][N];
        answer[0] = preOrder;
        answer[1] = postOrder;
        // for(int a : preOrder) System.out.print(a+" ");
        // System.out.println("");
        // for(int a : postOrder) System.out.print(a+" ");
        // System.out.println("");
        return answer;
    }
	
    public void postOrder(Node node, int[] arr) {
        if(node.left!=null) postOrder(node.left, arr); 
        if(node.right!=null) postOrder(node.right, arr);
        arr[postIdx++] = node.num;
    }

}


class Node {
    int num;
    int x;
    int y;
    Node left = null;
    Node right = null;
    Node(int num, int x, int y) {
        this.num = num;
        this.x = x;
        this.y = y;
    }
}