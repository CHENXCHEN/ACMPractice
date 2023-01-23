package leetcode.normal.j2303;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/calculate-amount-paid-in-taxes/">2303. 计算应缴税款总额</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public double calculateTax(int[][] brackets, int income) {
        double ans = 0;
        int last = 0;
        for (int[] bracket : brackets) {
            int cost = Math.min(bracket[0] - last, income);
            ans += cost * bracket[1] / 100.0;
            last = bracket[0];
            income -= cost;
            if (income <= 0) break;
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] bts = {{3, 50}, {7, 10}, {12, 25}};
        solution.calculateTax(bts, 10);
    }
}