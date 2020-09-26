package jv.thry_sort;

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
			int q = (p+r)/2; // p, r�� �߰� ���� ���
			mergeSort(A, p, q); // ���ݺ� ����
			mergeSort(A, q+1, r); // �Ĺݺ� ����
			merge(A, p, q, r); // �պ�
		}
	}
	
	public static void merge(int[] data, int p, int q, int r) {

		// p=0, r=data.length()-1 �̰���
		int i=p, j=q+1, k=p;
		int[] tmp = new int[data.length];
		while(i<=q && j<=r) {
			if(data[i]<=data[j])
				tmp[k++]=data[i++];
			else
				tmp[k++]=data[j++];
		}

		// ���ݺ�, �Ĺݺ� �� �� ���� �� �Ű�����
		while (i<=q)
				tmp[k++]=data[i++];
		while (j<=r)
				tmp[k++]=data[j++];

		// tmp[]�� �ٽ� data[]��
		for (i=p; i<=r; i++)
				data[i]=tmp[i];
	}

	// �ð����⵵ O(N)

}
