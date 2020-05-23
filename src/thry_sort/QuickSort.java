package thry_sort;

public class QuickSort {
	static int cnt = 0;
	static int cnt2 = 0;
	public static void main(String[] args) {
		int[] array = new int[20];
		int[] array2;
		
		for(int i=0; i<array.length; i++)
			array[i]=(int)(Math.random()*100);
		
		array2 = array.clone();
		
		for(int i=0; i<array.length; i++)
			System.out.print(array[i]+" ");
		
		System.out.println("");
		quickSort(array, 0, array.length-1);
		quickSort2(array2, 0, array2.length-1);
		
		for(int i=0; i<array.length; i++)
			System.out.print(array[i]+" ");
		
		System.out.println("\ncnt : "+cnt);
		System.out.println("\ncnt2 : "+cnt2);
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
				++cnt;
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
	
	public static void quickSort2(int[] array, int p, int r) {
		if (p<r) {
			int q = partition2(array, p, r); // 분할
			quickSort2(array, p, q-1); // 왼쪽 부분배열 정렬
			quickSort2(array, q+1, r); // 오른쪽 부분배열 정렬
		}
	}
	
	public static int partition2(int[] array, int p, int r) {
		int x = array[r]; // 마지막 값을 pivot으로 선택
		int i = p-1; // 시작값-1
		for(int j=p; j<=r-1; j++) {
			if (array[j] < x ) {
				++cnt2;
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
