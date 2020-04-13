package thry_sort;

public class MergeSort {
	public static void main(String[] args) {
		int[] array = new int[20];
		
		for(int i=0; i<array.length; i++) {
			array[i]=(int)(Math.random()*100);
		}		
		for(int i=0; i<array.length; i++) {
			System.out.print(array[i]+" ");
		}
		System.out.println("");
		mergeSort(array, 0, array.length-1);
		for(int i=0; i<array.length; i++) {
			System.out.print(array[i]+" ");
		}
	}
	
	public static void mergeSort(int[] A, int p, int r) {
		if (p<r) {
			int q = (p+r)/2; // p, r의 중간 지점 계산
			mergeSort(A, p, q); // 전반부 정렬
			mergeSort(A, q+1, r); // 후반부 정렬
			merge(A, p, q, r); // 합병
		}
	}
	
	public static void merge(int[] data, int p, int q, int r) {

		// p=0, r=data.length()-1 이겠지
		int i=p, j=q+1, k=p;
		int[] tmp = new int[data.length];
		while(i<=q && j<=r) {
			if(data[i]<=data[j])
				tmp[k++]=data[i++];
			else
				tmp[k++]=data[j++];
		}

		// 전반부, 후반부 중 한 쪽이 다 옮겨지면
		while (i<=q)
				tmp[k++]=data[i++];
		while (j<=r)
				tmp[k++]=data[j++];

		// tmp[]를 다시 data[]로
		for (i=p; i<=r; i++)
				data[i]=tmp[i];
	}

	// 시간복잡도 O(N)

}
