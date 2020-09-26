package jv.thry_sort;

public class SelectionSort {
	public static void main(String[] args) {
		int[] array = new int[20];
		
		for(int i=0; i<array.length; i++) {
			array[i]=(int)(Math.random()*100);
		}		
		for(int i=0; i<array.length; i++) {
			System.out.print(array[i]+" ");
		}
		System.out.println("");
		selectionSort(array);
		for(int i=0; i<array.length; i++) {
			System.out.print(array[i]+" ");
		}
	}
	
	public static void selectionSort(int[] unsortedArray) {
		int n = unsortedArray.length;
		for(int i=n-1; i>=1; i--) {
			int maxIndex = i;
			for(int j=i-1; j>=0; j-- ) {
				if(unsortedArray[j]>unsortedArray[maxIndex]) maxIndex = j; 
			}
			int temp = unsortedArray[i];
			unsortedArray[i] = unsortedArray[maxIndex];
			unsortedArray[maxIndex] = temp;			
		}
	}

}
