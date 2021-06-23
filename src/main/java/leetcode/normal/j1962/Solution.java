package leetcode.normal.j1962;

/**
 * Created by CHENXCHEN
 * https://leetcode-cn.com/problems/er-jin-zhi-zhong-1de-ge-shu-lcof/
 * 剑指 Offer 15. 二进制中1的个数
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
public class Solution {
    public int hammingWeight(int n) {
        int ans = 0;
        while (n != 0) {
            n &= (n - 1);
            ans += 1;
        }
        return ans;
    }
}