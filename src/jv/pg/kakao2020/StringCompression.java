package jv.pg.kakao2020;

public class StringCompression {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    public int solution(String s) {
        // 1부터 s.length()/2까지 잘라야겠네
        int answer = s.length();        
        for(int i=1; i<=s.length()/2; i++) {
            int temp = compress(s, i);
            if(temp<answer) answer=temp;
        }

        return answer;
    }
    
    public int compress(String s, int n) {
        StringBuilder sb = new StringBuilder();
        String tempSub = s.substring(0, n);
        int cnt = 1;
        int start = n;
        int end = n*2;

        // abcd abcd abcd efg
        while(start<s.length()) {
            if(end>s.length()) end = s.length();
            
            if( tempSub.equals(s.substring(start, end)) ) {
                ++cnt;
            } else {
                if(cnt!=1) sb.append(cnt);
                sb.append(tempSub);
                tempSub = s.substring(start, end);
                cnt = 1;
            }
            start+=n;
            end+=n;
        }

        if(cnt>1) sb.append(cnt);
        
        sb.append(tempSub);
        
        // System.out.println(sb.length()+" : "+sb.toString());
        return sb.length();
    }
    
}
