package leetcode.normal.j2600;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/k-items-with-the-maximum-sum/">2600. K 件物品的最大和</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int kItemsWithMaximumSum(int numOnes, int numZeros, int numNegOnes, int k) {
        int ans = 0;
        ans += Math.min(numOnes, k);
        k -= ans;
        k -= Math.min(k, numZeros);
        ans += -1 * Math.min(numNegOnes, k);
        return ans;
    }
}