package jv.pg.kakao2018;

import java.util.*;

public class Friends4Blocks {

	public static void main(String[] args) {
		String[] board = {"CCBDE", "AAADE", "AAABF", "CCBBF"};
		int m = board.length;
		int n = board[0].length();
		int ans = solution(m, n, board);
		System.out.println(ans);
//		System.out.println(null==null);

	}
	
    public static int solution(int m, int n, String[] board) {
        // m 행개 수, n 열 개수
        
        // 먼저 board를 이중배열로 바꾸자.
        Character[][] plate = new Character[m][n];
        
        for(int i=0; i<m; i++) {
        	for(int j=0; j<n; j++) {
        		plate[i][j] = board[i].charAt(j);
        	}
        }
//        print(plate);
        int cnt = 0;
        // 같은 크기의 이중배열을 선언하고, 어떤 블럭이 삭제 대상이 되는지 체크하자.
        // while문 안에서 queue size가 0이 될때까지 해야겠네
        Queue<int[]> q = new LinkedList<>();
        while(true) {        	
        	// 삭제 대상이 되는 블럭들을 Queue에 넣는다. 
            for(int i=0; i<m-1; i++) { // 왼쪽 위에서부터 4x4단위로
            	for(int j=0; j<n-1; j++) {        		
            		if(plate[i][j]!=null
        				&& plate[i][j]==plate[i][j+1]
        				&& plate[i][j]==plate[i+1][j]
    					&& plate[i][j]==plate[i+1][j+1]) {
            			int[] a = {i, j};
            			int[] b = {i+1, j};
            			int[] c = {i, j+1};
            			int[] d = {i+1, j+1};        			        			
            			q.add(a);
            			q.add(b);
            			q.add(c);
            			q.add(d);
            		}        		        		
            	}
            }
            // q에 더 이상 삭제할 블럭이 없으면
            if(q.size()<=0) {
            	break;
            	
            } else { // q.size()>0
                // Queue에서 하나씩 빼면서 블럭을 삭제한다 -> null로 바꾼다. 
                while(q.size()>0) {
                	int[] toDelete = q.poll();
                	// 중복으로 2x2에 들어가기 때문에 nullpointer체크
                	if(plate[toDelete[0]][toDelete[1]]!=null) {
                		plate[toDelete[0]][toDelete[1]] = null;
                		++cnt;
                	}
                }
            }

            // 이중 배열에서 아래에서부터 위로 올라가면서 블럭을 하나씩 내려온다.
            for(int i=m-1; i>0; i--) { // 맨 윗줄은 볼 필요 없음
            	for(int j=0; j<n; j++) { 
            		if(plate[i][j]==null) { // 2, 0
            			// 위에 몇 개가 또 null인지 체크하기
            			int upperNulls = 0;
            			for(int k=i; k>=0; k--) { // k=1 ~ 0까지
            				if(plate[k][j]==null) {
            					++upperNulls;
            				} else {
            					break;
            				}
            			}            			            	
            			// 맞바꾸기
            			if(i-upperNulls>=0 && upperNulls>0) {
            				plate[i][j]=plate[i-upperNulls][j];
            				plate[i-upperNulls][j] = null;            				
            			}
            		}
            	}
            }    
        }
               
        return cnt;
    }

    public static void print(Character[][] plate) {
    	int m = plate.length;
    	int n = plate[0].length;
        for(int i=0; i<m; i++) { // 왼쪽 위에서부터 4x4단위로
        	for(int j=0; j<n; j++) { 
        		System.out.print(plate[i][j]+" ");
        	}
        	System.out.println("");
        }
    }
}

