package leetcode.normal.j1222;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/queens-that-can-attack-the-king/description/">1222. 可以攻击国王的皇后</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        int mark = 0;
        Arrays.sort(queens, (x, y) -> distance(x, king) - distance(y, king));
        List<List<Integer>> ans = new ArrayList<>();
        for (int[] queen : queens) {
            if (Math.abs(queen[0] - king[0]) == Math.abs(queen[1] - king[1])) {
                if (queen[0] < king[0] && queen[1] < king[1] && (mark & 1) == 0) {
                    mark |= 1;
                    ans.add(genList(queen));
                } else if (queen[0] < king[0] && queen[1] > king[1] && (mark & 2) == 0) {
                    mark |= 2;
                    ans.add(genList(queen));
                } else if (queen[0] > king[0] && queen[1] < king[1] && (mark & 4) == 0) {
                    mark |= 4;
                    ans.add(genList(queen));
                } else if (queen[0] > king[0] && queen[1] > king[1] && (mark & 8) == 0) {
                    mark |= 8;
                    ans.add(genList(queen));
                }
            } else if (queen[0] == king[0]) {
                if (queen[1] < king[1] && (mark & 16) == 0) {
                    mark |= 16;
                    ans.add(genList(queen));
                } else if (queen[1] > king[1] && (mark & 32) == 0) {
                    mark |= 32;
                    ans.add(genList(queen));
                }
            } else if (queen[1] == king[1]) {
                if (queen[0] < king[0] && (mark & 64) == 0) {
                    mark |= 64;
                    ans.add(genList(queen));
                } else if (queen[0] > king[0] && (mark & 128) == 0) {
                    mark |= 128;
                    ans.add(genList(queen));
                }
            }
        }
        return ans;
    }

    ArrayList<Integer> genList(int[] queue) {
        return new ArrayList<Integer>() {{
            add(queue[0]);
            add(queue[1]);
        }};
    }

    int distance(int[] a, int[] b) {
        int diffX = a[0] - b[0], diffY = a[1] - b[1];
        return diffX * diffX + diffY * diffY;
    }
}