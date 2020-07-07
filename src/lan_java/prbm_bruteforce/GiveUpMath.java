package lan_java.prbm_bruteforce;

public class GiveUpMath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] answers = {1,2,3,4,5};
		int[] print = solution(answers);
		for(int index : print) System.out.print(index+", ");
	}
	
	// �������� 3���� ��Ÿ���°� ��� �� �����ϰ� �� �� �ִ��� �𸣰ڴ�.
    public static int[] solution(int[] answers) {
    	int[] student1 = {1,2,3,4,5};
    	int[] student2 = {2,1,2,3,2,4,2,5};
    	int[] student3 = {3,3,1,1,2,2,4,4,5,5};
    	
    	// length1~3�� cnt1~3�� length�迭�� cnt�迭�� ������ �� ����ϰڴ�.
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
        
        // �� ������ �л��� 3��ۿ� ��� ��� 6�� ����� ���� �� ����������
        // �л� ���� ������ ��� �Ʒ� ����� ����� �� �ִ�.
        // 1ȸ�� loop�� ������ �ִ밪�� ã�Ƴ� ����. �װͰ� ���� �׸� �߰��ϴ� �͵� ������, �׸��� �迭 ��ȯ
        // n+n+n �̹Ƿ� O(n)
//        int maxScore = Math.max(score[0], Math.max(score[1], score[2]));
//        ArrayList<Integer> list = new ArrayList<>();
//        if(maxScore == score[0]) {list.add(1);}
//        if(maxScore == score[1]) {list.add(2);}
//        if(maxScore == score[2]) {list.add(3);}
//        return list.stream().mapToInt(i->i.intValue()).toArray();
    }

}

