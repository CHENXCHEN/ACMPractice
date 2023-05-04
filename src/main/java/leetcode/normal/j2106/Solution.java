package leetcode.normal.j2106;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/maximum-fruits-harvested-after-at-most-k-steps/">2106. 摘水果</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    int[][] fruits;
    int n;
    int[] preSum;

    public int maxTotalFruits(int[][] fruits, int startPos, int k) {
        this.fruits = fruits;
        this.n = fruits.length;
        this.preSum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            preSum[i + 1] = preSum[i] + fruits[i][1];
        }
        int limit = k >> 1;
        int ans = 0;
        for (int x = 0; x <= limit; x++) {
            // 先向左走 x，再往右走 k - x，那么区间为 [startPos - x, startPos + k - 2x]
            ans = Math.max(ans, calc(startPos - x, startPos + k - 2 * x));
            // 先向右走 x，再往左走 k - x，那么区间为 [startPos + 2x - k ,startPos + x]
            ans = Math.max(ans, calc(startPos + 2 * x - k, startPos + x));
        }
        return ans;
    }

    int calc(int left, int right) {
        int posRight = findLessOrEqual(right);
        int posLeft = findGreatOrEqual(left);
        if (posRight == -1 || posLeft == -1) return 0;
        return preSum[posRight + 1] - preSum[posLeft];
    }

    int findLessOrEqual(int pos) {
        int left = 0, right = n - 1, ans = -1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (fruits[mid][0] <= pos) {
                ans = mid;
                left = mid + 1;
            } else right = mid - 1;
        }
        return ans;
    }

    int findGreatOrEqual(int pos) {
        int left = 0, right = n - 1, ans = -1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (fruits[mid][0] >= pos) {
                ans = mid;
                right = mid - 1;
            } else left = mid + 1;
        }
        return ans;
    }
}