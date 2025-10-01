package leetcode.normal.j2221;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/find-triangular-sum-of-an-array/description/">2221. 数组的三角和</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int triangularSum(int[] nums) {
        int[] cur = nums;
        while (cur.length > 1) {
            int[] next = new int[cur.length - 1];
            for (int i = 0; i < cur.length - 1; i++) {
                next[i] = (cur[i] + cur[i + 1]) % 10;
            }
            cur = next;
        }
        return cur[0];
    }
}