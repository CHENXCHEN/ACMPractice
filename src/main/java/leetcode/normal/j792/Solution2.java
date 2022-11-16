package leetcode.normal.j792;

import java.util.ArrayDeque;
import java.util.Arrays;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/number-of-matching-subsequences/">792. 匹配子序列的单词数</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution2 {
    public int numMatchingSubseq(String s, String[] words) {
        ArrayDeque<int[]>[] deque = new ArrayDeque[26];
        Arrays.setAll(deque, i -> new ArrayDeque<>());
        for (int i = 0; i < words.length; i++) {
            deque[words[i].charAt(0) - 'a'].add(new int[]{i, 0});
        }
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            int ch = s.charAt(i) - 'a';
            int cnt = deque[ch].size();
            while (cnt > 0) {
                int[] cur = deque[ch].poll();
                if (cur[1] == words[cur[0]].length() - 1) ans++;
                else {
                    ++cur[1];
                    deque[words[cur[0]].charAt(cur[1]) - 'a'].addLast(cur);
                }
                --cnt;
            }
        }
        return ans;
    }
}