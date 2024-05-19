package leetcode.normal.j1535;

import java.util.Arrays;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/find-the-winner-of-an-array-game/description/">1535. 找出数组游戏的赢家</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int getWinner(int[] arr, int k) {
        int n = arr.length;
        if (k - 1 >= n) {
            return Arrays.stream(arr).max().getAsInt();
        }
        int compareCnt = 0, cur = arr[0];
        for (int i = 1; i < n; i++) {
            int num = arr[i];
            if (num > cur) {
                cur = num;
                compareCnt = 1;
            } else {
                compareCnt++;
            }
            if (compareCnt >= k) return cur;
        }
        return cur;
    }
}