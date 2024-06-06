package leetcode.normal.j2938;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/separate-black-and-white-balls/description/">2938. 区分黑球与白球</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public long minimumSteps(String s) {
        long cnt = 0, ans = 0;
        int n = s.length();
        for (int i = n - 1; i >= 0; i--) {
            cnt += 1 - (s.charAt(i) - '0');
            if (s.charAt(i) == '1' && cnt > 0) {
                ans += cnt;
            }
        }
        return ans;
    }
}