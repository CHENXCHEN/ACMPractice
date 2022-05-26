package leetcode.normal.j2632;

/**
 * Created by CHENXCHEN
 * https://leetcode.cn/problems/find-closest-lcci/
 * 面试题 17.11. 单词距离
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int findClosest(String[] words, String word1, String word2) {
        int lastIndex1 = -1, lastIndex2 = -1, ans = Integer.MAX_VALUE;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                lastIndex1 = i;
                if (lastIndex2 != -1) ans = Math.min(ans, lastIndex1 - lastIndex2);
            } else if (words[i].equals(word2)) {
                lastIndex2 = i;
                if (lastIndex1 != -1) ans = Math.min(ans, lastIndex2 - lastIndex1);
            }
            if (ans == 1) return ans;
        }
        return ans;
    }
}