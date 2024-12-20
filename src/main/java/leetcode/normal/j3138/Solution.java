package leetcode.normal.j3138;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/minimum-length-of-anagram-concatenation/description/">3138. 同位字符串连接的最小长度</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int minAnagramLength(String s) {
        int n = s.length();
        int[][] preSum = new int[n + 1][26];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 26; j++) {
                preSum[i + 1][j] = preSum[i][j];
            }
            preSum[i + 1][s.charAt(i) - 'a']++;
        }
        int comm = -1;
        for (int i = 0; i < 26; i++) {
            if (preSum[n][i] > 0) {
                if (comm == -1) comm = preSum[n][i];
                else comm = gcd(preSum[n][i], comm);
            }
        }
        // 组成字符串 t 的最小长度，最终结果的长度一定这个长度的倍数
        int baseLen = 0;
        for (int i = 0; i < 26; i++) {
            if (preSum[n][i] > 0)
                baseLen += preSum[n][i] / comm;
        }
        // 字符串 t 的长度一定是 n 的因数
        for (int i = baseLen; i <= n / 2; i += baseLen) {
            if (valid(preSum, i)) return i;
        }
        return n;
    }

    boolean valid(int[][] preSum, int len) {
        for (int i = len + len; i < preSum.length; i += len) {
            for (int j = 0; j < 26; j++) {
                if (preSum[i][j] > 0 && preSum[len][j] == 0) {
                    return false;
                }
                if (preSum[len][j] > 0 && preSum[i][j] - preSum[i - len][j] != preSum[len][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}