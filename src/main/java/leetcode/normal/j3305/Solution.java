package leetcode.normal.j3305;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/count-of-substrings-containing-every-vowel-and-k-consonants-i/description/">3305. 元音辅音字符串计数 I</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int countOfSubstrings(String word, int k) {
        String cs = "aeiou";
        int ans = 0, target = (1 << 5) - 1;
        for (int i = 0; i < word.length(); i++) {
            int mask = 0, cnt = 0;
            for (int j = i; j < word.length(); j++) {
                int idx = cs.indexOf(word.charAt(j));
                if (idx != -1) {
                    mask |= 1 << idx;
                } else {
                    ++cnt;
                    if (cnt > k) break;
                }
                if (cnt == k && mask == target) ++ans;
            }
        }
        return ans;
    }
}