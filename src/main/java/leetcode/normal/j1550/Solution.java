package leetcode.normal.j1550;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/three-consecutive-odds/description/">1550. 存在连续三个奇数的数组</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        if (arr.length < 3) return false;
        for (int i = 1;i < arr.length - 1; i++) {
            if ((arr[i-1] & arr[i] & arr[i+1] & 1) == 1) return true;
        }
        return false;
    }
}