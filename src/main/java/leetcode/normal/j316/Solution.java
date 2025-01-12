package leetcode.normal.j316;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/remove-duplicate-letters/description/">316. 去除重复字母</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public String removeDuplicateLetters(String s) {
        // 先计算出每种字符一共有多少个，然后再执行一次单调栈
        int[] cnt = new int[26];
        for (int i = 0; i < s.length(); i++) {
            cnt[s.charAt(i) - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        int useMark = 0;
        // 从左往右开始枚举字符，若当前字符没有被使用，那么判断：
        //  1. 栈非空，且栈顶元素比当前大，且栈顶元素还没用完，那么就去掉栈顶元素，栈顶元素标记为未使用
        //  2. 若1不再满足，把当前元素加到栈顶，标记为使用
        //  3. 不管当前元素是否加入栈顶，当前计数-1
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            int pos = s.charAt(i) - 'a';
            if (((useMark >> pos) & 1) == 0) {
                while (sb.length() > 0 && sb.charAt(sb.length() - 1) > ch && cnt[sb.charAt(sb.length() - 1) - 'a'] > 0) {
                    char last = sb.charAt(sb.length() - 1);
                    useMark ^= 1 << (last - 'a');
                    sb.deleteCharAt(sb.length() - 1);
                }
                useMark |= 1 << pos;
                sb.append(ch);
            }
            --cnt[pos];
        }
        return sb.toString();
    }
}