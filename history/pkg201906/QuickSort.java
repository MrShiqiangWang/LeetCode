package history.pkg201906;

public class QuickSort {

    public static void main(final String[] args) {
        final int[] A = { 809, 3, 5, 6, 1, 89, 45, 890, 23, 43 };
        QuickSort.quickSort(A, 0, A.length - 1);
        for (int i = 0; i < A.length; i++) {
            System.out.println(A[i]);
        }
    }

    public static void quickSort(final int[] array, final int left, final int right) {

        if (left >= right) {
            return;
        }
        // partition
        final int index = getPartition(array, left, right);

        quickSort(array, left, index - 1);
        quickSort(array, index + 1, right);
    }

    private static int getPartition(final int[] array, int left, int right) {
        final int keyIndex = left;
        final int key = array[left];

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

    private static void swap(final int[] array, final int left, final int right) {
        final int tmp = array[left];
        array[left] = array[right];
        array[right] = tmp;
    }
}
