package leetcode.normal.j1428;

import java.util.List;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/leftmost-column-with-at-least-a-one/description/">1428. 至少有一个 1 的最左端列</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        List<Integer> dimensions = binaryMatrix.dimensions();
        int rows = dimensions.get(0), cols = dimensions.get(1);
        int ans = -1;
        for (int i = 0; i < rows; i++) {
            if (binaryMatrix.get(i, cols - 1) == 1) {
                int left = 0, right = cols - 1;
                while (left <= right) {
                    int mid = (left + right) / 2;
                    if (binaryMatrix.get(i, mid) == 1) {
                        ans = ans == -1 ? mid : Math.min(ans, mid);
                        right = mid - 1;
                    } else left = mid + 1;
                }
            }
        }
        return ans;
    }
}