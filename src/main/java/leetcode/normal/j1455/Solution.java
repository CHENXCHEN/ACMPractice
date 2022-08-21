package leetcode.normal.j1455;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/check-if-a-word-occurs-as-a-prefix-of-any-word-in-a-sentence/">1455. 检查单词是否为句中其他单词的前缀</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int isPrefixOfWord(String sentence, String searchWord) {
        String[] splits = sentence.split(" ");
        for (int i = 0; i < splits.length; i++) {
            if (splits[i].startsWith(searchWord)) return i + 1;
        }
        return -1;
    }
}