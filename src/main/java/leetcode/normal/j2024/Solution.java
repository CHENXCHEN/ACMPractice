package leetcode.normal.j2024;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/maximize-the-confusion-of-an-exam/description/">2024. 考试的最大困扰度</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    int[][] preSum;

    public int maxConsecutiveAnswers(String answerKey, int k) {
        int n = answerKey.length();
        preSum = new int[2][n + 1];
        for (int i = 0; i < answerKey.length(); i++) {
            int ret = answerKey.charAt(i) == 'T' ? 1 : 0;
            preSum[0][i + 1] = preSum[0][i];
            preSum[1][i + 1] = preSum[1][i];
            preSum[ret][i + 1] += 1;
        }
        int ans = k;
        for (int i = k; i < n; i++) {
            int pos0 = binarySearch(i, k, 0);
            int pos1 = binarySearch(i, k, 1);
            ans = Math.max(ans, i - Math.min(pos1, pos0) + 1);
        }
        return ans;
    }

    int binarySearch(int end, int target, int ret) {
        int left = 0, right = end, ans = end - 1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            int v = preSum[ret][end + 1] - preSum[ret][mid];
            if (v <= target) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }
}