package leetcode.normal.j498;

/**
 * Created by CHENXCHEN
 * https://leetcode.cn/problems/diagonal-traverse/
 * 498. 对角线遍历
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int x = 0, y = 0, rows = mat.length, cols = mat[0].length, tot = 0;
        boolean dir = true;
        int[] ans = new int[rows * cols];
        while (true) {
            ans[tot++] = mat[x][y];
            if (x == rows - 1 && y == cols - 1) break;
            if (dir) {
                if (x - 1 >= 0 && y + 1 < cols) {
                    x--;
                    y++;
                } else if (x == 0 && y + 1 < cols) {
                    y++;
                    dir = false;
                } else if (x + 1 < rows && y == cols - 1) {
                    x++;
                    dir = false;
                } else break;
            } else {
                if (x + 1 < rows && y - 1 >= 0) {
                    x++;
                    y--;
                } else if (y == 0 && x + 1 < rows) {
                    x++;
                    dir = true;
                } else if (x == rows - 1 && y + 1 < cols) {
                    y++;
                    dir = true;
                } else break;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] mat = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        Solution solution = new Solution();
        solution.findDiagonalOrder(mat);
    }
}