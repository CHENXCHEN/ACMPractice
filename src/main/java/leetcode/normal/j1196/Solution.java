package leetcode.normal.j1196;

import java.util.Arrays;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/how-many-apples-can-you-put-into-the-basket/description/">1196. 最多可以买到的苹果数量</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int maxNumberOfApples(int[] weight) {
        Arrays.sort(weight);
        int ans = 0, total = 0;
        for (int i = 0; i < weight.length; i++) {
            total += weight[i];
            if (total > 5000) break;
            ++ans;
        }
        return ans;
    }
}