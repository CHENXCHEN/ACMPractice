package leetcode.normal.j2287;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/rearrange-characters-to-make-target-string/">2287. 重排字符形成目标字符串</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int rearrangeCharacters(String s, String target) {
        int[] vis = new int[26], tVis = new int[26];
        for (int i = 0; i < s.length(); i++)
            vis[s.charAt(i) - 'a']++;
        for (int i = 0; i < target.length(); i++)
            tVis[target.charAt(i) - 'a']++;
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < 26; i++) {
            if (tVis[i] > 0) {
                ans = Math.min(ans, vis[i] / tVis[i]);
            }
        }
        return ans;
    }
}