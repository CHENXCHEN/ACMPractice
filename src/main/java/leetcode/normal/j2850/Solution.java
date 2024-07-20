package leetcode.normal.j2850;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/minimum-moves-to-spread-stones-over-grid/description/">2850. 将石头分散到网格图的最少移动次数</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    int rows, cols;
    int[][] grid;

    public int minimumMoves(int[][] grid) {
        this.grid = grid;
        rows = grid.length;
        cols = grid[0].length;
        ArrayList<int[]> more = new ArrayList<>(), less = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] > 1) {
                    for (int k = 2; k <= grid[i][j]; k++) more.add(new int[]{i, j});
                } else if (grid[i][j] == 0) {
                    less.add(new int[]{i, j});
                }
            }
        }
        int ans = Integer.MAX_VALUE;
        do {
            int steps = 0;
            for (int i = 0; i < more.size(); i++) {
                steps += dis(more.get(i)[0], more.get(i)[1], less.get(i)[0], less.get(i)[1]);
            }
            ans = Math.min(ans, steps);
        } while (nextPermutation(more));
        return ans;
    }

    boolean nextPermutation(List<int[]> more) {
        // 从右往左，找到第一个 more[i] < more[i+1] 的位置
        int p = -1;
        for (int i = more.size() - 2; i >= 0 && p == -1; i--) {
            if (isLess(more.get(i), more.get(i + 1))) p = i;
        }
        if (p == -1) return false;
        // 从右往左，找到第一个比 more[p] 大的位置，我们交换他们，这个位置一定是存在的
        int q = -1;
        for (int j = more.size() - 1; j > p && q == -1; j--) {
            if (isLess(more.get(p), more.get(j))) q = j;
        }
        Collections.swap(more, p, q);
        // 将 [p + 1, n - 1] 位置的进行反转，因为这个范围内是降序的
        int i = p + 1, j = more.size() - 1;
        while (i < j) {
            Collections.swap(more, i, j);
            i++;
            j--;
        }
        return true;
    }

    boolean isLess(int[] pair1, int[] pair2) {
        return pair1[0] < pair2[0] || (pair1[0] == pair2[0] && pair1[1] < pair2[1]);
    }

    int dis(int x, int y, int tx, int ty) {
        return Math.abs(x - tx) + Math.abs(y - ty);
    }
}