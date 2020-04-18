package prbm_greed;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Scale {

	public static void main(String[] args) {
//		int[] weight = {1, 2, 3, 4, 5, 6, 7, 10, 50};
		int[] weight = {3, 1, 6, 2, 7, 30, 1};
		System.out.println(solution3(weight));
	}
	
	// Set도 시간초과
    public static int solution(int[] weight) {
    	Arrays.parallelSort(weight);
    	Set<Integer> set = new HashSet<>();
    	set.add(0);
        
    	for(int i=0; i<weight.length; i++) {
    		Set<Integer> temp = new HashSet<>();
    		for(int j : set) temp.add(j+weight[i]);
    		set.addAll(temp);
    	}
    	
        int[] array = new int[set.size()];    	
        int i=0;        
    	for(int s : set) array[i++]=s;
        
    	Arrays.parallelSort(array);
    	for(int j=0; j<array.length; j++) {
    		 System.out.println(array[j]+" ");
    		if(j!=array[j]) return j;            
        }

        return array[array.length-1];
    }

    // 배열도 시간초과
    public static int solution2(int[] weight) {
    	Arrays.parallelSort(weight);
    	int[] array = new int[100000000]; // 배열 사이즈를 1억 해주니까 모든 정확성 테스트는 통과함.
    	array[0]=1;
    	int min=0;
    	int max=1;    	
    	for(int i=0; i<weight.length; i++) {
    		for(int j=0; j<max; j++)
    			if(array[j]!=0) array[j+weight[i]]=1;    				
    		max+=weight[i];
    		for(int j=min; j<max; j++) {
    			if(array[j]==0) {
    				min=j;
    				break;
    			}
    		}
    	}
    	for(int i=0; i<array.length; i++) {
    		if(array[i]==0) return i;
    	}
    	
    	return array[array.length-1]+1;
    }
    
    // 정렬 하나안하나 별로 차이 없네
    public static int solution3(int[] weight) {
    	int totalWeight = 0;
    	for(int i=0; i<weight.length; i++) totalWeight+= weight[i]; 
    	int[] array = new int[totalWeight+1]; // 0인 경우 포함(+1)
    	array[0]=1;
    	int max=1;    	
    	for(int i=0; i<weight.length; i++) {
    		for(int j=max-1; j>=0; j--)
    			if(array[j]!=0) array[j+weight[i]]=1;    				
    		max+=weight[i];
    		for(int j=0; j<max; j++) {
    			if(array[j]==0) System.out.print("0 ");
    			else System.out.print("1 ");
    		}
    		System.out.println("");
    	}

    	
    	for(int i=0; i<array.length; i++) {
    		
    		if(array[i]==0) {
                System.out.print("0 ");
                return i;
            } else {
                System.out.print("1 ");
            }
    		System.out.println(" : "+i);
    	}
    	System.out.println("");
    	return array.length;
    }
}
