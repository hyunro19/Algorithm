package lan_java.prbm_bisection;


public class Immigration {
    public long solution(int n, int[] times) {
        int biggest = times[0];
        for (int i = 1; i < times.length; i++) {
            biggest = Math.max(biggest, times[i]);
        }

        long l = 0;
        //최대한의 경우 1명당 smallestTime * n분 걸림
        long r = (long)biggest * (long)n;

        while (l < r) {
            long mid = (r - l)/ 2 + l;
            long numP = numProcessed(mid, times);
            if (numP >= n) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }

        return l;
    }


    long numProcessed(long mid, int[] times) {
        long numP = 0;
        for (int i = 0; i<times.length; i++) {
            numP += mid / times[i];
        }
        return numP;
    }
}