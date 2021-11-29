package leetcode.normal.j438;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by CHENXCHEN
 * https://leetcode-cn.com/problems/find-all-anagrams-in-a-string/
 * 438. 找到字符串中所有字母异位词
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int[] vis = new int[26];
        int[] pVis = new int[26];
        int n = p.length();
        for (int i = 0; i < n; i++) {
            pVis[p.charAt(i) - 'a']++;
        }
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            vis[s.charAt(i) - 'a']++;
            if (i >= n - 1) {
                if (compareVis(vis, pVis)) {
                    ans.add(i - n + 1);
                }
                vis[s.charAt(i - n + 1) - 'a']--;
            }
        }
        return ans;
    }

    boolean compareVis(int[] vis, int[] pVis) {
        for (int i = 0; i < 26; i++) {
            if (vis[i] != pVis[i]) return false;
        }
        return true;
    }
}