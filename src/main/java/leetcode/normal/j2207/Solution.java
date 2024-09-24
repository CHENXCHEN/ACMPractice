package leetcode.normal.j2207;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/maximize-number-of-subsequences-in-a-string/description/">2207. 字符串中最多数目的子序列</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public long maximumSubsequenceCount(String text, String pattern) {
        long ans = 0;
        int[] cnt = new int[2];
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == pattern.charAt(1)) {
                ans += cnt[0];
                cnt[1]++;
            }
            if (text.charAt(i) == pattern.charAt(0)) cnt[0]++;
        }
        ans += Math.max(cnt[0], cnt[1]);
        return ans;
    }
}