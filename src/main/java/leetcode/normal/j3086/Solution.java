package leetcode.normal.j3086;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/minimum-moves-to-pick-k-ones/description/">3086. 拾起 K 个 1 需要的最少行动次数</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {

    long[] indexSum, valueSum;
    int[] nums;
    int n;

    public long minimumMoves(int[] nums, int k, int maxChanges) {
        this.n = nums.length;
        this.nums = nums;
        indexSum = new long[n + 1];
        valueSum = new long[n + 1];
        for (int i = 0; i < n; i++) {
            indexSum[i + 1] = indexSum[i] + (long) nums[i] * i;
            valueSum[i + 1] = valueSum[i] + nums[i];
        }
        long ans = Long.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            long d1Sum = calcValueSum(i - 1, i + 1);
            if (d1Sum + maxChanges >= k) {
                // 如果 d1Sum >=k，那么应该是
                // 需要使用 maxChanges 的操作步数 + 以1为半径的操作数
                // 2 * (k - num[i] - (d1Sum - num[i)) + d1Sum - num[i]
                // => 2k - 2num[i] - 2(d1Sum - num[i]) + d1Sum - num[i]
                // => 2k - 2num[i] - d1Sum + num[i]
                // => 2k - d1Sum - num[i]
                if (k <= d1Sum) ans = Math.min(ans, k - nums[i]);
                else ans = Math.min(ans, 2L * k - d1Sum - nums[i]);
            } else {
                int left = 0, right = n;
                // 二分以 i 为原点的半径，能够满足条件的最小半径
                while (left <= right) {
                    int mid = (left + right) >> 1;
                    long dxSum = calcValueSum(i - mid, i + mid);
                    if (dxSum + maxChanges >= k) {
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                }
                long dxSum = calcValueSum(i - left, i + left);
                int ll = Math.max(i - left, 0), rr = Math.min(i + left, n - 1);
                if (dxSum > k - maxChanges) {
                    ll++;
                }
                // 在这种情况下，应该是：i 右边的操作数 + i 左边的操作数 + 2 * maxChanges
                // 有一个需要考虑的点是 i 本身的 nums[i]，如果是 1 的话是否影响
                // 因为 i 左边的操作数等于 i - x1 + i - x2 + ... + i - xm，当 num[x] = 1
                // 所以，当 x = i 时，不影响其最终结果，因此式子可以整合成：i * len(x) - (x1 + .. + xm)
                ans = Math.min(ans,
                        indexSum[rr + 1] - indexSum[i + 1] - (long) i * (valueSum[rr + 1] - valueSum[i + 1])
                                + (long) i * (valueSum[i + 1] - valueSum[ll]) - (indexSum[i + 1] - indexSum[ll])
                                + 2L * maxChanges
                );
            }
        }
        return ans;
    }

    long calcIndexSum(int left, int right) {
        if (left < 0) left = 0;
        if (right >= n) right = n - 1;
        return indexSum[right + 1] - indexSum[left];
    }

    long calcValueSum(int left, int right) {
        if (left < 0) left = 0;
        if (right >= n) right = n - 1;
        return valueSum[right + 1] - valueSum[left];
    }
}