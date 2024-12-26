package leetcode.normal.j3083;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/existence-of-a-substring-in-a-string-and-its-reverse/description/">3083. 字符串及其反转中是否存在同一子字符串</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public boolean isSubstringPresent(String s) {
        boolean[] visited = new boolean[26 * 26];
        char[] charArray = s.toCharArray();
        for (int i = 1; i < charArray.length; i++) {
            if (charArray[i] == charArray[i - 1]) return true;
            int cur = (charArray[i - 1] - 'a') * 26 + charArray[i] - 'a';
            int rev = (charArray[i] - 'a') * 26 + charArray[i - 1] - 'a';
            visited[cur] = true;
            if (visited[rev]) return true;
        }
        return false;
    }
}