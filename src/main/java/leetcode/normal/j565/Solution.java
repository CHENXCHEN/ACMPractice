package leetcode.normal.j565;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/array-nesting/">565. 数组嵌套</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int arrayNesting(int[] nums) {
        int ans = 0, n = nums.length;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == n) continue;
            int cnt = 0;
            while (nums[i] != n) {
                int pre = nums[i];
                nums[i] = n;
                ++cnt;
                i = pre;
            }
            if (cnt > ans) ans = cnt;
        }
        return ans;
    }
}