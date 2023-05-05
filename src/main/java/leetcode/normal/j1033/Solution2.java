package leetcode.normal.j1033;

import java.util.Arrays;

/**
 * Created by CHENXCHEN
 * https://leetcode-cn.com/problems/moving-stones-until-consecutive/
 * 1033. 移动石子直到连续
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution2 {
    public int[] numMovesStones(int a, int b, int c) {
        int[] arr = new int[3];
        arr[0] = a;
        arr[1] = b;
        arr[2] = c;
        Arrays.sort(arr);
        int[] ans = new int[2];
        if (arr[1] - arr[0] == 1 && arr[2] - arr[1] == 1) {
            // 如果是连续的，那么不能移动
        } else if (arr[1] - arr[0] <= 2 || arr[2] - arr[1] <= 2) {
            // 如果有两个连续的，那么只需要移动另一个石子即可
            ans[0] = 1;
        } else {
            // 否则最小的都可以通过两步得到
            ans[0] = 2;
        }
        ans[1] = arr[2] - arr[0] - 2;
        return ans;
    }
}