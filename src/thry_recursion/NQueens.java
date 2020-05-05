package thry_recursion;

public class NQueens {
	public static void main(String[] args) {
		int N = 4;
		int[] cols = new int [N+1];		
		queens(0, N, cols);
	}

	static boolean queens(int level, int N, int[] cols) {
		if (!promising(level, cols)) {
			return false;
		} else if (level==N) {
			for (int i=1; i<=N; i++)
				System.out.print(cols[i]+" ");
//				System.out.println("(" + i + ", " + cols[i] + ")");
			System.out.println("");
			return true;
		} else {
			for (int i=1; i<=N; i++) {
				cols[level+1] = i;
				queens(level+1, N, cols);
//				if (queens(level+1, N, cols)) 
//					return true; // 여기서 return을 시켜버리면, 1개 case만 찾고 끝남
			}
			return false;
		}
	}
	
	static boolean promising(int level, int[] cols) {		
		for(int i=1; i<level; i++) { // 같은 행/열에 없는지
			if(cols[i]==cols[level])
				return false;
			if(Math.abs(level-i)==Math.abs(cols[i]-cols[level]))
				return false;
		}
		return true;
	}
	
}


