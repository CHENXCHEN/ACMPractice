package leetcode.normal.j2927;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/distribute-candies-among-children-iii/description/">2927. 给小朋友们分糖果 III</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public long distributeCandies(int n, int limit) {
        // x + y + z = n
        // x,y,z <= limit, n <= 3 * limit
        // left = n - x = y + z <= 2 * limit
        // n - x <= 2 * limit
        // n - 2 * limit <= x <= limit
        // y + z = left => z = left - y <= limit => 0 <= left - limit <= y <= limit <= left
        // 假设 x 已知，那么当 x 确定时，一共有 [max(0, left - limit), min(left, limit)] 的选择
        // 考虑 max(n - 2 * limit, 0) <= x <= limit, left = n - x
        // 转换 n - limit <= left <= n - max(n - 2 * limit, 0)
        // 考虑右边界固定为 limit 时的情况，当且仅当 left >= limit 时
        //      res = [left - limit, limit], ans = 2 * limit - left + 1
        //      ans 随着 left 的增大，而减少
        //      当 left = limit 时候，ans = limit + 1
        //      当 left = 2 * limit 时，ans = 1
        // 考虑左边界固定为 0     时的情况，当且仅当 left <  limit 时
        //      res = [0, left], ans = left + 1
        //      ans 随着 left 增大而增大
        //      当 left = limit - 1 时，ans = limit
        limit = Math.min(limit, n);
        if (n > 3 * limit) return 0;
        long ans = 0L;
        // x 的取值范围：
        // n - 2 * limit <= x <= limit
        long borderLeft = Math.max(0, n - 2 * limit), borderRight = limit;
        // left = n - x
        // left 的取值范围: n - limit <= left <= n - max(n - 2 * limit, 0)
        long newLeft = n - borderRight, newRight = n - borderLeft;
//        System.out.println("x: borderLeft=" + borderLeft + ", borderRight=" + borderRight);
//        System.out.println("left: " + newLeft + " right: " + newRight);
        // 当 newLeft >= limit 时候
        if (newRight >= limit) {
            long last = 2L * limit - Math.max(limit, newLeft) + 1, first = 2L * limit - newRight + 1;
//            System.out.println("11: first: " + first + " last: " + last);
            ans += (last - first + 1) * (first + last) / 2;
        }
//        System.out.println("ans1: " + ans);
        // 当 left < limit 时
        // 当 newLeft < limit
        if (newLeft < limit) {
            long first = newLeft + 1, last = Math.min(limit - 1, newRight) + 1;
//            System.out.println("22: first: " + first + " last: " + last);
            ans += (last - first + 1) * (first + last) / 2;
        }
//        System.out.println("ans2: " + ans);
        return ans;
    }
}