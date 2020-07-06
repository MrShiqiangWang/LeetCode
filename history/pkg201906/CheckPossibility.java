package history.pkg201906;

public class CheckPossibility {

    public static void main(final String[] args) {
        final int A[] = { 1, 3, 5, 2, 4 };
        System.out.println(new CheckPossibility().checkPossibility(A));
    }

    public boolean checkPossibility(final int[] nums) {
        int i1 = 0;
        int i2 = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                if (i1 != 0 || i2 != 0) {
                    return false;
                }
                // ��ǰ�ұ�nums[i+1]������ݸ���
                for (int j = i; j >= 0 && i1 <= 1; j--) {
                    if (nums[j] > nums[i + 1]) {
                        i1++;
                    }
                }
                // ����ұ�num[i]С������
                for (int j = i + 1; j < nums.length && i2 <= 1; j++) {
                    if (nums[j] < nums[i]) {
                        i2++;
                    }
                }
                if (i1 <= 1 && i2 <= 1) {
                    nums[i] = nums[i + 1];
                    continue;
                }
                if (i1 <= 1 && i2 > 1) {
                    nums[i] = nums[i + 1];
                    continue;
                }
                if (i1 > 1 && i <= 1) {
                    nums[i + 1] = nums[i];
                    continue;
                }
                if (i1 > 1 && i2 > 1) {
                    return false;
                }
            }
        }
        return true;
    }
}
