package leetcode.normal.j1640;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/check-array-formation-through-concatenation/">1640. 能否连接形成数组</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public boolean canFormArray(int[] arr, int[][] pieces) {
        int pos1 = 0;
        while (pos1 < arr.length) {
            int idx = -1, pos2 = 0;
            for (int i = 0; i < pieces.length; i++) {
                if (pieces[i][0] == arr[pos1]) {
                    idx = i;
                    break;
                }
            }
            if (idx == -1) return false;
            while (pos2 < pieces[idx].length && pos1 < arr.length && pieces[idx][pos2] == arr[pos1]) {
                ++pos2;
                ++pos1;
            }
            if (pos2 != pieces[idx].length) return false;
        }
        return true;
    }
}