package leetcode.normal.j1058;

import java.util.ArrayList;

/**
 * Created by CHENXCHEN
 * https://leetcode.cn/problems/minimize-rounding-error-to-meet-target/
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public String minimizeError(String[] prices, int target) {
        ArrayList<Integer> arr = new ArrayList<>();
        for (String price : prices) {
            String[] split = price.split("\\.");
            int part = Integer.parseInt(split[1]);
            int res = Integer.parseInt(split[0]);
            if (part > 0) arr.add(part);
            target -= res;
        }
        if (arr.size() < target || target < 0) return "-1";
        arr.sort((x, y) -> y - x);
        int ans = 0;
        for (Integer left : arr) {
            if (target > 0) {
                target--;
                ans += 1000 - left;
            } else {
                ans += left;
            }
        }
        int lot = ans % 1000;
        ans /= 1000;
        return String.format("%d.%03d", ans, lot);
    }
}