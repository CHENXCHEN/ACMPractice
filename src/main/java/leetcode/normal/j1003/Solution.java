package leetcode.normal.j1003;

import java.util.ArrayDeque;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/check-if-word-is-valid-after-substitutions/">1003. 检查替换后的词是否有效</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public boolean isValid(String s) {
        ArrayDeque<Character> deque = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == 'c') {
                boolean check = deque.size() >= 2 && deque.poll() == 'b' && deque.poll() == 'a';
                if (!check) return false;
            } else deque.push(ch);
        }
        return deque.size() == 0;
    }
}