package thry_sort;

public class HeapSort3 {
    private static int[] data;
    private static int number = 20;
    
	public static void main(String[] args) {
	    data = new int[number+1];
	    for(int i=1; i< number+1; i++) {
	        data[i] = (int)(Math.random() * 100); 
	    }
	    
	    System.out.print("Before Sort : ");
	    for(int i=0; i< number+1; i++)
	        System.out.print(data[i]+ " ");

	    heapSort(data);
	    
	    System.out.print("\nAfter Sort : ");
	    for(int i=0; i< number+1; i++)
	        System.out.print(data[i]+ " ");

	}
	
	public static void heapSort(int[] data) {
		int lastIndex = data.length-1;
		buildMaxHeap(data, lastIndex);
		while(lastIndex>1) {
			swap(data, 1, lastIndex);
			lastIndex--;
			maxHeapify(data, lastIndex, 1);
		}
	}
	
	public static void buildMaxHeap(int[] data, int lastIndex) {
		for(int i=lastIndex/2; i>0; i--) {
			maxHeapify(data, lastIndex, i);
		}
	}

	public static void maxHeapify(int[] data, int lastIndex, int n) {
		if(lastIndex<2*n) return;
		else if(lastIndex==2*n) { // 2개 비교
			if(data[2*n]>data[n])
				swap(data, n, 2*n);
			maxHeapify(data, lastIndex, 2*n);

		} else { // 3개 비교
			int maxIndex;
			if(data[2*n]>data[2*n+1]) maxIndex=2*n;
			else maxIndex=2*n+1;
			
			if(data[maxIndex]>data[n])
				swap(data, n, maxIndex);
			
			maxHeapify(data, lastIndex, maxIndex);
		}
		
	}
	
	public static void swap(int[] data, int a, int b) {
		int temp = data[a];
		data[a] = data[b];
		data[b] = temp;
	}
}
