package leetcode.normal.j788;

import java.util.Arrays;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/rotated-digits/">788. 旋转数字</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    TreeSet<Integer> rotateNum = new TreeSet<>(Arrays.stream(new int[]{2, 5, 6, 9}).boxed().collect(Collectors.toList())),
            selfNum = new TreeSet<>(Arrays.stream(new int[]{0, 1, 8}).boxed().collect(Collectors.toList())),
            notValidNum = new TreeSet<>(Arrays.stream(new int[]{3, 4, 7}).boxed().collect(Collectors.toList()));


    public int rotatedDigits(int n) {
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            if (isGoodNum(i)) ++ans;
        }
        return ans;
    }

    boolean isGoodNum(int x) {
        boolean haveRotateNum = false;
        while (x > 0) {
            int cur = x % 10;
            if (rotateNum.contains(cur)) haveRotateNum = true;
            if (notValidNum.contains(cur)) return false;
            x /= 10;
        }
        return haveRotateNum;
    }
}