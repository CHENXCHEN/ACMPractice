package leetcode.normal.j2901;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/longest-unequal-adjacent-groups-subsequence-ii/description/">2901. 最长相邻不相等子序列 II</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public List<String> getWordsInLongestSubsequence(String[] words, int[] groups) {
        int n = words.length;
        int[] dp = new int[n];
        int[] pre = new int[n];
        Arrays.fill(pre, -1);
        int maxIdx = 0;
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (groups[j] != groups[i] && check(words[j], words[i]) && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                    pre[i] = j;
                }
            }
            if (dp[i] > dp[maxIdx]) maxIdx = i;
        }
        ArrayList<String> res = new ArrayList<>();
        int curIdx = maxIdx;
        while (curIdx != -1) {
            res.add(words[curIdx]);
            curIdx = pre[curIdx];
        }
        ArrayList<String> ans = new ArrayList<>();
        for (int i = 0,j = res.size() - 1; i < res.size(); i++,j--) {
            ans.add(res.get(j));
        }
        return ans;
    }

    boolean check(String w1, String w2) {
        if (w1.length() != w2.length()) return false;
        int len = w1.length();
        int diff = 0;
        for (int i = 0; i < len; i++) {
            if (w1.charAt(i) != w2.charAt(i)) diff++;
        }
        return diff == 1;
    }
}