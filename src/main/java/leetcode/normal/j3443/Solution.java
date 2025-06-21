package leetcode.normal.j3443;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/maximum-manhattan-distance-after-k-changes/description/">3443. K 次修改后的最大曼哈顿距离</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int maxDistance(String s, int k) {
        int x = 0, y = 0, ans = 0, n = s.length();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == 'N') y++;
            else if (c == 'S') y--;
            else if (c == 'E') x++;
            else if (c == 'W') x--;
            // 对于任意一步的曼哈顿距离为：|sum_N - sum_S| + |sum_E - sum_W|
            // 改变1个字符对曼哈顿距离影响只有3种情况：
            // 1. 修改横向或者纵向数量较少的字母，距离 +2
            // 2. 修改横向或者纵向数量较大的字母，距离 -2
            // 3. 不修改字母，距离不变
            // 因此将横向和纵向较少的部分视为一个整体：
            // 如果整体 > k，那么增加距离为 2 * k
            // 如果整体 <= k，那么增加的距离不超过行走过的步数
            ans = Math.max(ans, Math.min(Math.abs(x) + Math.abs(y) + k * 2, i + 1));
        }
        return ans;
    }
}