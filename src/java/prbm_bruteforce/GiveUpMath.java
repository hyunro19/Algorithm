package prbm_bruteforce;

public class GiveUpMath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] answers = {1,2,3,4,5};
		int[] print = solution(answers);
		for(int index : print) System.out.print(index+", ");
	}
	
	// 마지막에 3개를 나타내는걸 어떻게 더 간단하게 할 수 있는지 모르겠다.
    public static int[] solution(int[] answers) {
    	int[] student1 = {1,2,3,4,5};
    	int[] student2 = {2,1,2,3,2,4,2,5};
    	int[] student3 = {3,3,1,1,2,2,4,4,5,5};
    	
    	// length1~3과 cnt1~3을 length배열과 cnt배열로 넣으면 더 깔끔하겠다.
    	int length1 = student1.length;
    	int length2 = student2.length;
    	int length3 = student3.length;
    	
    	int cnt1 = 0;
    	int cnt2 = 0;
    	int cnt3 = 0;
    	    	
    	for(int i=0; i<answers.length; i++) {
    		if(answers[i]==student1[i%length1]) ++cnt1;
    		if(answers[i]==student2[i%length2]) ++cnt2;
    		if(answers[i]==student3[i%length3]) ++cnt3;
    	}
    	
        int[] answer = {};
        if(cnt1>cnt2 && cnt1>cnt3) answer = new int[]{1};
        else if(cnt2>cnt1 && cnt2>cnt3) answer = new int[]{2};
        else if(cnt3>cnt1 && cnt3>cnt2) answer = new int[]{3};
        else if(cnt1==cnt2 && cnt2>cnt3) answer = new int[]{1,2};
        else if(cnt1==cnt3 && cnt3>cnt2) answer = new int[]{1,3};        
        else if(cnt2==cnt3 && cnt3>cnt1) answer = new int[]{2,3};        
        else if(cnt1==cnt2 && cnt2==cnt3) answer = new int[] {1,2,3};
        return answer;
        
        // 이 문제는 학생이 3명밖에 없어서 모든 6개 경우의 수를 다 나열했지만
        // 학생 수가 많아질 경우 아래 방법을 사용할 수 있다.
        // 1회만 loop를 돌려서 최대값을 찾아낸 다음. 그것과 같은 항목만 추가하는 것도 있을듯, 그리고 배열 변환
        // n+n+n 이므로 O(n)
//        int maxScore = Math.max(score[0], Math.max(score[1], score[2]));
//        ArrayList<Integer> list = new ArrayList<>();
//        if(maxScore == score[0]) {list.add(1);}
//        if(maxScore == score[1]) {list.add(2);}
//        if(maxScore == score[2]) {list.add(3);}
//        return list.stream().mapToInt(i->i.intValue()).toArray();
    }

}

