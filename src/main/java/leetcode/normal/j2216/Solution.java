package leetcode.normal.j2216;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/minimum-deletions-to-make-array-beautiful/description/">2216. 美化数组的最少删除数</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int minDeletion(int[] nums) {
        int ans = 0;
        int i = 0;
        while (i < nums.length) {
            int j = i + 1;
            while (j < nums.length && nums[i] == nums[j]) {
                ++ans;
                ++j;
            }
            if (j == nums.length) {
                ++ans;
            }
            i = j + 1;
        }
        return ans;
    }
}