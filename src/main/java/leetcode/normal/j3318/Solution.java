package leetcode.normal.j3318;

import java.util.Arrays;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/find-x-sum-of-all-k-long-subarrays-i/description/">3318. 计算子数组的 x-sum I</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int[] findXSum(int[] nums, int k, int x) {
        int[] cnt = new int[51];
        int n = nums.length;
        for (int i = 0; i < k - 1; i++) {
            ++cnt[nums[i]];
        }
        int[] ans = new int[n - k + 1];
        for (int i = k - 1; i < n; i++) {
            ++cnt[nums[i]];
            ans[i - k + 1] = getXSum(cnt, x);
            --cnt[nums[i - k + 1]];
        }
        return ans;
    }

    int getXSum(int[] cnt, int nums) {
        int ss = 0;
        Integer[] pos = new Integer[cnt.length];
        for (int i = 0; i < pos.length; i++) {
            pos[i] = i;
        }
        Arrays.sort(pos, (x, y) -> cnt[x] != cnt[y] ? cnt[y] - cnt[x] : y - x);
        for (int i = 0; i < nums && i < pos.length; i++) {
            ss += cnt[pos[i]] * pos[i];
        }
        return ss;
    }
}