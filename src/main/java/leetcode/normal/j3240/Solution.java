package leetcode.normal.j3240;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/minimum-number-of-flips-to-make-binary-grid-palindromic-ii/">3240. 最少翻转次数使二进制矩阵回文 II</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int minFlips(int[][] grid) {
        // 只需要考虑行为奇数或者列为奇数时的情况
        // 当行不为奇数时，任意行的任意位置，对应的四个位置(位置左右与上下)，要么都为1，要么都为0
        // 当列不为奇数时，任意列的任意位置，对应的四个位置(位置左右与上下)，要么都为1，要么都为0
        // 当行与列都为奇数时候，中心位置如果为1，一定不能组成 4 的倍数
        // 当行或列为奇数时，其 1 的个数只能为 2 的倍数
        int rows = grid.length, cols = grid[0].length;
        int cntError = 0, cnt1 = 0, operation = 0;
        if ((rows & 1) == 1 && (cols & 1) == 1) {
            int r = rows >> 1, c = cols >> 1;
            if (grid[r][c] == 1) {
                ++operation;
                grid[r][c] = 0;
            }
        }
        if ((rows & 1) == 1) {
            int rPos = rows >> 1, l = 0, r = cols - 1;
            while (l < r) {
                if (grid[rPos][l] != grid[rPos][r]) ++cntError;
                cnt1 += grid[rPos][l] + grid[rPos][r];
                ++l;
                --r;
            }
        }
        if ((cols & 1) == 1) {
            int cPos = cols >> 1, l = 0, r = rows - 1;
            while (l < r) {
                if (grid[l][cPos] != grid[r][cPos]) ++cntError;
                cnt1 += grid[l][cPos] + grid[r][cPos];
                ++l;
                --r;
            }
        }
        // 如果没有错误的，那么挑任意两个 1 的转换为 0
        if (cntError == 0) {
            if (cnt1 % 4 != 0) {
                operation += 2;
            }
        } else {
            // 如果有错误的，那么这些错误调整一定存在某种方式使得成为 4 的倍数
            operation += cntError;
        }
        for (int i = 0; i < rows; i++) {
            int l = 0, r = cols - 1, d = rows - i - 1;
            if ((rows & 1) == 1 && i == (rows >> 1)) continue;
            while (l < r) {
                if (grid[i][l] != grid[i][r] || grid[d][l] != grid[d][r] || grid[i][l] != grid[d][l]) {
                    int cnt = grid[i][l] + grid[i][r] + grid[d][l] + grid[d][r];
                    if (cnt > 2) {
                        grid[i][l] = grid[i][r] = grid[d][l] = grid[d][r] = 1;
                        operation += 4 - cnt;
                    } else {
                        grid[i][l] = grid[i][r] = grid[d][l] = grid[d][r] = 1;
                        operation += cnt;
                    }
                }
                ++l;
                --r;
            }
        }
        return operation;
    }
}