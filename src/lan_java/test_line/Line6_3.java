package lan_java.test_line;

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
//        for(int i=0; i<answer.length; i++)
//        	System.out.println(answer[i]);               
	}
	static Node root;
    public static String[] solution(String[] directory, String[] command) {
    	List<String> arr = new ArrayList<>();
//    	for(String s : directory) arr.add(s);

    	// root��� ����
    	root = new Node("/");
    	for(String str : directory) {
    		root.mkdir(str);
    	}
    	
    	for(String com :command) {
    		String[] tempCom = com.split(" ");
    		if(tempCom[0].equals("mkdir")) {
    			root.mkdir(tempCom[1]);
    		} else if(tempCom[0].equals("rm")) {
    			root.rm(tempCom[1]);
    		} else if(tempCom[0].equals("cp")) {
    			root.cp(tempCom[1], tempCom[2]);
    		}
    	}	
    	

    	root.print(root);
    	
    	
        String[] answer = arr.toArray(new String[0]);
        Arrays.sort(answer);
        return answer;
    }
}

class Node{
	String dir;
	Map<String, Node> subs;
	
	public Node(String dir) {
		this.dir = dir;
		this.subs = new HashMap<>();
	}
	
	public void mkdir(String cmd) {
		if(cmd.equals("/")) return;
		String[] route = cmd.split("/");
		Node current = this;
		for(String folder : route) {
			if(folder.equals("")) continue;
			Node tempNode = current.subs.get(folder);
			
			if(tempNode==null) {
//				System.out.println("tempNode == null, current : "+current.dir+", mkdir : "+folder);
				Node newNode = new Node(folder);
				current.subs.put(folder, newNode);
				tempNode = newNode;
			}
			
			current = tempNode;
		}		
	}
	
	public void rm(String cmd) {
		String[] route = cmd.split("/");
		Node current = this;
		int i=1; // �Ʒ��Ʒ��ٿ� if(folder.equals("")) continue; ������ 1�� ���� 
		for(String folder : route) {
			if(folder.equals("")) continue;
			
			if(i==route.length-1) {
				current.subs.remove(folder);
			}
			else {
				Node temp = current.subs.get(folder);
				current = temp;
			}
			i++;
		}
		
	}
	
	public void cp(String cmdS, String cmdD) {
		String[] routeS = cmdS.split("/");
		String[] routeD = cmdD.split("/");
		
		Node source = this;
		int i=1;
		for(String folder : routeS) {
			if(folder.equals("")) continue;
			
			if(i==routeS.length-1) {
				return;
				
			} else {
				Node temp = source.subs.get(folder);
				source = temp;
			}
//			i++; �̰� ����� ���� �³�... ����?
		}
		
		Node destination = this;
		int j=1;
		for(String folder : routeD) {
			if(folder.equals("")) continue;
			
			if(j==routeD.length-1) {
				return;
			} else {
				Node temp = destination.subs.get(folder);
				destination = temp;
			}
//			j++; �̰� ����� ���� �³�... ����?
		}
		copy(source, destination);

	}
	
	public void copy(Node s, Node d) {
//		System.out.println(s.dir+", "+d.dir);
		d.subs.put(s.dir, new Node(s.dir));
		for(Node n : s.subs.values()) {
			copy(n, d.subs.get(s.dir));
		}
	}
	
	public void print(Node node) {
		System.out.println(Arrays.deepToString(al.toArray()));
		
		for(Node child : node.subs.values()) {
			al.add(child.dir);
			print(child);
			al.remove(child.dir);
		}
	}
	
	public static ArrayList<String> al = new ArrayList<>(); 
}
