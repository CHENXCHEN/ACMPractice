package leetcode.normal.j1304;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/find-n-unique-integers-sum-up-to-zero/description/">1304. 和为零的 N 个不同整数</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int[] sumZero(int n) {
        int[] result = new int[n];
        int start = 1, i = 0;
        if (n % 2 == 1) {
            result[0] = 0;
            i = 1;
        }
        while (i < n) {
            result[i] = start;
            result[i + 1] = -start;
            start++;
            i += 2;
        }
        return result;
    }
}