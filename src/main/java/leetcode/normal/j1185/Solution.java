package leetcode.normal.j1185;


import java.time.DayOfWeek;
import java.time.LocalDate;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/day-of-the-week/description/">1185. 一周中的第几天</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public String dayOfTheWeek(int day, int month, int year) {
        LocalDate dt = LocalDate.of(year, month, day);
        DayOfWeek dayOfWeek = dt.getDayOfWeek();
        StringBuilder sb = new StringBuilder(dayOfWeek.toString().toLowerCase());
        sb.setCharAt(0, Character.toUpperCase(sb.charAt(0)));
        return sb.toString();
    }
}