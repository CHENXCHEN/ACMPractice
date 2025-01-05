package leetcode.normal.j296;

import java.util.ArrayList;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/best-meeting-point/description/">296. 最佳的碰头地点</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int minTotalDistance(int[][] grid) {
        ArrayList<Integer> friendX = new ArrayList<>(), friendY = new ArrayList<>();
        int rows = grid.length, cols = grid[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    friendX.add(i);
                    friendY.add(j);
                }
            }
        }
        friendX.sort((x, y) -> x - y);
        friendY.sort((x, y) -> x - y);
        int friendCnt = friendX.size();
        int[] preSumX = new int[friendCnt + 1], preSumY = new int[friendCnt + 1];
        for (int i = 0; i < friendCnt; i++) {
            preSumX[i + 1] = preSumX[i] + friendX.get(i);
            preSumY[i + 1] = preSumY[i] + friendY.get(i);
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // 计算当前位置的曼哈顿距离，算出比 i 小的和，比 i 大的和，就可以直接转换为加法了
                int xPos = binarySearch(friendX, i);
                int yPos = binarySearch(friendY, j);
                int xSum = getSum(friendCnt, preSumX, i, xPos);
                int ySum = getSum(friendCnt, preSumY, j, yPos);
                ans = Math.min(ans, xSum + ySum);
            }
        }
        return ans;
    }

    private int getSum(int friendCnt, int[] preSum, int i, int pos) {
        int xSum;
        if (pos != -1) {
            xSum = (pos + 1) * i - preSum[pos + 1] + preSum[friendCnt] - preSum[pos + 1] - (friendCnt - pos - 1) * i;
        } else {
            xSum = preSum[friendCnt] - friendCnt * i;
        }
        return xSum;
    }

    // 找到小于等于 target 的最大下标，没有返回 -1
    int binarySearch(ArrayList<Integer> coord, int target) {
        int left = 0, right = coord.size() - 1, ans = -1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (coord.get(mid) <= target) {
                ans = mid;
                left = mid + 1;
            } else right = mid - 1;
        }
        return ans;
    }
}