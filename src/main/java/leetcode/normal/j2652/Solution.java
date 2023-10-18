package leetcode.normal.j2652;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/sum-multiples/description/">2652. 倍数求和</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int sumOfMultiples(int n) {
        int ans = 0;
        for (int i = 3; i <= n; i++) {
            if (i % 3 == 0 || i % 5 == 0 || i % 7 == 0) ans += i;
        }
        return ans;
    }
}