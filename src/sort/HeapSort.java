package sort;

public class HeapSort {
	public static void main(String[] args) {
		int[] array = new int[20];
		
		for(int i=0; i<array.length; i++) {
			array[i]=(int)(Math.random()*100);
		}		
		for(int i=0; i<array.length; i++) {
			System.out.print(array[i]+" ");
		}
		System.out.println("");
		heapSort(array);
		for(int i=0; i<array.length; i++) {
			System.out.print(array[i]+" ");
		}
	}
	public static void heapSort(int[] array) {
		int n = array.length-1;
		for(int i=n; i>0; i--) {
			buildMaxHeap(array, i);
			int temp = array[i];
			array[i] = array[0];
			array[0] = temp;
//			for(int k=0; k<array.length; k++) {
//				System.out.print(array[k]+" ");
//			}
//			System.out.println("");
		}
		
	}
	
	public static void buildMaxHeap(int[] array, int n) {
		for(int i=(n-1)/2; i>=0; i--) {
			maxHeapify(array, i, n);
		}
	}
	
	public static void maxHeapify(int[] array, int i, int n) {
		if (n>=(2*i+2)) { // 3개 비교
			int tempIndex;
			if(array[2*i+1] > array[2*i+2]) {
				tempIndex = 2*i+1;
			} else {
				tempIndex = 2*i+2; 
			}
			if(array[tempIndex]>array[i]) {
				int temp = array[tempIndex];
				array[tempIndex] = array[i];
				array[i] = temp;
			}
		} else { // 2개 비교
			if(array[2*i+1]>array[i]) {
				int temp = array[2*i+1];
				array[2*i+1] = array[i];
				array[i] = temp;
			}
		}
	}

}
