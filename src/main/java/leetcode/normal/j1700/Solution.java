package leetcode.normal.j1700;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/number-of-students-unable-to-eat-lunch/">1700. 无法吃午餐的学生数量</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int[] cnt = new int[2];
        for (int s : students) {
            ++cnt[s];
        }
        for (int cur : sandwiches) {
            if (cnt[cur] > 0) --cnt[cur];
            else break;
        }
        return cnt[0] + cnt[1];
    }
}