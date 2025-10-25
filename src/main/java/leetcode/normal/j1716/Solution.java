package leetcode.normal.j1716;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/calculate-money-in-leetcode-bank/description/">1716. 计算力扣银行的钱</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int totalMoney(int n) {
        // [1,7) -> 0, [8,14) -> 1, [15, 21) -> 2, [22,28) -> 3
        // 前面经历了多少个完整的周
        int round = n / 7;
        // 剩余的天数
        int remain = n % 7;
        // 除了第一周以外，剩余的完整周，都要添加偏移量
        // 第二周 +7，第三周 +14，第三周 +21
        int ans = round * 28 + 7 * round * (round - 1) / 2;
//        System.out.println("round = " + round + ", remain = " + remain);
        // 剩余的天数，每一天都要加上 round 开始
        if (remain != 0) {
            ans += (round + 1 + round + remain) * remain / 2;
        }
        return ans;
    }
}