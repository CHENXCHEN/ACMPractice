package leetcode.normal.j2961;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/double-modular-exponentiation/description/">2961. 双模幂运算</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public List<Integer> getGoodIndices(int[][] variables, int target) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < variables.length; i++) {
            int a = variables[i][0], b = variables[i][1], c = variables[i][2], m = variables[i][3];
            if (fastPow(fastPow(a, b, 10), c, m) == target) {
                ans.add(i);
            }
        }
        return ans;
    }

    int fastPow(int num, int pow, int mod) {
        int ans = 1, base = num;
        while (pow > 0) {
            if ((pow & 1) == 1) {
                ans = (ans * base) % mod;
            }
            base = (base * base) % mod;
            pow >>= 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.fastPow(2, 6, 10));
    }
}