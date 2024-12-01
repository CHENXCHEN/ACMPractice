package leetcode.normal.j1564;

import java.util.Arrays;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/put-boxes-into-the-warehouse-i/description/">1564. 把箱子放进仓库里 I</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int maxBoxesInWarehouse(int[] boxes, int[] warehouse) {
        Arrays.sort(boxes);
        for (int i = 1; i < warehouse.length; i++) {
            warehouse[i] = Math.min(warehouse[i - 1], warehouse[i]);
        }
        int ans = 0;
        for (int i = warehouse.length - 1, j = 0; i >= 0 && j < boxes.length; i--) {
            if (warehouse[i] >= boxes[j]) {
                ++ans;
                ++j;
            }
        }
        return ans;
    }
}