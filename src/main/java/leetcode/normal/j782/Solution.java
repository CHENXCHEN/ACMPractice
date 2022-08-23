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
        // 获取第一行和最后一行的状态
        for (int i = 0; i < board.length; i++) {
            rowMask |= (board[0][i] << i);
            colMask |= (board[i][0] << i);
        }
        // 每一行要么是第一行要么是第一行的反，每一列要么是第一列要么是第一列的反
        int reverseRowMask = ((1 << n) - 1) ^ rowMask;
        int reverseColMask = ((1 << n) - 1) ^ colMask;
        int rowCnt = 0, colCnt = 0;
        for (int i = 0; i < n; i++) {
            int curRowMask = 0;
            int curColMask = 0;
            for (int j = 0; j < n; j++) {
                curRowMask |= (board[i][j] << j);
                curColMask |= (board[j][i] << j);
            }
            if (rowMask != curRowMask && reverseRowMask != curRowMask) return -1;
            else if (curRowMask == rowMask) ++rowCnt;
            if (colMask != curColMask && reverseColMask != curColMask) return -1;
            else if (curColMask == colMask) ++colCnt;
        }
        int rowMoves = getMoves(rowMask, rowCnt, n);
        int colMoves = getMoves(colMask, colCnt, n);
        return (rowMoves == -1 || colMoves == -1) ? -1 : (rowMoves + colMoves);
    }

    int getMoves(int mask, int cnt, int n) {
        int oneCnt = Integer.bitCount(mask);
        if ((n & 1) == 1) {
            // 1 和 0 出现的次数相差为 1，并且 mask 出现的次数和反码应该也为 1
            if (Math.abs(n - (oneCnt << 1)) != 1 || Math.abs(n - (cnt << 1)) != 1) return -1;
            if (oneCnt == (n >> 1)) {
                return (n >> 1) - Integer.bitCount(mask & 0xAAAAAAAA);
            } else {
                return (n >> 1) + 1 - Integer.bitCount(mask & 0x55555555);
            }
        } else {
            // 1 和 0 出现的次数相等，并且 mask 出现的次数和反码应该也相等
            if (n != (oneCnt << 1) || n != (cnt << 1)) return -1;
            int count0 = n / 2 - Integer.bitCount(mask & 0xAAAAAAAA);
            int count1 = n / 2 - Integer.bitCount(mask & 0x55555555);
            return Math.min(count0, count1);
        }
    }
}