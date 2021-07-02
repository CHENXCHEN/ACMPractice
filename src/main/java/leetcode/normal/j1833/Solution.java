package leetcode.normal.j1833;

import java.util.Arrays;

/**
 * Created by CHENXCHEN
 * 1833. 雪糕的最大数量
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
public class Solution {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int sum = 0;
        int ans = 0;
        for(int cost: costs) {
            if (sum + cost <= coins) {
                sum += cost;
                ++ans;
            } else break;
        }
        return ans;
    }
}
