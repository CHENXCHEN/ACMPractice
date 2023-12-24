package leetcode.normal.j1954;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/minimum-garden-perimeter-to-collect-enough-apples/description/">1954. 收集足够苹果的最小花园周长</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public long minimumPerimeter(long neededApples) {
        // 二分右上角的坐标为 ans
        long left = 1, right = 100000, ans = 0;
        while (left <= right) {
            long mid = (left + right) / 2;
            if (2 * mid * (mid + 1) * (mid * 2 + 1) >= neededApples) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans * 8;
    }
}