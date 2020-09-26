package jv.pg.kakao2018;

public class SecretMap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(decToBin(5, 28));
	}
	
    public static String[] solution(int n, int[] arr1, int[] arr2) {
    	// 1. 숫자가 주어졌을 때, 0101로 된 이진수로 만드는 함수 만들기
    	// String decToBin(int n, int num);
    	
    	// 정답용 배열 선언
    	String[] answer = new String[n];
    	// 2. loop를 돌면서
    	// 각 단계마다 자릿수를 비교,둘 다 빈칸이면 " ", 아니면 "#'으로 string builder.
    	for(int i=0; i<n; i++) {
    		String map1 = decToBin(n, arr1[i]);
    		String map2 = decToBin(n, arr2[i]);
    		StringBuilder sb = new StringBuilder();
    		for(int j=0; j<n; j++) {
    			if(map1.charAt(j)=='0' && map2.charAt(j)=='0') sb.append(" ");
    			else sb.append("#");
    		}
    		answer[i] = sb.toString();
    	}
    	
        return answer;
    }
    
    public static String decToBin(int n, int num) {
    	StringBuilder sb = new StringBuilder();
    	int mok = num;
    	for(int i=0; i<n; i++) {
    		int namoji = mok%2;
    		mok = mok/2;
    		sb.append(namoji);
    	}
    	return sb.reverse().toString();
    }

}
