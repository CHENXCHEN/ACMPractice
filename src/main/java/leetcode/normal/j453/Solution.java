package leetcode.normal.j453;

/**
 * Created by CHENXCHEN
 * https://leetcode-cn.com/problems/minimum-moves-to-equal-array-elements/
 * 453. 最小操作次数使数组元素相等
 * 因为有 n - 1 个元素 +1，那么可以看成只有 1 个元素 -1
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int minMoves(int[] nums) {
        int min = nums[0];
        for (int n : nums) {
            if (min > n) min = n;
        }
        int cnt = 0;
        for (int n : nums) {
            cnt += n - min;
        }
        return cnt;
    }
}
