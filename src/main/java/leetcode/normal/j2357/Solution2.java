package leetcode.normal.j2357;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/make-array-zero-by-subtracting-equal-amounts/">2357. 使数组中所有元素都等于零</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution2 {
    public int minimumOperations(int[] nums) {
        int ans = 0;
        boolean[] vis = new boolean[101];
        vis[0] = true;
        for (int num : nums) {
            if (!vis[num]) {
                ++ans;
                vis[num] = true;
            }
        }
        return ans;
    }
}