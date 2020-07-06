package history.pkg201906;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumSubarrayBoundedMax {

    // 给定�?个元素都是正整数的数组A ，正整数 L 以及 R (L <= R)�?
    //
    // 求连续�?�非空且其中�?大元素满足大于等于L 小于等于R的子数组个数�?
    //
    // 例如 :
    // 输入:
    // A = [2, 1, 4, 3]
    // L = 2
    // R = 3
    // 输出: 3
    // 解释: 满足条件的子数组: [2], [2, 1], [3].
    //
    // 来源：力扣（LeetCode�?
    // 链接：https://leetcode-cn.com/problems/number-of-subarrays-with-bounded-maximum
    // 著作权归领扣网络�?有�?�商业转载请联系官方授权，非商业转载请注明出处�??

    public static void main(final String[] args) {
        final int[] A = { 2, 1, 4, 3 };

        System.out.println(new NumSubarrayBoundedMax().numSubarrayBoundedMaxL(A, 2, 3));
    }

    public int numSubarrayBoundedMax(final int[] A, final int L, final int R) {
        // 子数组不包含L和R之外的数据的子数�?
        final List<int[]> list = new ArrayList<>();
        int begin = 0;
        int end = 0;
        // 找到范围内比R小的数据
        for (int i = 0; i < A.length; i++) {
            // 如果范围之内
            if (A[i] <= R) {
                end++;
            }
            else {
                if (begin < end) {
                    list.add(Arrays.copyOfRange(A, begin, end));
                }
                // 范围之外
                begin = i + 1;
                end = i + 1;
            }
        }
        if (begin < end) {
            list.add(Arrays.copyOfRange(A, begin, end));
        }
        int count = 0;
        for (int i = 0; i < list.size(); i++) {
            final int[] sub = list.get(i);
            for (int j = 0; j < sub.length; j++) {
                for (int k = j + 1; k < sub.length; k++) {
                    final int[] subsub = Arrays.copyOfRange(sub, j, k);
                    if (this.check(subsub, L)) {
                        count++;
                    }
                }
                final int[] subsubs = Arrays.copyOfRange(sub, j, sub.length);
                if (this.check(subsubs, L)) {
                    count++;
                }
            }
        }
        return count;
    }

    public int numSubarrayBoundedMaxL(final int[] A, final int L, final int R) {
        int count = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = i + 1; j < A.length; j++) {
                final int[] sub = Arrays.copyOfRange(A, i, j);
                if (this.test(sub, L, R)) {
                    count++;
                }
            }
            final int[] sub = Arrays.copyOfRange(A, i, A.length);
            if (this.test(sub, L, R)) {
                count++;
            }
        }
        return count;
    }

    private boolean check(final int[] subsubs, final int L) {
        for (int i = 0; i < subsubs.length; i++) {
            if (subsubs[i] >= L) {
                return true;
            }
        }
        return false;
    }

    private boolean test(final int[] sub, final int L, final int R) {
        if (sub.length == 0) {
            return false;
        }
        int max = sub[0];
        for (int i = 0; i < sub.length; i++) {
            max = Math.max(max, sub[i]);
        }
        if (max <= R && max >= L) {
            return true;
        }
        return false;
    }
}
