package leetcode.normal.j2017;

/**
 * Created by CHENXCHEN
 * https://leetcode-cn.com/problems/lian-xu-zi-shu-zu-de-zui-da-he-lcof/
 * 剑指 Offer 42. 连续子数组的最大和
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
public class Solution {
    public int maxSubArray(int[] nums) {
        int ans = nums[0];
        int ss = 0;
        for (int num: nums) {
            if (num > ans) ans = num;
            ss += num;
            if (ss <=0) ss = 0;
            else if (ss > ans) ans = ss;
        }
        return ans;
    }
}
