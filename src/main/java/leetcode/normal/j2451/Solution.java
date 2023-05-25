package leetcode.normal.j2451;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/odd-string-difference/">2451. 差值数组不同的字符串</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public String oddString(String[] words) {
        int[] res0 = generate(words[0]), res1 = generate(words[1]);
        if (isSame(res0, res1)) {
            for (int i = 2; i < words.length; i++) {
                if (!isSame(res0, generate(words[i]))) return words[i];
            }
            return null;
        } else {
            if (isSame(res0, generate(words[2]))) {
                return words[1];
            } else {
                return words[0];
            }
        }
    }

    int[] generate(String word) {
        int[] res = new int[word.length() - 1];
        for (int i = 0; i < word.length() - 1; i++) res[i] = word.charAt(i + 1) - word.charAt(i);
        return res;
    }

    boolean isSame(int[] ori, int[] target) {
        int n = ori.length;
        for (int i = 0; i < n; i++) {
            if (ori[i] != target[i]) return false;
        }
        return true;
    }
}