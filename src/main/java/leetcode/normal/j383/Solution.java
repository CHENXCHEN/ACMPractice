package leetcode.normal.j383;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/ransom-note/description/">383. 赎金信</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] vis = new int[26];
        for (int i = 0; i < ransomNote.length(); i++) vis[ransomNote.charAt(i) - 'a']--;
        for (int i = 0; i < magazine.length(); i++) vis[magazine.charAt(i) - 'a']++;
        for (int i = 0; i < 26; i++) {
            if (vis[i] < 0) return false;
        }
        return true;
    }
}