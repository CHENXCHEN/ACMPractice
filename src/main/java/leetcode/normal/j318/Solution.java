package leetcode.normal.j318;

/**
 * Created by CHENXCHEN
 * https://leetcode-cn.com/problems/maximum-product-of-word-lengths/
 * 318. 最大单词长度乘积
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int maxProduct(String[] words) {
        int[] wordBitMap = new int[words.length];
        for (int j = 0; j < words.length; j++) {
            int bitMap = 0;
            String word = words[j];
            for (int i = 0; i < word.length(); i++) {
                bitMap |= (1 << (word.charAt(i) - 'a'));
            }
            wordBitMap[j] = bitMap;
        }
        int ans = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if ((wordBitMap[i] & wordBitMap[j]) == 0) {
                    ans = Math.max(ans, words[i].length() * words[j].length());
                }
            }
        }
        return ans;
    }
}