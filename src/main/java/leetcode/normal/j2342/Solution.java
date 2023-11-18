package leetcode.normal.j2342;

import java.util.HashMap;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/max-sum-of-a-pair-with-equal-sum-of-digits/description/">2342. 数位和相等数对的最大和</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int maximumSum(int[] nums) {
        HashMap<Integer, Integer> mxPos = new HashMap<>();
        int ans = -1;
        for (int i = 0; i < nums.length; i++) {
            int ss = calcSum(nums[i]);
            Integer pos = mxPos.get(ss);
            if (pos == null) {
                mxPos.put(ss, i);
            } else {
                ans = Math.max(ans, nums[i] + nums[pos]);
                if (nums[pos] < nums[i]) {
                    mxPos.put(ss, i);
                }
            }
        }
        return ans;
    }

    int calcSum(int num) {
        int ans = 0;
        while (num > 0) {
            ans += num % 10;
            num /= 10;
        }
        return ans;
    }
}