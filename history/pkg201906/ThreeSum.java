package history.pkg201906;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    public List<List<Integer>> threeSum(final int[] nums) {
        // ����������
        Arrays.sort(nums);
        final List<List<Integer>> result = new ArrayList<>();
        // �����ʹ��˫ָ�뷢
        int i = 0;
        int j = nums.length;
        for (; i < nums.length; i++) {
            // ���������ָ��
            for (j = nums.length - 1; j > i; j--) {

                for (int k = i + 1; k < j; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        final List<Integer> item = new ArrayList<>();
                        item.add(nums[i]);
                        item.add(nums[j]);
                        item.add(nums[k]);
                        result.add(item);
                    }
                }
            }
        }
        return result;
    }
}
