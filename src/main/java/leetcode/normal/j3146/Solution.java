package leetcode.normal.j3146;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/permutation-difference-between-two-strings/description/">https://leetcode.cn/problems/permutation-difference-between-two-strings/description/</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int findPermutationDifference(String s, String t) {
        int[] pos = new int[26];
        for (int i = 0; i < s.length(); i++) {
            pos[s.charAt(i) - 'a'] = i;
        }
        int ans = 0;
        for (int i = 0; i < t.length(); i++) {
            ans += Math.abs(pos[t.charAt(i) - 'a'] - i);
        }
        return ans;
    }
}