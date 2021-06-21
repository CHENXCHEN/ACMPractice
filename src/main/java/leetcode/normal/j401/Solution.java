package leetcode.normal.j401;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by CHENXCHEN
 * https://leetcode-cn.com/problems/binary-watch/
 * 401. 二进制手表
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
public class Solution {
    public List<String> readBinaryWatch(int turnedOn) {
        ArrayList<String> ans = new ArrayList<>();
        for (int hour = 0; hour <= 11; hour++) {
            for (int minute = 0; minute <= 59; minute++) {
                if (Integer.bitCount(hour) + Integer.bitCount(minute) == turnedOn) {
                    ans.add(String.format("%d:%02d", hour, minute));
                }
            }
        }
        return ans;
    }
}
