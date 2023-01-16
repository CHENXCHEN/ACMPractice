package leetcode.normal.j1813;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/sentence-similarity-iii/">1813. 句子相似性 III</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        String[] s1 = sentence1.split(" ");
        String[] s2 = sentence2.split(" ");
        int pos1 = 0, pos2 = 0;
        while (pos1 < s1.length && pos2 < s2.length && s1[pos1].equals(s2[pos2])) {
            pos1++;
            pos2++;
        }
        if (pos1 == s1.length || pos2 == s2.length) return true;
        int pos3 = s1.length - 1, pos4 = s2.length - 1;
        while (pos3 >= pos1 && pos4 >= pos2 && s1[pos3].equals(s2[pos4])) {
            pos3--;
            pos4--;
        }
        return pos3 < pos1 || pos4 < pos2;
    }
}