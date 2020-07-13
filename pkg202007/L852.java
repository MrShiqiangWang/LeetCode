package pkg202007;

import utils.ArrayHelper;

public class L852 {

    public static void main(final String[] args) {
        System.out.println(new L852().peakIndexInMountainArray(ArrayHelper.stringToArray("[0,1,0]")));
    }

    public int peakIndexInMountainArray(final int[] A) {
        int left = 0;
        int right = A.length - 1;
        while (left <= right) {
            final int mid = (left + right) / 2;
            if (A[mid] > A[mid + 1] && A[mid] > A[mid - 1]) {
                return mid;
            }
            else if (A[mid] < A[mid + 1]) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
