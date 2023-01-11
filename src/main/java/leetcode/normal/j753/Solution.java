package leetcode.normal.j753;

import java.util.Arrays;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/cracking-the-safe/description/">753. 破解保险箱</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public String crackSafe(int n, int k) {
        // 所有长度为 n - 1 的情况列出来，一共有 k^(n-1) 种
        // 每种都作为一个节点，对于在 n=3,k=3 的情况中， 00 后可以接 0/1/2 这三种情况，接了之后，抛弃第一位，可以到达下一个节点
        // 如：00 -> 00, 00 -> 01, 00 -> 02
        // 那么对于 k^(n-1) 的每一个节点，都有 k 条边，可以直接走到下一个节点
        // 那么问题就转换为，对于这个图，恰好走完所有边的情况，就是求欧拉图了
        // 这里有一种贪心优化思路，每次都从编号最大的点走，从 00 开始走，一定可以恰好走完所有边
        int nodeNum = (int) Math.pow(k, n - 1), edgeNum = nodeNum * k, node = 0;
        int[] num = new int[nodeNum];
        Arrays.fill(num, k - 1);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n - 1; i++) sb.append('0');
        int tot = edgeNum + n - 1;
        for (int i = n - 1; i < tot; i++) {
            sb.append((char) (num[node]-- + '0'));
            node = node * k - (sb.charAt(i - n + 1) - '0') * nodeNum + num[node] + 1;
        }
        return sb.toString();
    }
}