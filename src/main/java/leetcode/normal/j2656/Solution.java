package leetcode.normal.j2656;

import java.util.Arrays;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/maximum-sum-with-exactly-k-elements/description/">2656. K 个元素的最大和</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int maximizeSum(int[] nums, int k) {
        int mx = Arrays.stream(nums).max().getAsInt();
        return (mx + mx + k - 1) * k / 2;
    }
}