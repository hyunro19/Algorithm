package jv.thry_sort;

public class BubbleSort {
	
	public static void main(String[] args) {
		int[] array = new int[20];
		
		for(int i=0; i<array.length; i++) {
			array[i]=(int)(Math.random()*100);
		}		
		for(int i=0; i<array.length; i++) {
			System.out.print(array[i]+" ");
		}
		System.out.println("");
		bubbleSort(array);
		for(int i=0; i<array.length; i++) {
			System.out.print(array[i]+" ");
		}
	}
	
	public static void bubbleSort(int[] unsortedArray) {
		int n = unsortedArray.length;
		for(int i=n; i>0; i--) {
			for(int j=0; j<i-1; j++) {
				if(unsortedArray[j]>unsortedArray[j+1]) {
					int temp = unsortedArray[j];
					unsortedArray[j] = unsortedArray[j+1];
					unsortedArray[j+1] = temp;
				}
			}
		}
		
	}

}
