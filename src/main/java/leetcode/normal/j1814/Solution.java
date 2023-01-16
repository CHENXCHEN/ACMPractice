package leetcode.normal.j1814;

import java.util.HashMap;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/count-nice-pairs-in-an-array/">1814. 统计一个数组中好对子的数目</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int countNicePairs(int[] nums) {
        int[] revNums = new int[nums.length], diffNum = new int[nums.length];
        for (int i = 0; i < nums.length; i++) revNums[i] = getRev(nums[i]);
        for (int i = 0; i < nums.length; i++) diffNum[i] = revNums[i] - nums[i];
        int mod = 1000000007, ans = 0;
        // 需要求 i < j，并且 nums[i] + rev(nums[j]) = rev(nums[i]) + nums[j] 的 (i,j) 对数
        // 转换公式则可得 nums[i] - rev(nums[i]) = nums[j] - rev(nums[j])
        // 令 diffNums[i] = nums[i] - rev(nums[i])
        // 枚举到 diffNums[j] 时，求 i < j，有多少个 diffNums[i] = diffNums[j]
        HashMap<Integer, Integer> mp = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int cnt = mp.getOrDefault(diffNum[i], 0);
            ans = (ans + cnt) % mod;
            mp.put(diffNum[i], cnt + 1);
        }
        return ans;
    }

    int getRev(int num) {
        int ans = 0;
        while (num > 0) {
            ans = (ans << 1) + (ans << 3) + num % 10;
            num /= 10;
        }
        return ans;
    }
}