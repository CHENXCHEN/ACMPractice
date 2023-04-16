package leetcode.normal.j2409;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/count-days-spent-together/">2409. 统计共同度过的日子数</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    int[] monthDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        String arriveMax = arriveAlice, leaveMin = leaveAlice;
        if (arriveAlice.compareTo(arriveBob) < 0) arriveMax = arriveBob;
        if (leaveAlice.compareTo(leaveBob) > 0) leaveMin = leaveBob;
        int arriveDays = getDays(arriveMax), leaveDays = getDays(leaveMin);
        return Math.max(leaveDays - arriveDays + 1, 0);
    }

    int getDays(String monthDay) {
        String[] split = monthDay.split("-");
        int monthNum = Integer.parseInt(split[0]), dayNum = Integer.parseInt(split[1]);
        int ans = dayNum;
        for (int i = 0; i < monthNum - 1; i++) {
            ans += monthDays[i];
        }
        return ans;
    }
}