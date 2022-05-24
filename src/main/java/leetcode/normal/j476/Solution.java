package leetcode.normal.j476;

import java.util.Arrays;

/**
 * Created by CHENXCHEN
 * https://leetcode.cn/problems/unique-substrings-in-wraparound-string/
 * 467. 环绕字符串中唯一的子字符串
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int findSubstringInWraproundString(String p) {
        int[] dp = new int[26];
        int now = 0, pre = 0;
        for (int i = 0, cnt = 0; i < p.length(); i++) {
            now = p.charAt(i) - 'a';
            if (i > 0 && (now - pre + 26) % 26 == 1) cnt++;
            else cnt = 1;
            dp[now] = Math.max(dp[now], cnt);
            pre = now;
        }
        return Arrays.stream(dp).sum();
    }
}