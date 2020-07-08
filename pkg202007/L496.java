package pkg202007;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import utils.ArrayHelper;

public class L496 {

    public static void main(final String[] args) {
        final int[] nums1 = ArrayHelper.stringToArray("[4,1,2]");
        final int[] nums2 = ArrayHelper.stringToArray("[1,3,4,2]");
        System.out.println(new L496().nextGreaterElement(nums1, nums2));
    }

    public int[] nextGreaterElement(final int[] nums1, final int[] nums2) {
        final Map<Integer, Integer> map = new HashMap<>();
        final Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < nums2.length; i++) {
            if (stack.isEmpty()) {
                stack.push(nums2[i]);
            }
            else {
                while (!stack.isEmpty()) {
                    final int top = stack.peek();
                    if (top > nums2[i]) {
                        stack.push(nums2[i]);
                        break;
                    }
                    else {
                        final Integer key = stack.pop();
                        map.put(key, nums2[i]);
                        if (stack.isEmpty()) {
                            stack.push(nums2[i]);
                            break;
                        }
                    }
                }
            }
        }

        final int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            if (map.containsKey(nums1[i])) {
                result[i] = map.get(nums1[i]);
            }
            else {
                result[i] = -1;
            }
        }
        return result;
    }
}
