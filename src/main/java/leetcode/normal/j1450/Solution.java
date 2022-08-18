package leetcode.normal.j1450;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/number-of-students-doing-homework-at-a-given-time/">1450. 在既定时间做作业的学生人数</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int ans = 0;
        for (int i = 0; i < startTime.length; i++) {
            if (startTime[i] <= queryTime && queryTime <= endTime[i]) ans++;
        }
        return ans;
    }
}