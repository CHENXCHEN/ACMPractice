package leetcode.normal.j1668;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/maximum-repeating-substring/">1668. 最大重复子字符串</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    String sequence, word;

    public int maxRepeating(String sequence, String word) {
        this.sequence = sequence;
        this.word = word;
        int ans = 0;
        for (int i = 0; i < sequence.length(); i++) {
            ans = Math.max(ans, check(i));
        }
        return ans;
    }

    int check(int sPos) {
        int ans = 0, i = 0;
        while (sPos < sequence.length()) {
            if (sequence.charAt(sPos) != word.charAt(i)) {
                break;
            }
            if (++i == word.length()) {
                i = 0;
                ans++;
            }
            ++sPos;
        }
        return ans;
    }
}