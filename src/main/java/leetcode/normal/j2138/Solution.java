package leetcode.normal.j2138;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/divide-a-string-into-groups-of-size-k/description/">2138. 将字符串拆分为若干长度为 k 的组</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public String[] divideString(String s, int k, char fill) {
        int n = s.length(), len = (n + k - 1) / k, tot = 0;
        String[] ans = new String[len];
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i));
            if (sb.length() == k) {
                ans[tot++] = sb.toString();
                sb.setLength(0);
            }
        }
        if (sb.length() > 0) {
            for (int i = sb.length(); i < k; i++) sb.append(fill);
            ans[tot++] = sb.toString();
        }
        return ans;
    }
}