package leetcode.normal.j157;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/two-sum-ii-input-array-is-sorted/">167. 两数之和 II - 输入有序数组</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] ans = new int[2];
        Map<Integer, Integer> mm = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            int left = target - numbers[i];
            Integer prePos;
            if ((prePos = mm.get(left)) != null) {
                ans[0] = prePos + 1;
                ans[1] = i + 1;
                break;
            }
            mm.put(numbers[i], i);
        }
        return ans;
    }
}