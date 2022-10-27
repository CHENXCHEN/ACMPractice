package leetcode.normal.j1822;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/sign-of-the-product-of-an-array/">1822. 数组元素积的符号</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution2 {
    public int arraySign(int[] nums) {
        int ans = 0;
        for (int num : nums) {
            if (num < 0) ++ans;
            else if (num == 0) return 0;
        }
        return (ans & 1) == 1 ? -1 : 1;
    }
}