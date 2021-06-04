package leetcode.normal.j525;

import java.util.Map;
import java.util.TreeMap;

/**
 * Created by CHENXCHEN
 * https://leetcode-cn.com/problems/contiguous-array/
 * 525. 连续数组
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
public class Solution {
    public int findMaxLength(int[] nums) {
        int pre0 = 0, pre1 = 0;
        Map<Integer, Integer> mm = new TreeMap<>();
        mm.put(0, -1);
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) pre1 += 1;
            else pre0 += 1;
            int sign = pre0 - pre1;
            if (!mm.containsKey(sign)) mm.put(sign, i);
            else ans = Math.max(ans, i - mm.get(sign));
        }
        return ans;
    }
}
