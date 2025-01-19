package leetcode.normal.j2239;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/find-closest-number-to-zero/description/">2239. 找到最接近 0 的数字</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int findClosestNumber(int[] nums) {
        int ans = 0, last = Integer.MAX_VALUE;
        for (int num : nums) {
            int abs = Math.abs(num);
            if (abs < last || (abs == last && num > ans)) {
                ans = num;
                last = Math.abs(num);
            }
        }
        return ans;
    }
}