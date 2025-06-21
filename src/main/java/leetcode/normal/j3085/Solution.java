package leetcode.normal.j3085;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/minimum-deletions-to-make-string-k-special/description/">3085. 成为 K 特殊字符串需要删除的最少字符数</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int minimumDeletions(String word, int k) {
        int[] cnt = new int[26];
        for (int i = 0; i < word.length(); i++) {
            cnt[word.charAt(i) - 'a']++;
        }
        int ans = word.length() - 1;
        for (int i = 0; i < 26; i++) {
            if (cnt[i] > 0) {
                // 如果要保留的字符中出现的最小次数为 cnt[i]，那么计算其他字符需要剔除的个数
                int cur = 0;
                for (int j = 0; j < 26; j++) {
                    if (i == j) continue;
                    if (cnt[j] < cnt[i]) {
                        cur += cnt[j];
                    } else {
                        int diff = cnt[j] - cnt[i];
                        if (diff > k) {
                            cur += diff - k;
                        }
                    }
                }
                ans = Math.min(ans, cur);
            }
        }
        return ans;
    }
}