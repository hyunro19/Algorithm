package lan_java.thry_sort;

public class HeapSort2 {
    private static int[] data;
    private static int number = 20;
    
    public static void heap(int[] data, int number) {
    	for(int i=number-1; i>0; i--) {
//    	for(int i=1; i<number; i++) { 기존 코드에서 이상했던 부분(연산낭비)
            int child = i;
            while(child > 0) {
                int parent = (child-1)/2;
                if(data[child] > data[parent]) {
                    int temp = data[parent];
                    data[parent] = data[child];
                    data[child] = temp;
                }
                child = parent;
            }
        }
    }
    public static void main(String[] args) {
	    data = new int[number];
	    for(int i=0; i< number; i++) {
	        data[i] = (int)(Math.random() * 100); 
	    }
	    
	    System.out.print("Before Sort : ");
	    for(int i=0; i< number; i++) {
	        System.out.print(data[i]+ " ");
	    }
	    heap(data, number);
	    
	    for(int i = number-1; i>0; i--) {
	        int temp = data[0];
	        data[0] = data[i];
	        data[i] = temp;
	        
//		    System.out.print("\nWhile Sorting ("+i+") : ");
//		    for(int j=0; j< number; j++) {
//		        System.out.print(data[j]+ " ");
//		    }
		    
	        heap(data, i);
	    }
	    
	    System.out.print("\nAfter Sort : ");
	    for(int i=0; i< number; i++) {
	        System.out.print(data[i]+ " ");
	    }
    
    }
}