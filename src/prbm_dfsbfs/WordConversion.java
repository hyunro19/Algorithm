package prbm_dfsbfs;

public class WordConversion {
	
	public static void main(String[] args) {
//		String begin = "hit";
//		String target = "cog";
//		String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
		
		String begin = "hit";
		String target = "cog";
		String[] words = {"hot", "dot", "dog", "lot", "log"};
		
		System.out.println(solution(begin, target, words));
	}
	
    public static int solution(String begin, String target, String[] words) {
        int stringLength = begin.length();
        int arrayLength = words.length;
        boolean[] isUsed = new boolean[words.length];
        int answer = convert(begin, target, words, isUsed, 0, stringLength, arrayLength);
        
        // loop�� ���鼭 char�� �ϳ��� �ٸ��� �ϴ� �·� �ٲٰ�
        // method boolean isConversible(String bf, String af, int length); 1���ڸ� ���̳��� O �ƴϸ� X
        // method boolean isTarget(String rst, String tgt, int length); return cnt;
        // boolean[] isUsed = boolean[woords.length]; �̹� �������� loop���� pass;
        // ��ȯ�Ұ��ϸ� return 51�� �ϰ�
        // 
        if(answer<=arrayLength) return answer;
        else return 0;
    }
    
    public static int convert(String before, String target, String[] words, boolean[] isUsed, int depth, int stringLength, int arrayLength) {
    	System.out.println("before : "+before+", target : "+target+", depth : "+depth);
		if(isTarget(before, target, stringLength)) {
			System.out.println("isTarget : "+before+" "+target);
			return depth;
		}
    	if(depth>words.length) {
			System.out.println("depth==length : "+before+" "+target);
    		return words.length;
    	}
    	int min=arrayLength+1;
    	for(int i=0; i<words.length; i++) {
    		if(isUsed[i]==false && isConversible(before, words[i], stringLength)) {
    			isUsed[i]=true;
    			int ret = convert(words[i], target, words, isUsed, depth+1, stringLength, arrayLength);
    			isUsed[i]=false;
    			if(ret<min) min=ret;
    		}
    	}    	   
    	return min;
    }
    
    public static boolean isConversible(String bf, String af, int length) {
    	int j = 0;
    	for(int i=0; i<length; i++) {
    		if(bf.charAt(i)!=af.charAt(i))
    			if(++j>1) return false;
    	}
    	return true;
    }
    
    public static boolean isTarget(String rst, String tgt, int length) {
    	int j = 0;
    	for(int i=0; i<length; i++) {
    		if(rst.charAt(i)!=tgt.charAt(i))
    			if(++j>0) return false;
    	}
    	return true;
    }
    
    

}
