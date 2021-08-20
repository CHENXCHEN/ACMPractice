package leetcode.normal.j443;

/**
 * Created by CHENXCHEN
 * https://leetcode-cn.com/problems/string-compression/
 * 443. 压缩字符串
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int compress(char[] chars) {
        int ans = 0;
        for (int i = 0; i < chars.length; ) {
            char ch = chars[i];
            int j = i;
            while (j < chars.length && chars[j] == ch) j++;
            int cnt = j - i;
            chars[ans++] = ch;
            if (cnt > 1) {
                char[] cntChars = String.valueOf(cnt).toCharArray();
                for (char cntChar : cntChars) chars[ans++] = cntChar;
            }
            i = j;
        }
        return ans;
    }
}