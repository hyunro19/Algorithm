package lan_java.test_line;

public class Line5 {

	public static void main(String[] args) {


	}

}

class Solution5 {
    public String[] solution(String[][] dataSource, String[] tags) {
    	tagDoc[] tagDocArray = new tagDoc[dataSource.length];
    	for(int i=0; i<dataSource.length; i++) {
    		tagDocArray[i]=new tagDoc();;
    		tagDocArray[i].name=dataSource[i][0];
    		for(int j=1; j<dataSource[i].length; j++) {
    			for(int k=0; k<tags.length; k++) {
    				if(dataSource[i][j].equals(tags[k])) tagDocArray[i].tagNum++;
    			}
    		}
    		
    	}
    	

    	
        String[] answer = {};
        return answer;
    }
}

class tagDoc {
	String name;
	int tagNum=0;
}