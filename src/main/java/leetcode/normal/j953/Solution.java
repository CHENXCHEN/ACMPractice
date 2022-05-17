package leetcode.normal.j953;

/**
 * Created by CHENXCHEN
 * https://leetcode.cn/problems/verifying-an-alien-dictionary/
 * 953. 验证外星语词典
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int[] oNum = new int[26];
        for (int i = 0; i < order.length(); i++) {
            oNum[order.charAt(i) - 'a'] = i;
        }
        for (int i = 1; i < words.length; i++) {
//            System.out.println(words[i - 1] + " " + words[i] + " ans: " + isLessThanOrEqual(words[i - 1], words[i], oNum));
            if (!isLessThanOrEqual(words[i - 1], words[i], oNum)) return false;
        }
        return true;
    }

    boolean isLessThanOrEqual(String word1, String word2, int[] oNum) {
        int i = 0;
        while (i < word1.length() && i < word2.length() && word1.charAt(i) == word2.charAt(i))
            i++;
//        System.out.println("find pos: " + i);
        if (i == word1.length() && i == word2.length()) return true;
        else if (i == word1.length()) return true;
        else if (i == word2.length()) return false;
        else return oNum[word1.charAt(i) - 'a'] <= oNum[word2.charAt(i) - 'a'];
    }
}