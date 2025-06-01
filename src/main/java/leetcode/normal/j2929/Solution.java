package leetcode.normal.j2929;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/distribute-candies-among-children-ii/description/">2929. 给小朋友们分糖果 II</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public long distributeCandies(int n, int limit) {
        limit = Math.min(n, limit);
        long ans = 0;
        for (int i = 0; i <= limit; i++) {
            // 枚举给第一位小朋友分配 i 枚糖果，那么剩下两位小朋友的分配方式已经是固定下来了
            int left = n - i;
            // x + y = left, x <= limit, y <= limit
            // 0 <= left - limit <= y <= limit <= left
            // y 应该位于 [max(0, left-limit), min(left, limit)] 区间内
            if (left - limit <= limit) {
                ans += (long) Math.min(left, limit) - Math.max(0, left - limit) + 1;
            }
        }
        return ans;
    }
}