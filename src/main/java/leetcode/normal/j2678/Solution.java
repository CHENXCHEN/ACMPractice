package leetcode.normal.j2678;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/number-of-senior-citizens/description/">2678. 老人的数目</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int countSeniors(String[] details) {
        int ans = 0;
        for (String detail : details) {
            int old = (detail.charAt(11) - '0') * 10 + (detail.charAt(12) - '0');
            if (old > 60) ++ ans;
        }
        return ans;
    }
}