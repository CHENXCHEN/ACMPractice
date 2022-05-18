package leetcode.normal.j668;

/**
 * Created by CHENXCHEN
 * https://leetcode.cn/problems/kth-smallest-number-in-multiplication-table/
 * 668. 乘法表中第k小的数
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int findKthNumber(int m, int n, int k) {
        int left = 1, right = m * n;
        int ans = 1;
        int lastCnt = 0;
        while (left <= right) {
            int mid = (left + right) >> 1;
            int cnt = lessThanCnt(mid, m, n);
            if (cnt < k) {
                ans = mid;
                left = mid + 1;
            } else right = mid - 1;
        }
        return ans;
    }

    int lessThanCnt(int num, int m, int n) {
        int maxNum = Math.max(m, n);
        int minNum = Math.min(m, n);
        int ans = 0;
        for (int i = 1; i <= minNum; i++) {
            if (num % i == 0) ans += Math.min(num / i - 1, maxNum);
            else ans += Math.min(num / i, maxNum);
        }
        return ans;
    }
}