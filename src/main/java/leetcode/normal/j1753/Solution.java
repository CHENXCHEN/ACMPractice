package leetcode.normal.j1753;

import java.util.Arrays;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/maximum-score-from-removing-stones/">1753. 移除石子的最大得分</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int maximumScore(int a, int b, int c) {
        int[] arr = {a, b, c};
        Arrays.sort(arr);
        int first = Math.min(arr[0], arr[2] - arr[1]);
        if (arr[0] == first) return first + arr[1];
        else {
            int diff = arr[0] - first;
            return first + (diff >> 1 << 1) + (arr[1] - (diff >> 1));
        }
    }
}