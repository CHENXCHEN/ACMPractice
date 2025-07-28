package leetcode.normal.j2044;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/count-number-of-maximum-bitwise-or-subsets/description/">2044. 统计按位或能得到最大值的子集数目</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int countMaxOrSubsets(int[] nums) {
        int n = nums.length, tot = 1 << n;
        int mx = 0, cnt = 0;
        for (int i = 0; i < tot; i++) {
            int cur = 0;
            for (int j = 0; j < n; j++) {
                if (((i >> j) & 1) == 1) {
                    cur |= nums[j];
                }
            }
            if (cur > mx) {
                mx = cur;
                cnt = 1;
            } else if (cur == mx) {
                cnt++;
            }
        }
        return cnt;
    }
}