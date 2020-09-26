package jv.pg.prbm_bruteforce;

public class Carpet {

	public static void main(String[] args) {
		int brown = 10;
		int red =2;
		
		for(int i: solution(brown, red)) {
			System.out.print(i+" ");
		}
	}

    public static int[] solution(int brown, int red) {
    	
    	for(int height=2; height<brown/2; height++) {
    		int width = (brown-2*(height-2))/2;
    		if( (height-2)*(width-2) == red) return new int[]{width,height};
    	}
        int[] answer = {};
        return answer;
    }
}
