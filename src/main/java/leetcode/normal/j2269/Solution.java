package leetcode.normal.j2269;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/find-the-k-beauty-of-a-number/description/">2269. 找到一个数字的 K 美丽值</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int divisorSubstrings(int num, int k) {
        String s = String.valueOf(num);
        StringBuilder sb = new StringBuilder();
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i));
            if (sb.length() > k) sb.deleteCharAt(0);
            int cur = Integer.parseInt(sb.toString());
            if (sb.length() == k && cur != 0 && num % cur == 0) {
                ++ans;
            }
        }
        return ans;
    }
}