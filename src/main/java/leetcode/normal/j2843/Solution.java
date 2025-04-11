package leetcode.normal.j2843;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/count-symmetric-integers/description/">2843. 统计对称整数的数目</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int countSymmetricIntegers(int low, int high) {
        int ans = 0;
        for (int i = low; i <= high; i++) {
            if (isValid(i)) ++ans;
        }
        return ans;
    }

    boolean isValid(int num) {
        String str = String.valueOf(num);
        if (str.length() % 2 != 0) return false;
        int i = 0, j = str.length() - 1, leftSum = 0, rightSum = 0;
        while (i < j) {
            leftSum += str.charAt(i++) - '0';
            rightSum += str.charAt(j--) - '0';
        }
        return leftSum == rightSum;
    }
}