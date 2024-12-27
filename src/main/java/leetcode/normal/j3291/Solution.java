package leetcode.normal.j3291;

import java.util.Arrays;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/minimum-number-of-valid-strings-to-form-target-i/description/">3291. 形成目标字符串需要的最少字符串数 I</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int minValidStrings(String[] words, String target) {
        int n = target.length();
        // back[i] 表示对于 target[0...i] 的后缀，在 words 中能匹配到的最长前缀
        int[] back = new int[n];
        for (String word : words) {
            int[] next = getNext(word + "#" + target);
            int m = word.length();
            for (int i = 0; i < n; i++) {
                back[i] = Math.max(back[i], next[i + m + 1]);
            }
        }
        // dp[i] 表示组成 target[0...i-1] 的最小前缀字符串数
        int[] dp = new int[n + 1];
        Arrays.fill(dp, 1, n + 1, n + 1);
        for (int i = 0; i < n; i++) {
            dp[i + 1] = dp[i + 1 - back[i]] + 1;
            if (dp[i + 1] > n) return -1;
        }
        return dp[n];
    }

    int[] getNext(String str) {
        int n = str.length();
        // next[i] 表示到 [0...i]，有长度为 next[i] 的前缀和长度为 next[i] 的后缀字符串相等
        int[] next = new int[n];
        // j 表示 [0...i-1] 有长度为 j 的前缀和后缀相等
        for (int i = 1, j = 0; i < n; i++) {
            // 因为上一次处理，我们得到了 s[0...i-1] 有长度为 j 的真前缀和真后缀相等
            // 所以这次判断 s[0...i] 长度为 j+1 的前缀和后缀是否相等
            // 如果不相等，则找到与 s[0...i-1] 真后缀相等的其他真前缀
            // 因为我们已知 s(0,j-1) = s(i-(j-2),i-1)，若 s(0,j) != s(i-(j-1),i)
            // 那么我们需要找到其他长度小于 j 的以 s[i-1] 结尾的真后缀，与真前缀相等
            // 而下一个长度小于 j 的，以 s[i-1] 结尾的真后缀与真前缀的长度，是 next[j-1]
            while (j > 0 && str.charAt(i) != str.charAt(j)) j = next[j - 1];
            if (str.charAt(i) == str.charAt(j)) ++j;
            next[i] = j;
        }
        return next;
    }
}