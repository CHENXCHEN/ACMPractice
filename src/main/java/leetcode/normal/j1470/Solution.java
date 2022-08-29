package leetcode.normal.j1470;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/shuffle-the-array/">1470. 重新排列数组</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] ans = new int[nums.length];
        boolean isOdd = false;
        for (int i = 0, j = 0, k = n; i < nums.length; i++) {
            if (isOdd) ans[i] = nums[k++];
            else ans[i] = nums[j++];
            isOdd ^= true;
        }
        return ans;
    }
}