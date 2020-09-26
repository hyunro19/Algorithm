package jv.pg.prbm_dp;

public class TileDecoration {

	public static void main(String[] args) {
		// �Ǻ���ġ ����������. �������.
		// ������ �� ���ǿ��� Caching����� �־���, dp����� �־��µ�
		System.out.println(solution(80));
	}
	
    public static long solution(int N) {
        // �� long����? �׷��� ���� ū��?
    	// int�� �������� ū ���� ����±���.
        long[] array = new long[N];
        int i=0;
        while(i<N) {
        	if(i==0 || i==1) array[i]=1;
        	else array[i]=array[i-1]+array[i-2];
        	++i;
        };
        return (4*array[N-1]+2*array[N-2]);
    }

}
