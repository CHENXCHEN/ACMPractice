package leetcode.normal.j1081;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/smallest-subsequence-of-distinct-characters/description/">1081. 不同字符的最小子序列</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public String smallestSubsequence(String s) {
        // 单调栈，每次判断栈顶元素是否可以保留，若大于当前元素并且计数 > 0，就可以删除
        StringBuilder sb = new StringBuilder();
        int[] nums = new int[26];
        int mask = 0;
        for (int i = 0; i < s.length(); i++) nums[s.charAt(i) - 'a']++;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            int pos = ch - 'a';
            if (((mask >> pos) & 1) == 0) {
                while (sb.length() > 0 && sb.charAt(sb.length() - 1) > ch && nums[sb.charAt(sb.length() - 1) - 'a'] > 0) {
                    int topPos = sb.charAt(sb.length() - 1) - 'a';
                    mask ^= 1 << topPos;
                    sb.deleteCharAt(sb.length() - 1);
                }
                sb.append(ch);
                mask |= (1 << pos);
            }
            nums[pos]--;
        }
        return sb.toString();
    }
}