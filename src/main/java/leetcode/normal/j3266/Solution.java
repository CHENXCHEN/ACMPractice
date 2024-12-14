package leetcode.normal.j3266;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/final-array-state-after-k-multiplication-operations-ii/">3266. K 次乘运算后的最终数组 II</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    int MOD = (int) 1e9 + 7;

    public int[] getFinalState(int[] nums, int k, int multiplier) {
        if (multiplier == 1) return nums;
        int n = nums.length;
        long[] res = new long[n];
        PriorityQueue<Integer> pq = new PriorityQueue<>((x, y) -> res[x] != res[y] ? Long.compare(res[x], res[y]) : Integer.compare(x, y));
        // 关键点在于考虑循环节
        // 我们考虑每次操作的顺序，可知：
        // (0, multi) 范围内的数字依次执行操作
        // [multi, multi^2) 范围内的依次执行
        // [multi^2,multi^3) 范围内的依次执行
        // [multi^(i-1),multi^i) 范围内的依次执行
        // 找出最大的 i 是多少，我们将所有数字都操作到这个范围之后，循环节就是 multi，剩下的可以直接计算出来
        int maxMultiplierCnt = 0;
        for (int i = 0; i < n; i++) {
            res[i] = nums[i];
            maxMultiplierCnt = Math.max(maxMultiplierCnt, getMultiplierCnt(nums[i], multiplier));
            pq.add(i);
        }
        // 在 k 次的范围内，试图将所有的数字都操作到循环圈
        while (!pq.isEmpty() && k > 0) {
            Integer cur = pq.poll();
            // 如果最小的数字已经到达循环圈，我们可以直接跳出
            if (getMultiplierCnt(res[cur], multiplier) == maxMultiplierCnt) {
                pq.add(cur);
                break;
            }
            res[cur] *= multiplier;
            pq.add(cur);
            k--;
        }
//        System.out.println("first, res = " + Arrays.toString(res));
        int[] ans = new int[n];
        if (k == 0) {
            for (int i = 0; i < n; i++) {
                ans[i] = (int) (res[i] % MOD);
            }
            return ans;
        } else {
            // 在长度为 n 的数组，不超过 k 次的情况下，循环节长度为 n，最多可以循环多少次，以及有多少个最小的数字要多操作一次
            // baseCnt * n + leftCnt = k
            int baseCnt = k / n, leftCnt = k % n;
            long baseRes = fastMulti(multiplier, baseCnt);
//            System.out.println("baseCnt = " + baseCnt + " baseRes = " + baseRes + " leftCnt = " + leftCnt + " k = " + k + " n = " + n);
            // 最小的 leftCnt 个数字都操作一次
            while (leftCnt > 0) {
                Integer cur = pq.poll();
                res[cur] = res[cur] * multiplier;
                pq.add(cur);
                leftCnt--;
            }
//            System.out.println("second, res = " + Arrays.toString(res));
            for (int i = 0; i < n; i++) {
                ans[i] = (int) (res[i] % MOD * baseRes % MOD);
            }
//            System.out.println("third, res = " + Arrays.toString(res));
        }
        return ans;
    }

    long fastMulti(long x, int n) {
        // 快速幂计算 x^n
        // 1101(n) -> x^(1 + 4 + 8) -> x^(2^0) * x^(2^2) * x^(2^3)
        long ans = 1;
        while (n > 0) {
            if ((n & 1) == 1) {
                ans = (ans * x) % MOD;
            }
            x = (x * x) % MOD;
            n >>= 1;
        }
        return ans;
    }

    int getMultiplierCnt(long num, int multiplier) {
        int cnt = 0;
        while (num > 0) {
            num /= multiplier;
            ++cnt;
        }
        return cnt;
    }
}