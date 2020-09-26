package jv.pg.kakao2020;

public class LockAndKey {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    public boolean solution(int[][] key, int[][] lock) {
        // lock이 이미 다 1일 때 // 해당되는TEST CASE 없음
        // boolean allOne = true;
        // for(int i=0; i<lock.length; i++) {
        //     for(int j=0; j<lock.length; j++) {
        //         if(lock[i][j]!=1) allOne = false;
        //     }
        // }
        // if(allOne) return true;
        
        // M은 항상 N이하라는 조건이 있다.
        
        if(lookThrough(key, lock)) return true;        
        
        int[][] rotatedOne = rotateClockwise(key);
        if(lookThrough(rotatedOne, lock)) return true;        
        
        int[][] rotatedTwo = rotateClockwise(rotatedOne);
        if(lookThrough(rotatedTwo, lock)) return true;        
        
        int[][] rotatedThree = rotateClockwise(rotatedTwo);
        if(lookThrough(rotatedThree, lock)) return true;     
        
        return false;
    }
    
    public boolean lookThrough(int[][] key, int[][] lock) {
        int N = lock.length;
        int M = key.length;
        
        for(int i=N-1; i>=1-M; i--) { // 여기서 "N-1" ~ "1-M"까지 이다. 범위 중요
            for(int j=N-1; j>=1-M; j--) {
                if(ifFits(i, j, lock, key))
                    return true;                                                                         
            }
        }
        return false;
    }
    public boolean ifFits(int i, int j, int[][] lock, int[][] key) {
        int N = lock.length;
        int M = key.length;

        // insert
        int A = Math.min(N, i+M);
        int B = Math.min(N, j+M);
        for(int a=0; a<=N-1; a++) { // 여기 a<=N-1에서 등호를 빠뜨렸다. CASE 1, 29에 해당
            for(int b=0; b<=N-1; b++) {
                if(a>=i && a<A && b>=j && b<B) { // 겹쳐지는 부분
                    if(lock[a][b]+key[a-i][b-j] != 1) return false;
                } else { // 안겹쳐지는 부분
                    if(lock[a][b] != 1) return false;
                }                                
            }
        }      

        return true;
    }
    
    public int[][] rotateClockwise(int[][] key) {
        int M = key.length;
        int[][] rotated = new int[M][M];
        for(int i=0; i<M; i++) {
            for(int j=0; j<M; j++) {
                rotated[j][M-1-i] = key[i][j];
            }
        }
        return rotated;        
    }
    
    // public void printKey(int[][] key) {
    //     for(int i=0; i<key.length; i++) {
    //         for(int j=0; j<key.length; j++) {
    //             System.out.print(key[i][j]+" ");
    //         }
    //         System.out.println("");
    //     }
    // }
}
