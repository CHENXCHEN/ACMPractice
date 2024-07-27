package leetcode.normal.j3106;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/lexicographically-smallest-string-after-operations-with-constraint/description/">3106. 满足距离约束且字典序最小的字符串</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public String getSmallestString(String s, int k) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char lessChar = findLessChar(s.charAt(i), Math.min(k, 25));
            k -= dis(s.charAt(i), lessChar);
            sb.append(lessChar);
        }
        return sb.toString();
    }

    // 在不超过 k 步的情况下，找到最小的字符
    char findLessChar(char ch, int k) {
        char minChar = ch;
        int pos = ch - 'a';
        for (int i = 1; i <= k; i++) {
            char cur = (char) ('a' + Math.min((pos + i) % 26, (pos - i + 26) % 26));
            if (cur < minChar) minChar = cur;
        }
        return minChar;
    }

    // 计算两个字符的距离
    int dis(char a, char b) {
        if (a > b) {
            char tmp = a;
            a = b;
            b = tmp;
        }
        // 两个字符之间的距离为：Min(a -> b, b -> z -> (a + 26))
        return Math.min(b - a, a + 26 - b);
    }
}