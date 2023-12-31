package leetcode.normal.j1154;

import java.time.LocalDate;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/day-of-the-year/description/">https://leetcode.cn/problems/day-of-the-year/description/</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int dayOfYear(String date) {
        LocalDate parse = LocalDate.parse(date);
        return parse.getDayOfYear();
    }
}