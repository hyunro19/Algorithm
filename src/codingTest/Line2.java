package codingTest;

public class Line2 {

	public static void main(String[] args) {


	}

}


class Solution2 {
    public int solution(String answer_sheet, String[] sheets) {
    	int max=0;
        int answer = -1;
        
        for(int i=0; i<sheets.length; i++) {
        	for(int j=i+1; j<sheets.length; j++) {
        		int suspicious=0;
        		int continuousMax=1;
        		int continuousNow=0;
        		int[] tempSheet = new int[answer_sheet.length()];
        		for(int k=0; k<answer_sheet.length(); k++) {
        			if(sheets[i].charAt(k)==sheets[j].charAt(k) && sheets[i].charAt(k)!=answer_sheet.charAt(k) ) {
        				// when suspicious
        				++suspicious;
        				tempSheet[k]=1;
        			} else {
        				// not suspicious
        				tempSheet[k]=0;
        			}
        			
                    if(k==0 && tempSheet[k]==1) {
                        continuousNow=1;
                    }
        			if(k>0) {
        				if(tempSheet[k]==tempSheet[k-1]) {
        					if(tempSheet[k]==1) ++continuousNow;
            			} else if(tempSheet[k]!=tempSheet[k-1]){
            				if(tempSheet[k]==0) {
            					if(continuousNow>continuousMax) continuousMax=continuousNow;
            					continuousNow=0;
            				} else if(tempSheet[k]==1) {
            					continuousNow=1;
            				}
            			}
        			}			
        		}
        		int tempIndex = suspicious+continuousMax*continuousMax;
                System.out.println("temp"+tempIndex);
        		if(tempIndex>max) max=tempIndex;
        	}        	
        }
        answer=max;
        
        return answer;
    }
}