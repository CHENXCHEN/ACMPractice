package leetcode.normal.j2516;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/take-k-of-each-character-from-left-and-right/description/">2516. 每种字符至少取 K 个</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int takeCharacters(String s, int k) {
        int[] cnt = new int[3];
        int n = s.length();
        for (int i = 0; i < n; i++) {
            cnt[s.charAt(i) - 'a']++;
        }
        if (!isOk(cnt, k)) return -1;
        int ans = n;
        for (int l = 0, r = 0; r < n; r++) {
            cnt[s.charAt(r) - 'a']--;
            while (l < r && !isOk(cnt, k)) {
                cnt[s.charAt(l) - 'a']++;
                l++;
            }
            if (isOk(cnt, k)) {
                ans = Math.min(ans, n - (r - l + 1));
            }
        }
        return ans;
    }

    boolean isOk(int[] cnt, int k) {
        for (int i = 0; i < 3; i++) {
            if (cnt[i] < k) return false;
        }
        return true;
    }
}