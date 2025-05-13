package leetcode.normal.j3335;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/total-characters-in-string-after-transformations-i/description/">3335. 字符串转换后的长度 I</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    private static final int MOD = 1000000007;

    public int lengthAfterTransformations(String s, int t) {
        // 表示当操作一次之后，字符 cnt[i] 的数量是多少
        int[] cnt = new int[26];
        for (char c : s.toCharArray()) {
            cnt[c - 'a']++;
        }
        for (int i = 0; i < t; i++) {
            int[] nxt = new int[26];
            // 操作 1 次之后，z 会变为 ab
            nxt[0] = cnt[25];
            nxt[1] = (cnt[0] + cnt[25]) % MOD;
            for (int j = 2; j < 26; j++) {
                nxt[j] = cnt[j - 1];
            }
            cnt = nxt;
        }
        int ans = 0;
        for (int i = 0; i < 26; i++) {
            ans = (ans + cnt[i]) % MOD;
        }
        return ans;
    }
}