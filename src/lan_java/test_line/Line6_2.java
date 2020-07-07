package lan_java.test_line;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Line6_2 {

	public static void main(String[] args) {
		String[] directory = {
							"/",
							"/hello",
							"/hello/tmp",
							"/root",
							"/root/abcd",
							"/root/abcd/etc",
							"/root/abcd/hello"
							};
		String[] command = {
							"mkdir /root/tmp",
							"cp /hello /root/tmp",
							"rm /hello"
							};
		
//		String[] directory = {"/"};
//		String[] command = {
//							"mkdir /a",
//							"mkdir /a/b",
//							"mkdir /a/b/c",
//							"cp /a/b /",
//							"rm /a/b/c"
//							};
		
		
        String[] answer = solution(directory, command);
        for(int i=0; i<answer.length; i++)
        	System.out.println(answer[i]);               
	}
	
    public static String[] solution(String[] directory, String[] command) {
    	List<String> arr = new ArrayList<>();
    	for(String s : directory) arr.add(s);
    	
    	for(String com :command) {
    		String[] tempCom = com.split(" ");
    		if(tempCom[0].equals("mkdir")) {
    			arr.add(tempCom[1]);
    			
    		} else if(tempCom[0].equals("rm")) {
    			List<String> tempArr = new ArrayList<>();
    			for(String s : arr)
    				if(s.startsWith(tempCom[1]))tempArr.add(s); 
    					
    			for(String s : tempArr)
    				arr.remove(s);
    			
    		} else if(tempCom[0].equals("cp")) {
    			List<String> tempArr = new ArrayList<>();
    			for(String str : arr)
    				if(str.startsWith(tempCom[1]))
    					tempArr.add(str);
    			
    			int index = tempCom[1].lastIndexOf("/");    			
    			for(String str : tempArr)
    				arr.add(tempCom[2].equals("/") ? str.substring(index) : tempCom[2]+str.substring(index));
    				  		
    		}
    	}
        
        String[] answer = arr.toArray(new String[0]);
        Arrays.sort(answer);
        return answer;
    }
}