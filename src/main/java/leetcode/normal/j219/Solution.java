package leetcode.normal.j219;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/contains-duplicate-ii/description/">219. 存在重复元素 II</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> hash = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer pre = hash.get(nums[i]);
            if (pre != null && i - pre <= k) return true;
            hash.put(nums[i], i);
        }
        return false;
    }
}