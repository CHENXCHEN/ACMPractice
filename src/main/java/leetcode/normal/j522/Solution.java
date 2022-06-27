package leetcode.normal.j522;

/**
 * Created by CHENXCHEN
 * https://leetcode.cn/problems/longest-uncommon-subsequence-ii/
 * 522. 最长特殊序列 II
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int findLUSlength(String[] strs) {
        boolean[] isSubSeq = new boolean[strs.length];
        int n = strs.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j && !isSubSeq[j] && checkSubSeq(strs[i], strs[j])) {
                    isSubSeq[j] = true;
                }
            }
        }
        int ans = -1;
        for (int i = 0; i < n; i++) {
            if (!isSubSeq[i]) ans = Math.max(ans, strs[i].length());
        }
        return ans;
    }

    boolean checkSubSeq(String str1, String str2) {
        if (str1.length() < str2.length()) return false;
        int pos1 = 0, pos2 = 0;
        while (pos1 < str1.length() && pos2 < str2.length()) {
            while (pos1 < str1.length() && str1.charAt(pos1) != str2.charAt(pos2)) pos1++;
            if (pos1 < str1.length()) {
                pos1++;
                pos2++;
            }
        }
        return pos2 == str2.length();
    }
}