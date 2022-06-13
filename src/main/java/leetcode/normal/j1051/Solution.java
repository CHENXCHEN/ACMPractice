package leetcode.normal.j1051;

import java.util.Arrays;

/**
 * Created by CHENXCHEN
 * https://leetcode.cn/problems/height-checker/
 * 1051. 高度检查器
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int heightChecker(int[] heights) {
        int[] sort = Arrays.copyOf(heights, heights.length);
        Arrays.sort(sort);
        int ans = 0;
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] != sort[i]) ans++;
        }
        return ans;
    }
}