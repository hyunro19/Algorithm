package lan_java.summer_winter_2019;

public class FineRectangular {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double a = 0.0;
		System.out.println(a==0);
	}
	
	// 데이터 타입 잘 챙겨야돼서 까다로웠던 문제
	// int도 overflow나서 연산 중에 long으로 바꿔줘야 되고
	// double도 부동소수점 오차 때문에 연산 순서 고려해줘야 했다.
    public static long solution(int w, int h) {
        long answer = 0;
        // 미리 inclination을 구하고 이걸 곱하면 부동소수점 오차때문에 틀릴 수도 있겠네
        // double inclination = (double)w/h; // w/h
        // 기존 (w/h)*i -> 변경 (w*i)/h
        
        for(int i=1; i<=h; i++) {
            double lineBottomLength = ((long)w*i)/(double)h;
            long mok = (long)lineBottomLength; // (w*i)/h를 1로 나눈 몫
            double namoji = lineBottomLength%1; // (w*i)/h를 1로 나눈 나머지
            
            
            int fineSquaresOnThisLine = w;
            fineSquaresOnThisLine -=mok;
            if(namoji!=0) fineSquaresOnThisLine-=1;            
            answer+=fineSquaresOnThisLine;
            // System.out.println("btmln:"+lineBottomLength+", mok:"+mok+", namoji:"+namoji+" sqr:"+fineSquaresOnThisLine);
        }
        answer*=2;
        return answer;
    }

}
