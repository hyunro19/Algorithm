package lan_java.test_prgrmrs_chlng_200418;


public class Algorithm1 {

	public static void main(String[] args) {
			String p = "82195";
			String s = "64723";
			
//			String p = "00000000000000000000";
//			String s = "91919191919191919191";
			System.out.println(solution(p, s));

	}

	public static int solution(String p, String s) {
		int len = p.length();
		int cnt = 0;
		for(int i=0; i<len; i++)
			cnt += min(p.charAt(i), s.charAt(i));
		return cnt;
	}
	
	public static int min(char a, char b) {
		if(a==b) return 0;		
		int min = Math.min(a, b);
		int max = Math.max(a, b);
		return Math.min(max-min, 10+min-max);
	}
}
