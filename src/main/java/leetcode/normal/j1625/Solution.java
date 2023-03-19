package leetcode.normal.j1625;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/lexicographically-smallest-string-after-applying-operations/">1625. 执行操作后字典序最小的字符串</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public String findLexSmallestString(String s, int a, int b) {
        int n = s.length(), kLimit = (b & 1) == 1 ? 10 : 1;
        boolean[] vis = new boolean[n];
        // 拼接自己，方便处理轮转
        s = s + s;
        String ans = s;
        // 枚举轮转后开始的下标，最多不超过 n 次
        for (int i = 0; !vis[i]; i = (i + b) % n) {
            vis[i] = true;
            // 枚举对奇数部分进行累加的轮数，因为每一位都是 [0,9]，所以 9 次以内必定会产生循环
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k < kLimit; k++) {
                    char[] chars = s.substring(i, i + n).toCharArray();
                    for (int p = 1; p < n; p += 2) {
                        chars[p] = (char) ('0' + (chars[p] - '0' + a * j) % 10);
                    }
                    for (int p = 0; p < n; p += 2) {
                        chars[p] = (char) ('0' + (chars[p] - '0' + a * k) % 10);
                    }
                    String tmp = new String(chars);
                    if (tmp.compareTo(ans) < 0) ans = tmp;
                }
            }
        }
        return ans;
    }
}