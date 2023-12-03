package leetcode.normal.j1423;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/maximum-points-you-can-obtain-from-cards/description/">1423. 可获得的最大点数</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int right = cardPoints.length - 1, rightSum = 0;
        for (int i = 0; i < k; i++, right--) {
            rightSum += cardPoints[right];
        }
        ++right;
        int preSum = 0, ans = rightSum;
        for (int i = 0; i < right && right < cardPoints.length; i++, right++) {
            rightSum -= cardPoints[right];
            preSum += cardPoints[i];
            ans = Math.max(ans, preSum + rightSum);
        }
        return ans;
    }
}