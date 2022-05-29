package leetcode.week.j295.j6078;

/**
 * Created by CHENXCHEN
 * 6078. 重排字符形成目标字符串
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int rearrangeCharacters(String s, String target) {
        int[] has = new int[26];
        for (int i = 0; i < s.length(); i++) has[s.charAt(i) - 'a']++;
        int[] hasTarget = new int[26];
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < target.length(); i++) {
            hasTarget[target.charAt(i) - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (hasTarget[i] == 0) continue;
            if (has[i] >= hasTarget[i]) {
                ans = Math.min(ans, has[i] / hasTarget[i]);
            } else {
                ans = 0;
                break;
            }
        }
        return ans;
    }
}