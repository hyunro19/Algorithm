package prgrmrs_chlng_200418;

public class Algorithm2 {
	static int[][] status = { {-1, 0}, //북 0
							  {0, +1}, //동 1
							  {+1, 0}, //남 2
							  {0, -1} }; //서 3
	static int[] robot = {0, 0, 0}; // r, c, status
	static int N = 0;
	static int dust = 0;
	static int[][] off;
	public static void main(String[] args) {
		int[][] office = {{5,-1,4},{6,3,-1},{2,-1,1}};
		int r=1;
		int c=0;
		String[] move = {"go","go","right","go","right","go","left","go"};
		System.out.println(solution(office, r, c, move));

	}
	
	  public static int solution(int[][] office, int r, int c, String[] move) {
		  off = office;
		  N = office.length;
		  robot[0]=r;
		  robot[1]=c;
		  dust+=off[r][c];
		  off[r][c]=0;
		  
		  for(String s : move) {
			  if(s.equals("go")) go();
			  else if(s.equals("right")) right();
			  else if(s.equals("left")) left();
		  }
		  
	      return dust;
	  }
	  public static void go() {
		  int afterR = robot[0]+status[robot[2]][0];
		  int afterC = robot[1]+status[robot[2]][1];
		  
		  // 밖으로 벗어나거나, 장애물이 있을 때
		  if(afterR<0 || afterR>=N || afterC<0 || afterC>=N || off[afterR][afterC]==-1) return;
		  
		  dust += off[afterR][afterC];
		  off[afterR][afterC]=0;
		  robot[0] = afterR;
		  robot[1] = afterC;		  
	  }
	  
	  public static void right() {
		  robot[2]+=1;
		  if(robot[2]>3) robot[2]=0;
	  }
	  
	  public static void left() {
		  robot[2]-=1;
		  if(robot[2]<0) robot[2]=3;
	  }

}
