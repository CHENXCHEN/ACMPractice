package leetcode.normal.j1832;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/check-if-the-sentence-is-pangram/">1832. 判断句子是否为全字母句</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public boolean checkIfPangram(String sentence) {
        int check = 0, flat = (1 << 26) - 1;
        for (int i = 0; i < sentence.length(); i++) {
            check |= (1 << (sentence.charAt(i) - 'a'));
        }
        return check == flat;
    }
}