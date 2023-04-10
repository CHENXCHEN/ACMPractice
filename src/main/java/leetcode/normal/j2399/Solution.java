package leetcode.normal.j2399;

import java.util.Arrays;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/check-distances-between-same-letters/">2399. 检查相同字母间的距离</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public boolean checkDistances(String s, int[] distance) {
        int[] pre = new int[26];
        Arrays.fill(pre, -1);
        for (int i = 0; i < s.length(); i++) {
            int pos = s.charAt(i) - 'a';
            if (pre[pos] != -1) {
                if (i - pre[pos] - 1 != distance[pos]) return false;
            }
            pre[pos] = i;
        }
        return true;
    }
}