package leetcode.normal.j2441;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/largest-positive-integer-that-exists-with-its-negative/">2441. 与对应负数同时存在的最大正整数</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int findMaxK(int[] nums) {
        boolean[] has = new boolean[2001];
        int ans = -1;
        for (int num : nums) {
            int reverseNum = -num + 1000;
            int curNum = num + 1000;
            if (has[reverseNum]) {
                ans = Math.max(Math.abs(num), ans);
            }
            has[curNum] = true;
        }
        return ans;
    }
}