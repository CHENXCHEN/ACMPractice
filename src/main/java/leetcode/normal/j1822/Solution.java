package leetcode.normal.j1822;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/sign-of-the-product-of-an-array/">1822. 数组元素积的符号</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int arraySign(int[] nums) {
        int ans = 1;
        for (int num : nums) {
            ans *= Integer.compare(num, 0);
        }
        return ans;
    }
}