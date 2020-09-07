package lan_java.kakao2019;

import java.util.*;
public class OpenChatting {

	public static void main(String[] args) {

	}
	
    public String[] solution(String[] record) {
        // id는 해싱해서 사용하고
        // msg는 uid값과 enter/leave를 순서대로 나열해두었다가 String을 만들면 될듯
        String[][] msgs = new String[record.length][2]; // [[ uid, enter ], [uid2, enter] 
        Map<String, String> map = new HashMap<>();
        
        int idx = 0;
        for(String rcd : record) {
            String[] words = rcd.split(" ");
            
            // 1. uid-nck 매핑 최신화
            // 2. msgs 추가
            if(words[0].equals("Enter")) {
                map.put(words[1], words[2]);
                msgs[idx][0]=words[1];
                msgs[idx][1]="E";
                ++idx;
            } else if(words[0].equals("Leave")) {
                msgs[idx][0]=words[1];
                msgs[idx][1]="L";
                ++idx;
            } else { // cmd.equals("Change")
                map.put(words[1], words[2]);                
            }
        }
        
        // 결과값 출력                
        String[] answer = new String[idx];
        for(int j=0; j<idx; j++) {
            if(msgs[j][1].equals("E")) {
                answer[j] = map.get(msgs[j][0])+"님이 들어왔습니다.";
            } else { // if(msgs[j][1].equals("L"))
                answer[j] = map.get(msgs[j][0])+"님이 나갔습니다.";
            } 
        }
        
        return answer;
    }
       
}