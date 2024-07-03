package leetcode.normal.j3099;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/harshad-number/description/">3099. 哈沙德数</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int sumOfTheDigitsOfHarshadNumber(int x) {
        int num = 0, cur = x;
        while (cur > 0) {
            num += cur % 10;
            cur /= 10;
        }
        return x % num == 0 ? num : -1;
    }
}