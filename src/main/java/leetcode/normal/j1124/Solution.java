package leetcode.normal.j1124;

import java.util.ArrayDeque;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/longest-well-performing-interval/">1124. 表现良好的最长时间段</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int longestWPI(int[] hours) {
        // 替换数组中的元素，如果 hours[i] > 8，则为 1，如果 hours[i] <= 8，则为 -1，我们可以转化为数组 a
        // 那么良好表现的一天为：求数组 a 的区间和 > 0 的最大长度是多少
        // 我们可以转化为前缀和来简化求解，假定 s[i] 为 a[0] + ... + a[i-1]
        // 那么我们如果要求数组 a 的 [i,j] 区间内元素和则为：s[j+1] - s[i]，而我们需要 s[j+1] - s[i] > 0
        // 我们可以枚举右端点 j，假定 j 已经固定，那么 s[i] 自然是越小越好，这样可以使得式子更接近 > 0 的目的
        // 对于 i1 < i2，若 s[i1] < s[i2]，那么我们没有必要去选择 i2
        // 因此我们可以使用单调队列去维护 s 数组中 j+1 左边的，s[i] 递减的下标 i (因为后面大于它自己的都没有必要去选择)
        int[] s = new int[hours.length + 1];
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        deque.push(0);
        for (int i = 1; i <= hours.length; i++) {
            s[i] = s[i - 1] + (hours[i - 1] > 8 ? 1 : -1);
            if (s[deque.peek()] > s[i]) {
                deque.push(i);
            }
        }
        int ans = 0;
        // 对于给定的 r，我们求 r 左边的 l，使得 s[r] - s[l] > 0，求 max(r - l)
        // 如果 l 满足 s[r] - s[l] > 0，那么我们就出栈 l，但是此时 s[l] 可能对下标 r 右边的元素有贡献，
        // 因此我们从右边往左边枚举，这样就可以消除后效性了
        for (int r = hours.length; r >= 1; r--) {
            while (!deque.isEmpty() && s[deque.peek()] < s[r]) {
                ans = Math.max(ans, r - deque.pop());
            }
        }
        return ans;
    }
}