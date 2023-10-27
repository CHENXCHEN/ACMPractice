package leetcode.normal.j1465;

import java.util.Arrays;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/maximum-area-of-a-piece-of-cake-after-horizontal-and-vertical-cuts/description/">1465. 切割后面积最大的蛋糕</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        int mod = 1000000000 + 7;
        int maxWidth = verticalCuts[0], maxHeight = horizontalCuts[0];
        for (int i = 1; i < horizontalCuts.length; i++) {
            maxHeight = Math.max(maxHeight, horizontalCuts[i] - horizontalCuts[i - 1]);
        }
        maxHeight = Math.max(maxHeight, h - horizontalCuts[horizontalCuts.length - 1]);
        for (int i = 1; i < verticalCuts.length; i++) {
            maxWidth = Math.max(maxWidth, verticalCuts[i] - verticalCuts[i - 1]);
        }
        maxWidth = Math.max(maxWidth, w - verticalCuts[verticalCuts.length - 1]);
        return (int) ((long) maxHeight * maxWidth % mod);
    }
}