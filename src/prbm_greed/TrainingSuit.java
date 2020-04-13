package prbm_greed;

public class TrainingSuit {

	public static void main(String[] args) {

	}
	
    public int solution(int n, int[] lost, int[] reserve) {
        int[] array = new int[n];
        for(int i : lost) array[i-1]--;
        for(int i : reserve) array[i-1]++;
        for(int i=0; i<array.length; i++) {
        	if(array[i]==1) {
        		// index 0ÀÏ ¶§
        		if(i==0) {
        			if(array[i+1]==-1) {
        				array[i]--;
						array[i+1]++;
        			}
        		} else if (i>0 && i<array.length-1) {
        			if(array[i-1]==-1) {
        				array[i]--;
						array[i-1]++;
        			} else if (array[i+1]==-1) {
        				array[i]--;
						array[i+1]++;        				
        			}        			
        		} else if (i==array.length-1) {
        			if(array[i-1]==-1) {
        				array[i]--;
						array[i-1]++;
        			}
        		}
        	}
        }
        int cnt=0;
        for(int i : array) {
        	if(i>-1) ++cnt;
        }
        return cnt;
    }
}
