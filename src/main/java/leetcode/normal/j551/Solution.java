package leetcode.normal.j551;

/**
 * Created by CHENXCHEN
 * https://leetcode-cn.com/problems/student-attendance-record-i/
 * 551. 学生出勤记录 I
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public boolean checkRecord(String s) {
        boolean isLate3Day = false;
        for (int i = 1; i < s.length() - 1; i++) {
            if (s.charAt(i - 1) == 'L' && s.charAt(i) == 'L' && s.charAt(i + 1) == 'L') {
                isLate3Day = true;
                break;
            }
        }
        int cntA = 0, cntL = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == 'A') ++cntA;
            else if (ch == 'L') ++cntL;
        }
        return cntA < 2 && !isLate3Day;
    }
}