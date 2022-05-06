package leetcode.normal.j1033;

import java.util.Arrays;

/**
 * Created by CHENXCHEN
 * https://leetcode-cn.com/problems/moving-stones-until-consecutive/
 * 1033. 移动石子直到连续
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int[] numMovesStones(int a, int b, int c) {
        int[] arr = new int[3];
        arr[0] = a;
        arr[1] = b;
        arr[2] = c;
        Arrays.sort(arr);
        int ansMin = 0, ansMax = 0;
        if (arr[0] + 2 == arr[1] || arr[1] + 2 == arr[2]) ansMin = 1;
        else {
            if (arr[0] + 1 != arr[1]) ansMin += 1;
            if (arr[1] + 1 != arr[2]) ansMin += 1;
        }

        ansMax = arr[2] - arr[0] - 2;

        int[] ans = new int[2];
        ans[0] = ansMin;
        ans[1] = ansMax;
        return ans;
    }
}