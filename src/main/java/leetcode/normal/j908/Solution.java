package leetcode.normal.j908;

import java.util.Arrays;

/**
 * Created by CHENXCHEN
 * https://leetcode-cn.com/problems/smallest-range-i/
 * 908. 最小差值 I
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int smallestRangeI(int[] nums, int k) {
        int max = Arrays.stream(nums).max().getAsInt();
        int min = Arrays.stream(nums).min().getAsInt();
        int k2 = k << 1;
        if (max - min <= k2) return 0;
        else return max - min - k2;
    }
}