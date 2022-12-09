package leetcode.normal.j1780;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/check-if-number-is-a-sum-of-powers-of-three/">1780. 判断一个数字是否可以表示成三的幂的和</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public boolean checkPowersOfThree(int n) {
        int maxLevel = 1;
        while (maxLevel < n) maxLevel *= 3;
        // 21 = 9 + 3 + 1 X
        // 1 3 9 27
        while (n > 0 && maxLevel > 0) {
            while (maxLevel > n) maxLevel /= 3;
            n -= maxLevel;
            maxLevel /= 3;
        }
        return n == 0;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println("" + solution.checkPowersOfThree(21));
    }
}