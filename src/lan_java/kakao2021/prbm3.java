package lan_java.kakao2021;
import java.util.*;

public class prbm3 {

	public static void main(String[] args) {
		String[] info = {"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"};
		String[] query = {"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"};
		int[] ans = solution(info, query);
		for(int i : ans) {
			System.out.print(i+" ");
		}
	}
	
    public static int[] solution(String[] info, String[] query) {    	
    	String[] lan = {"java", "python", "cpp", "-"};
    	String[] end = {"backend", "frontend", "-"};
    	String[] car = {"junior", "senior", "-"};
    	String[] sf = {"pizza", "chicken", "-"};
    	Map<String, ArrayList<Integer>> map = new HashMap<>();
    	// 조건 다 만듬, Strig -> Ar 매핑되도록
    	
    	dfs(lan, end, car, sf, map, 0, "");

    	for(String apct : info) {
    		String[] con = apct.split(" ");
    		comb(con, 0, "", map);    		
    	}    	
    	
        int[] answer = new int[query.length];
        for(int i=0; i<query.length; i++) {
        	String[] cond = query[i].split(" ");
        	String q = cond[0]+cond[2]+cond[4]+cond[6];
        	ArrayList<Integer> arr = map.get(q);
        	int cnt = 0;
        	for(int a : arr) {
        		if(a>=Integer.parseInt(cond[7])) ++cnt;
        	}
        	answer[i]=cnt;
        }        
        return answer;
    }
    
    public static void dfs(String[] lan, String[] end, String[] car, String[] sf, Map<String, ArrayList<Integer>> map, int idx, String str) {
    	if(idx==4) {
    		map.put(str, new ArrayList<Integer>());
    		return;
    	}
    	String[] options = null;
    	if(idx==0) options = lan;
    	else if(idx==1) options = end;
    	else if(idx==2) options = car;
    	else if(idx==3) options = sf;
    	
    	for(int i=0; i<options.length; i++) {
    		dfs(lan, end, car, sf, map, idx+1, str+options[i]);
    	}    	
    }
    public static void comb(String[] con, int idx, String str, Map<String, ArrayList<Integer>> map) {
//    	System.out.println(str);
    	if(idx==4) {
    		ArrayList<Integer> arr = map.get(str);
    		map.get(str).add(Integer.parseInt(con[idx]));
    		return;
    	}
    	comb(con, idx+1, str+con[idx], map);
    	comb(con, idx+1, str+"-", map);    	    	
    }

}
