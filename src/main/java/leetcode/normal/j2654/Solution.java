package leetcode.normal.j2654;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/minimum-number-of-operations-to-make-all-array-elements-equal-to-1/description/">2654. 使数组所有元素变成 1 的最少操作次数</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int minOperations(int[] nums) {
        // 如果存在 1，那么最小操作数为 n - cnt1
        // 如果整个数组的最大公约数 > 0，那么结果为 -1
        // 否则找到最小长度的区间的 gcd = 1，那么操作这个区间成为 1 需要 minLen - 1 次，然后再由这个 1 使得其他数字变为 1 需要 n - 1 次
        int n = nums.length, cnt1 = 0, g = 0;
        for (int num : nums) {
            if (num == 1) ++cnt1;
            g = gcd(g, num);
        }
        if (cnt1 > 0) return n - cnt1;
        if (g > 1) return -1;
        int minLen = n;
        for (int i = 0; i < n; i++) {
            int currentGcd = 0;
            for (int j = i; j < n; j++) {
                currentGcd = gcd(currentGcd, nums[j]);
                if (currentGcd == 1) {
                    minLen = Math.min(minLen, j - i + 1);
                    break;
                }
            }
        }
//        System.out.println("minLen = " + minLen);
        return minLen + n - 2;
    }

    int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}