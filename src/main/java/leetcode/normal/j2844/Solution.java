package leetcode.normal.j2844;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/minimum-operations-to-make-a-special-number/description/">2844. 生成特殊数字的最少操作</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int minimumOperations(String num) {
        // 如果一个数字末尾两位为 00 / 25 / 50 / 75，那么一定可以被 25 整除
        return Math.min(Math.min(solve(num, new char[]{'0', '0'}), solve(num, new char[]{'2', '5'})), Math.min(solve(num, new char[]{'5', '0'}), solve(num, new char[]{'7', '5'})));
    }

    int solve(String num, char[] target) {
        int cnt = 0, i = num.length() - 1;
        while (i >= 0 && num.charAt(i) != target[1]) {
            --i;
            ++cnt;
        }
        if (i < 0) return num.length();
        --i;
        while (i >= 0 && num.charAt(i) != target[0]) {
            --i;
            ++cnt;
        }
        if (i < 0 && target[1] == '5') return num.length();
        if (i < 0 && target[1] == '0') return num.length() - 1;
        return cnt;
    }
}