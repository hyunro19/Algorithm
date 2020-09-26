package jv.thry_sort;

public class InsertionSort {
	public static void main(String[] args) {
		int[] array = new int[20];
		
		for(int i=0; i<array.length; i++) {
			array[i]=(int)(Math.random()*100);
		}		
		for(int i=0; i<array.length; i++) {
			System.out.print(array[i]+" ");
		}
		System.out.println("");
		insertionSort(array);
		for(int i=0; i<array.length; i++) {
			System.out.print(array[i]+" ");
		}
	}
	
	public static void insertionSort(int[] unsortedArray) {
		int n = unsortedArray.length;
		// for�� ����
//		for(int i=1; i<n; i++) {
//			int insertItem = unsortedArray[i];
//			for(int j=i-1; j>=0; j--) {				
//				if(insertItem<unsortedArray[j]) {
//					unsortedArray[j+1] = unsortedArray[j];
//				} else {
//					unsortedArray[j+1] = insertItem;
//					break;
//				}
//				if(j==0) unsortedArray[j] = insertItem;
//			}
//		}
		
		// while�� ����
		for(int i=1; i<n; i++) {
			int insertItem = unsortedArray[i];
			int j = i-1;
			while(j>=0 && unsortedArray[j]>insertItem) {
				unsortedArray[j+1] = unsortedArray[j];
				j--;
			}
			unsortedArray[j+1] = insertItem;			
		}
	}

}
