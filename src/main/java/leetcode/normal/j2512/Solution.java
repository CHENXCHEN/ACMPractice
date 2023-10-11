package leetcode.normal.j2512;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/reward-top-k-students/description/">2512. 奖励最顶尖的 K 名学生</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public List<Integer> topStudents(String[] positive_feedback, String[] negative_feedback, String[] report, int[] student_id, int k) {
        HashSet<String> positiveSet = new HashSet<>(Arrays.asList(positive_feedback));
        HashSet<String> negativeSet = new HashSet<>(Arrays.asList(negative_feedback));
        int n = report.length;
        int[] scores = new int[n];
        for (int i = 0; i < n; i++) {
            String[] words = report[i].split(" ");
            int curScore = 0;
            for (String word : words) {
                if (positiveSet.contains(word)) curScore += 3;
                else if (negativeSet.contains(word)) curScore -= 1;
            }
            scores[i] = curScore;
        }
        Integer[] pos = new Integer[n];
        for (int i = 0; i < n; i++) pos[i] = i;
        Arrays.sort(pos, (x, y) -> scores[x] != scores[y] ? Integer.compare(scores[y], scores[x]) : Integer.compare(student_id[x], student_id[y]));
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < k; i++) ans.add(student_id[pos[i]]);
        return ans;
    }
}