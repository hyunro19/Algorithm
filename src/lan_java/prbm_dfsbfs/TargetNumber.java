package lan_java.prbm_dfsbfs;

public class TargetNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public int solution(int[] numbers, int target) {
        return targetNumber(numbers, 0, 0, numbers.length, target);
    }
    
    public int targetNumber(int[] numbers, int cnt, int depth, int n, int target) {
        if(depth==n) {
            if(cnt==target) return 1;
            else return 0;
        } 
        return targetNumber(numbers, cnt+numbers[depth], depth+1, n, target)
        +targetNumber(numbers, cnt-numbers[depth], depth+1, n, target);        
    }

}