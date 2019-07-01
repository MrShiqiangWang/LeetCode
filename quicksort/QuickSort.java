package quicksort;

public class QuickSort {

	public static void main(String[] args) {
		int[] A = { 809, 3, 5, 6, 1, 89, 45, 890, 23, 43 };
		QuickSort.quickSort(A, 0, A.length - 1);
		for (int i = 0; i < A.length; i++) {
			System.out.println(A[i]);
		}
	}

	public static void quickSort(int[] array, int left, int right) {

		if (left >= right) {
			return;
		}
		// partition
		int index = getPartition(array, left, right);

		quickSort(array, left, index - 1);
		quickSort(array, index + 1, right);
	}

	private static int getPartition(int[] array, int left, int right) {
		int keyIndex = left;
		int key = array[left];

		while (left < right) {

			// ���������ұ�key�������
			while (left <= right && array[left] <= key) {
				left++;
			}
			// ���������ұ�keyС������
			while (right > keyIndex && array[right] >= key) {
				right--;
			}

			if (left >= right) {
				break;
			}
			// ����left��right������
			swap(array, left, right);
		}

		swap(array, keyIndex, right);

		return right;
	}

	private static void swap(int[] array, int left, int right) {
		int tmp = array[left];
		array[left] = array[right];
		array[right] = tmp;
	}
}
