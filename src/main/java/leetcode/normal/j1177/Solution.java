package leetcode.normal.j1177;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/can-make-palindrome-from-substring/">1177. 构建回文串检测</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
        int[][] preSum = new int[s.length() + 1][26];
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < 26; j++) {
                preSum[i + 1][j] = preSum[i][j];
            }
            int pos = s.charAt(i) - 'a';
            preSum[i + 1][pos] = preSum[i][pos] + 1;
        }
        List<Boolean> ans = new ArrayList<>();
        for (int[] query : queries) {
            int left = query[0], right = query[1], k = query[2];
            int oddCnt = 0;
            for (int i = 0; i < 26; i++) {
                int cnt = preSum[right + 1][i] - preSum[left][i];
                if ((cnt & 1) == 1) {
                    ++oddCnt;
                }
            }
            // 替换 k 次之后，可以保证最少长度 2 * k + 1 的字符串成为回文串
            ans.add(oddCnt <= (k << 1) + 1);
        }
        return ans;
    }
}