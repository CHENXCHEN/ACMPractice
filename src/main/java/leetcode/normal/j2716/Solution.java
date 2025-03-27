package leetcode.normal.j2716;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/minimize-string-length/description/">2716. 最小化字符串长度</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int minimizedStringLength(String s) {
        int ans = 0;
        boolean[] visited = new boolean[26];
        for (int i = 0; i < s.length(); i++) {
            int num = s.charAt(i) - 'a';
            if (!visited[num]) {
                ++ans;
                visited[num] = true;
            }
        }
        return ans;
    }
}