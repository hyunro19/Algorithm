package test_line;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Line6_3 {

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
    	
    	Node root = new Node("/");
    	Node current = root;
    	for(String dir : directory) {
    		String[] folders = dir.split("/");
    		for(String folder : folders) {
    			if(!current.submap.keySet().contains(folder)) // 없으면 추가 
    				current.submap.put(folder, new Node(folder));

    			current = current.submap.get(folder); // 있으면 뱉기
    		}
    	}
    	// 여기까지 Trie로 만들기
    	
    	for(String com :command) {
    		String[] tempCom = com.split(" ");
    		if(tempCom[0].equals("mkdir")) {
    			String[] tempDir = tempCom[1].split("/");
    			current = root;
    			for(String folder : tempDir) {
    				Node tempNode = current.submap.get(folder);
    				if(tempNode != null) current = tempNode;
    				else current.submap.put(folder, tempNode);
    			}
    			
    		} else if(tempCom[0].equals("rm")) {
    			String[] tempDir = tempCom[1].split("/");
    			for(int i=0; i<tempDir.length; i++) {
    				if(i==tempDir.length-1) {
    					current.submap.remove(tempDir[i]);
    					break;
    				} else {
        				Node tempNode = current.submap.get(tempDir[i]);
        				if(tempNode != null) current = tempNode;
        				else current.submap.put(tempDir[i], tempNode);    					
    				}
    			}
    			
    			
    		} else if(tempCom[0].equals("cp")) {
    			// 후...
    			// 트라이로 푸는 문제가 아닌 것 같은데???
    			
    			
    			
    		}
    
    		
    		
        String[] answer = arr.toArray(new String[0]);
        Arrays.sort(answer);
        return answer;
    }
}

class Node{
	String dir;
	ArrayList<Node> subs;
	Map<String, Node> submap;
	
	public Node(String dir) {
		this.dir = dir;
		this.submap = new HashMap<>();
		
	}
}