package leetcode.normal.j2434;

import java.util.ArrayDeque;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/using-a-robot-to-print-the-lexicographically-smallest-string/description/">2434. 使用机器人打印字典序最小的字符串</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public String robotWithString(String s) {
        int[] cnt = new int[26];
        for (char c : s.toCharArray()) {
            cnt[c - 'a']++;
        }
        ArrayDeque<Character> deque = new ArrayDeque<>();
        StringBuffer ans = new StringBuffer();
        char minChar = 'a';
        for (int i = 0; i < s.length(); i++) {
            deque.push(s.charAt(i));
            cnt[s.charAt(i) - 'a']--;
            while (minChar != 'z' && cnt[minChar - 'a'] == 0) {
                minChar++;
            }
            while (!deque.isEmpty() && deque.peek() <= minChar) {
                ans.append(deque.pop());
            }
        }
        return ans.toString();
    }
}