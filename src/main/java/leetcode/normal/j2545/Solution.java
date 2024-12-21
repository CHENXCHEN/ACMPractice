package leetcode.normal.j2545;

import java.util.Arrays;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/sort-the-students-by-their-kth-score/description/">2545. 根据第 K 场考试的分数排序</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int[][] sortTheStudents(int[][] score, int k) {
        Arrays.sort(score, (x, y) -> y[k] - x[k]);
        return score;
    }
}