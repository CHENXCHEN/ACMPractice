package leetcode.normal.j782;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/transform-to-chessboard/">782. 变为棋盘</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int movesToChessboard(int[][] board) {
        int rowMask = 0, colMask = 0, n = board.length;
        // 获取第一行和第一列的状态
        for (int i = 0; i < board.length; i++) {
            rowMask |= (board[0][i] << i);
            colMask |= (board[i][0] << i);
        }
        // 每一行要么是第一行要么是第一行的反，每一列要么是第一列要么是第一列的反
        int reverseRowMask = ((1 << n) - 1) ^ rowMask;
        int reverseColMask = ((1 << n) - 1) ^ colMask;
        // rowCnt 表示为与第一行相等的行数，colCnt 表示为与第一列相等的列数
        int rowCnt = 0, colCnt = 0;
        for (int i = 0; i < n; i++) {
            int curRowMask = 0;
            int curColMask = 0;
            for (int j = 0; j < n; j++) {
                curRowMask |= (board[i][j] << j);
                curColMask |= (board[j][i] << j);
            }
            // 如果当前行的状态，既不是第一行，也不是第一行的反，那么一定不行
            if (rowMask != curRowMask && reverseRowMask != curRowMask) return -1;
            else if (curRowMask == rowMask) ++rowCnt;
            // 如果当前列的状态，既不是第一列，也不是第一列的反，那么一定不行
            if (colMask != curColMask && reverseColMask != curColMask) return -1;
            else if (curColMask == colMask) ++colCnt;
        }
        int rowMoves = getMoves(rowMask, rowCnt, n);
        int colMoves = getMoves(colMask, colCnt, n);
        return (rowMoves == -1 || colMoves == -1) ? -1 : (rowMoves + colMoves);
    }

    int getMoves(int mask, int cnt, int n) {
        // 在长度为 n 的数组中，mask 出现的次数为 cnt，mask 最少移动多少次使得满足要求
        int oneCnt = Integer.bitCount(mask);
        if ((n & 1) == 1) {
            // 这里判断 mask 中 1 和 0 出现的次数是否满足，并且判断 mask 出现的次数是否满足
            if (Math.abs(n - (oneCnt << 1)) != 1 || Math.abs(n - (cnt << 1)) != 1) return -1;
            if (oneCnt == (n >> 1)) {
                // 如果 mask 中 1 出现的次数为偶数，那么 0 出现的次数更多，0 出现在第一位
                // mask & ...10101010 -> 需要移动的 1 的位置的标记
                return (n >> 1) - Integer.bitCount(mask & 0xAAAAAAAA);
            } else {
                // 如果 mask 中 1 出现的次数为奇数，那么 1 出现的次数更多，1 出现在第一位
                // mask & ...01010101 -> 需要保持不变的 1 的位置的标记
                return (n >> 1) + 1 - Integer.bitCount(mask & 0x55555555);
            }
        } else {
            // 1 和 0 出现的次数相等，并且 mask 出现的次数和反码应该也相等
            if (n != (oneCnt << 1) || n != (cnt << 1)) return -1;
            // count0 表示如果首位放置 0，那么需要移动多少次
            int count0 = n / 2 - Integer.bitCount(mask & 0xAAAAAAAA);
            // count1 表示如果首位放置 1，那么需要移动多少次
            int count1 = n / 2 - Integer.bitCount(mask & 0x55555555);
            // 去移动最少的次数
            return Math.min(count0, count1);
        }
    }
}