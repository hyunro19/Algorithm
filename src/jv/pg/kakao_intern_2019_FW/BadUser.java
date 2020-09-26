package jv.pg.kakao_intern_2019_FW;

import java.util.*;

public class BadUser {
	static int U = 0;
	static int B = 0;
	static String[] users;
	static String[] banns;
	static Set<String> set;
	public static void main(String[] args) {
		String[] user_id = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
		String[] banned_id = {"fr*d*", "abc1**"};
		
		int ans = solution(user_id, banned_id);
		System.out.println("ans : "+ans);	
	}

    public static int solution(String[] user_id, String[] banned_id) {
    	set = new HashSet<>();
    	users = user_id;
    	banns = banned_id;
    	U = user_id.length;
    	B = banned_id.length;
    	boolean[] userUsed = new boolean[U];
        dfs(userUsed, 0);
        return set.size();
    }
    
    public static void dfs(boolean[] userUsed, int banIdx) {
    	if(banIdx>=B) { // 모두다 사용한 경우
    		// userUsed 중에 사용된 것만 뽑아서 String으로 붙여서 Set에 넣기
    		StringBuilder sb = new StringBuilder();
    		for(int i=0; i<U; i++) {
    			if(userUsed[i]) sb.append(users[i]).append("_");
    		}
    		String comb = sb.toString();
//    		System.out.println(comb);
    		set.add(comb);
    		return;
    	}

    	for(int i=0; i<U; i++) {
    		// 이미 사용됐으면 제외
    		if(userUsed[i]) continue;
    		
    		// 사용 안됐으면
    		// 이번 꺼랑 맞는지 체크
    		if(ifMatch(users[i], banns[banIdx])) {
    			userUsed[i] = true;    		
    			dfs(userUsed, banIdx+1);
    			userUsed[i] = false;    			
    		};    		
    	}    	    
    }
    
    public static boolean ifMatch(String user, String ban) {
    	int userLen = user.length();
    	int banLen = ban.length();
    	if(userLen!=banLen) return false;
    	
    	for(int i=0; i<userLen; i++) {
    		char b = ban.charAt(i);
    		if(b=='*') {
    			continue;
    		} else {
    			char u = user.charAt(i);
    			if (b!=u) return false;
    		}
    	}    	    	
    	return true;
    }
}
