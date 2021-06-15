package leetcode.normal.j852;

/**
 * Created by CHENXCHEN
 * https://leetcode-cn.com/problems/peak-index-in-a-mountain-array/
 * 852. 山脉数组的峰顶索引
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
public class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int l = 1, r = arr.length - 1;
        int ans = 0;
        while (l <= r) {
            int m = (l + r) >> 1;
            if (arr[m] > arr[m + 1]) {
                ans = m;
                r = m - 1;
            } else l = m + 1;
        }
        return ans;
    }
}
