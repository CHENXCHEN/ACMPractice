package leetcode.normal.j506;

import java.util.Arrays;

/**
 * Created by CHENXCHEN
 * https://leetcode-cn.com/problems/relative-ranks/
 * 506. 相对名次
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public String[] findRelativeRanks(int[] score) {
        Integer[] idx = new Integer[score.length];
        for (int i = 0; i < score.length; i++) idx[i] = i;
        Arrays.sort(idx, (x, y) -> Integer.compare(score[y], score[x]));
        int[] mpIdx = new int[score.length];
        for (int i = 0; i < idx.length; i++) {
            mpIdx[idx[i]] = i;
        }
        String[] ans = new String[score.length];
        for (int i = 0; i < score.length; i++) {
            if (mpIdx[i] == 0) ans[i] = "Gold Medal";
            else if (mpIdx[i] == 1) ans[i] = "Silver Medal";
            else if (mpIdx[i] == 2) ans[i] = "Bronze Medal";
            else ans[i] = String.valueOf(mpIdx[i] + 1);
        }
        return ans;
    }
}
