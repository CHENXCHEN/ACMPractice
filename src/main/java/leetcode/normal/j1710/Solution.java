package leetcode.normal.j1710;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/maximum-units-on-a-truck/">1710. 卡车上的最大单元数..</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, Comparator.comparingInt(a -> a[1]));
        int ans = 0;
        for (int i = boxTypes.length - 1; i >= 0 && truckSize > 0; i--) {
            int tmp = Math.min(truckSize, boxTypes[i][0]);
            ans += tmp * boxTypes[i][1];
            truckSize -= tmp;
        }
        return ans;
    }
}