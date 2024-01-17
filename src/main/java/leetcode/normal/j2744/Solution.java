package leetcode.normal.j2744;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/find-maximum-number-of-string-pairs/description/">2744. 最大字符串配对数目</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int maximumNumberOfStringPairs(String[] words) {
        int ans = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                String reverse = new StringBuffer(words[j]).reverse().toString();
                if (words[i].equals(reverse)) {
                    ++ans;
                }
            }
        }
        return ans;
    }
}