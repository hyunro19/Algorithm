package jv.pg.prbm_sort;

import java.util.Arrays;

class KthNumber {
	public static void main(String[] args) {
		
	}
	
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for(int i=0; i<commands.length; i++) {
            int[] command = commands[i];
            int[] tempArray = Arrays.copyOfRange(array, command[0]-1, command[1]);
            Arrays.sort(tempArray);
            answer[i]=tempArray[command[2]-1];
        }        

        return answer;
    }
}