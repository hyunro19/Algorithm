package codingTest;

import java.util.ArrayList;
import java.util.Arrays;

public class Line6 {

	public static void main(String[] args) {
        String[] answer = {};
        String[] temp = {"/", "a"};
        Arrays.sort(temp);
        answer = temp;
        for(int i=0; i<2; i++)
        	System.out.println(answer[i]);
	}

}


class Solution6 {
    public String[] solution(String[] directory, String[] command) {
    	ArrayList<String> tempArray = new ArrayList<String>(directory.length);
    	for(int i=0; i<directory.length; i++) {
    		tempArray.add(directory[i]);
    	}
    	
        for(int i=0; i<command.length; i++) {
        	String[] tempCommand = command[i].split(" ");
        	if(tempCommand[0].equals("mkdir")) {
        		tempArray.add(tempCommand[1]);
        	} else if(tempCommand[0].equals("rm")) {
        		tempArray.remove(tempArray.indexOf(tempCommand[1]));
        	} 
        	else if(tempCommand[0].equals("cp")) {
        		int tempArraySize = tempArray.size();
        		
        		for(int j=0; j<tempArraySize; j++) {
    				String[] temp = tempCommand[1].split("/");
    				String lastDir = temp[temp.length-1];
    				
        			if(tempArray.get(j).startsWith(tempCommand[1])) {
        				if(tempArray.get(j).length()<=tempCommand[1].length()) {
        					if(tempCommand[2].equals("/")) {
        						tempArray.add(tempCommand[2]+lastDir);
        					} else {
        						tempArray.add(tempCommand[2]+"/"+lastDir);
        					}        					
        				} else {
        					if(tempCommand[2].equals("/")) {
        						tempArray.add(tempCommand[2]+lastDir+tempArray.get(i).substring(tempCommand[1].length()));
        					} else {
        						tempArray.add(tempCommand[2]+"/"+lastDir+tempArray.get(i).substring(tempCommand[1].length()));
        					}
        				}		
        			}
        		}
        	}
        }
        
        String[] answer = new String[tempArray.size()];
        for(int i=0; i<answer.length; i++) {
        	answer[i]=tempArray.get(i);
        }
        Arrays.sort(answer);
        return answer;
    }
}