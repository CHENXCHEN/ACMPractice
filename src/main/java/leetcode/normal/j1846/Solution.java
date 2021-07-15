package leetcode.normal.j1846;

import java.util.Arrays;

/**
 * Created by CHENXCHEN
 * https://leetcode-cn.com/problems/maximum-element-after-decreasing-and-rearranging/
 * 1846. 减小和重新排列数组后的最大元素
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
public class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        Arrays.sort(arr);
        int ans = 0;
        for (int elem : arr) {
            if (elem >= ans + 1) ans++;
        }
        return ans;
    }
}
