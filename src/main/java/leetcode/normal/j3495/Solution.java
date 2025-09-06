package leetcode.normal.j3495;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/minimum-operations-to-make-array-elements-zero/description/">3495. 使数组元素都变为零的最少操作次数</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public long minOperations(int[][] queries) {
        long ans = 0;
        for (int[] query : queries) {
            long n1 = get(query[1]);
            long n2 = get(query[0] - 1);
            // 这次查询的总和为 [1,query[1]] 操作的次数和 - [1, query[0]-1] 操作的次数和，再 向上取整
            ans += (n1 - n2 + 1) / 2;
        }
        return ans;
    }

    // 计算 [1,num] 之间的操作数之和
    long get(int num) {
        long cnt = 0;
        int base = 1, i = 1;
        while (base <= num) {
            int end = Math.min(base * 2 - 1, num);
            // 对于每个二进制长度为 i 的，需要操作 (i + 1) / 2 次才可以变为 0
            cnt += (i + 1L) / 2 * ((long) end - base + 1L);
            i++;
            base *= 2;
        }
        return cnt;
    }
}