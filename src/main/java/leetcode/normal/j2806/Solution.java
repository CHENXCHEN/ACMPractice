package leetcode.normal.j2806;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/account-balance-after-rounded-purchase/description/">2806. 取整购买后的账户余额</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int accountBalanceAfterPurchase(int purchaseAmount) {
        int lower = purchaseAmount / 10 * 10, upper = (purchaseAmount / 10 + 1) * 10;
        if (upper - purchaseAmount <= purchaseAmount - lower) return 100 - upper;
        return 100 - lower;
    }
}