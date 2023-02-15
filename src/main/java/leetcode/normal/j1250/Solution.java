package leetcode.normal.j1250;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/check-if-it-is-a-good-array/description/">1250. 检查「好数组」</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public boolean isGoodArray(int[] nums) {
        // 由 裴蜀定理 可得
        int tmpGcd = nums[0];
        for (int i = 1; i < nums.length; i++)
            tmpGcd = gcd(tmpGcd, nums[i]);
        return tmpGcd == 1;
    }

    int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}