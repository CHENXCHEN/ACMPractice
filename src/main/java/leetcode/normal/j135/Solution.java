package leetcode.normal.j135;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/candy/description/">135. 分发糖果</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int candy(int[] ratings) {
        int[] leftNumbers = new int[ratings.length];
        int[] rightNumbers = new int[ratings.length];
        leftNumbers[0] = 1;
        int leftMin = 1, rightMin = 1;
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                leftNumbers[i] = leftNumbers[i - 1] + 1;
            } else {
                leftNumbers[i] = 1;
            }
            leftMin = Math.min(leftNumbers[i], leftMin);
        }
        rightNumbers[ratings.length - 1] = 1;
        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                rightNumbers[i] = rightNumbers[i + 1] + 1;
            } else {
                rightNumbers[i] = 1;
            }
            rightMin = Math.min(rightNumbers[i], rightMin);
        }
        int ans = 0;
        for (int i = 0; i < ratings.length; i++) {
            ans += Math.max(leftNumbers[i], rightNumbers[i]);
        }
        return ans;
    }
}