package leetcode.normal.j1802;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/maximum-value-at-a-given-index-in-a-bounded-array/">1802. 有界数组中指定下标处的最大值</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    long n, index, maxSum;

    public int maxValue(int n, int index, int maxSum) {
        this.n = n;
        this.index = index;
        this.maxSum = maxSum;
        long ans = 1, left = 1, right = maxSum;
        while (left <= right) {
            long mid = (left + right) >> 1;
            if (check(mid)) {
                ans = mid;
                left = mid + 1;
            } else right = mid - 1;
        }
        return (int) ans;
    }

    boolean check(long indexMax) {
        // 0 1 2 3 4 5
        // 1 2 3 4 5 6
        long leftCnt = Math.min(index, indexMax - 1), rightCnt = Math.min(n - index - 1, indexMax - 1);
        long tmp = calc(indexMax - 1, leftCnt) + calc(indexMax - 1, rightCnt) + indexMax;
        tmp += index - leftCnt + n - index - 1 - rightCnt;
        return tmp <= maxSum;
    }

    // calc = last + (last - 1) + (last - 2) + ... + (last - cnt + 1)
    long calc(long last, long cnt) {
        return (cnt * ((last << 1) - cnt + 1)) >> 1;
    }
}