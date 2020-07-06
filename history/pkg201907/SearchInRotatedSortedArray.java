package history.pkg201907;

public class SearchInRotatedSortedArray {

    public static void main(final String[] args) {
        final int[] A = { 4, 5, 6, 7, 8, 1, 2, 3 };
        System.out.println(new SearchInRotatedSortedArray().search(A, 8));
    }

    public int search(final int[] nums, final int target) {
        if (nums.length == 0) {
            return -1;
        }
        if (nums.length == 1) {
            if (nums[0] == target) {
                return 0;
            }
            else {
                return -1;
            }
        }
        int i = 0;
        boolean reverse = false;
        for (; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                reverse = true;
                break;
            }
        }

        if (!reverse) {
            int xleft = 0;
            int xright = nums.length - 1;
            while (xleft <= xright) {
                final int xmid = (xleft + xright) / 2;
                final int xkey = nums[xmid];
                if (xkey == target) {
                    return xmid;
                }
                else if (xkey < target) {
                    xleft = xmid + 1;
                }
                else {
                    xright = xmid - 1;
                }
            }
            return -1;
        }

        int left = 0;
        int right = i;
        if (nums[left] <= target && nums[right] >= target) {
            while (left <= right) {
                final int mid = (left + right) / 2;
                final int key = nums[mid];
                if (key == target) {
                    return mid;
                }
                else if (key < target) {
                    left = mid + 1;
                }
                else {
                    right = mid - 1;
                }
            }
        }

        int rleft = i + 1;

        int rright = nums.length - 1;

        if (nums[rleft] <= target && nums[rright] >= target) {
            while (rleft <= rright) {
                final int rmid = (rleft + rright) / 2;
                final int rkey = nums[rmid];
                if (rkey == target) {
                    return rmid;
                }
                else if (rkey < target) {
                    rleft = rmid + 1;
                }
                else {
                    rright = rmid - 1;
                }
            }
        }
        return -1;
    }
}
