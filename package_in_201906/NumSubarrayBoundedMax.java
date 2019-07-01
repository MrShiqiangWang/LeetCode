package package_in_201906;

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

    public int numSubarrayBoundedMaxL(int[] A, int L, int R) {
        int count = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = i + 1; j < A.length; j++) {
                int[] sub = Arrays.copyOfRange(A, i, j);
                if (test(sub, L, R)) {
                    count++;
                }
            }
            int[] sub = Arrays.copyOfRange(A, i, A.length);
            if (test(sub, L, R)) {
                count++;
            }
        }
        return count;
    }

    private boolean test(int[] sub, int L, int R) {
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

    public int numSubarrayBoundedMax(int[] A, int L, int R) {
        // 子数组不包含L和R之外的数据的子数�?
        List<int[]> list = new ArrayList<>();
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
            int[] sub = list.get(i);
            for (int j = 0; j < sub.length; j++) {
                for (int k = j + 1; k < sub.length; k++) {
                    int[] subsub = Arrays.copyOfRange(sub, j, k);
                    if (check(subsub, L)) {
                        count++;
                    }
                }
                int[] subsubs = Arrays.copyOfRange(sub, j, sub.length);
                if (check(subsubs, L)) {
                    count++;
                }
            }
        }
        return count;
    }

    private boolean check(int[] subsubs, int L) {
        for (int i = 0; i < subsubs.length; i++) {
            if (subsubs[i] >= L) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] A = { 2, 1, 4, 3 };

        System.out.println(new NumSubarrayBoundedMax().numSubarrayBoundedMaxL(A, 2, 3));
    }
}
