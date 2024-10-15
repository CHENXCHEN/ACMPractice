package leetcode.normal.j3200;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/maximum-height-of-a-triangle/description/">3200. 三角形的最大高度</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int maxHeightOfTriangle(int red, int blue) {
        // 1 + 3 + 5 + ... + 2n-1 => n * (1 + 2n - 1) / 2 => n^2
        // 2 + 4 + 6 + ... + 2m => m * (1 + 2m) / 2
        int left = 1, right = Math.max(red, blue), ans = 1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (guess(red, blue, mid)) {
                ans = mid;
                left = mid + 1;
            } else right = mid - 1;
        }
        return ans;
    }

    boolean guess(int red, int blue, int guess) {
        int num1 = (guess + 1) / 2, num2 = guess - num1;
        int sum1 = num1 * num1, sum2 = num2 * (2 + 2 * num2) / 2;
//        System.out.printf("guess: %d num1: %d num2: %d sum1: %d sum2: %d\n", guess, num1, num2, sum1, sum2);
        return (red >= sum1 && blue >= sum2) || (red >= sum2 && blue >= sum1);
    }
}