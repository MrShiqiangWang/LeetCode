package package_in_201906;

import java.util.HashMap;
import java.util.Map;

public class OriginalDigits {

    public String originalDigits(String s) {
        char[] chas = s.toCharArray();
        Map<Character, Integer> chasmap = new HashMap<>();

        // 统计字符个数
        for (int i = 0; i < chas.length; i++) {
            if (chasmap.containsKey(chas[i])) {
                chasmap.put(chas[i], chasmap.get(chas[i]) + 1);
            }
            else {
                chasmap.put(chas[i], 1);
            }
        }
        int nums[] = new int[10];
        nums[0] = 0;
        if (chasmap.containsKey('z')) {
            nums[0] = chasmap.get('z');
        }
        // 获取w的字符个�?
        nums[2] = 0;
        if (chasmap.containsKey('w')) {
            nums[2] = chasmap.get('w');
        }

        nums[6] = 0;
        if (chasmap.containsKey('x')) {
            nums[6] = chasmap.get('x');
        }

        nums[8] = 0;
        if (chasmap.containsKey('g')) {
            nums[8] = chasmap.get('g');
        }

        nums[3] = 0;
        if (chasmap.containsKey('h')) {
            nums[3] = chasmap.get('h') - nums[8];
        }

        nums[7] = 0;
        if (chasmap.containsKey('s')) {
            nums[7] = chasmap.get('s') - nums[6];
        }

        nums[5] = 0;
        if (chasmap.containsKey('v')) {
            nums[5] = chasmap.get('v') - nums[7];
        }

        nums[4] = 0;
        if (chasmap.containsKey('f')) {
            nums[4] = chasmap.get('f') - nums[3] - nums[5];
        }

        nums[1] = 0;
        if (chasmap.containsKey('o')) {
            nums[1] = chasmap.get('o') - nums[2] - nums[4] - nums[0];
        }

        nums[9] = 0;
        if (chasmap.containsKey('i')) {
            nums[9] = chasmap.get('i') - nums[5] - nums[6] - nums[8];
        }

        StringBuffer stringBuffer = new StringBuffer();

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[i]; j++) {
                stringBuffer.append(i + "");
            }
        }
        return stringBuffer.toString();
    }
}
