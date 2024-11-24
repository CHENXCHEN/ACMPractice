package leetcode.normal.j1228;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/missing-number-in-arithmetic-progression/description/">1228. 等差数列中缺失的数字</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int missingNumber(int[] arr) {
        int d = (arr[arr.length - 1] - arr[0]) / arr.length;
        int ans = -1;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] + d != arr[i + 1]) {
                return arr[i] + d;
            }
        }
        return arr[0];
    }
}