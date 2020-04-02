package sort;

public class QuickSort {
	public static void main(String[] args) {
		int[] array = new int[20];
		
		for(int i=0; i<array.length; i++) {
			array[i]=(int)(Math.random()*100);
		}		
		for(int i=0; i<array.length; i++) {
			System.out.print(array[i]+" ");
		}
		System.out.println("");
		quickSort(array, 0, array.length-1);
		for(int i=0; i<array.length; i++) {
			System.out.print(array[i]+" ");
		}
	}
	
	public static void quickSort(int[] array, int p, int r) {
		if (p<r) {
			int q = partition(array, p, r); // 분할
			quickSort(array, p, q-1); // 왼쪽 부분배열 정렬
			quickSort(array, q+1, r); // 오른쪽 부분배열 정렬
		}
	}
	
	public static int partition(int[] array, int p, int r) {
		int x = array[r]; // 마지막 값을 pivot으로 선택
		int i = p-1; // 시작값-1
		for(int j=p; j<=r-1; j++) {
			if (array[j] <= x ) {
				i = i+1;
				// exchange array[i] and array[j]
				int temp = array[i];
				array[i] = array[j];
				array[j] = temp;
			}
		}
		// exchange array[i+1] and array[r]
		int temp = array[i+1];
		array[i+1] = array[r];
		array[r] = temp;
		
		return i+1;
	}

	
}
