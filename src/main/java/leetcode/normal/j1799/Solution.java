package leetcode.normal.j1799;

/**
 * Created by CHENXCHEN
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    int n, end;
    int[] ans, nums;

    public int maxScore(int[] nums) {
        this.nums = nums;
        n = nums.length;
        end = (1 << n) - 1;
        ans = new int[1 << n];
        dfs(0, 1, 0);
        return ans[end];
    }

    void dfs(int mark, int step, int res) {
        if (res != 0 && ans[mark] >= res) return;
        ans[mark] = Math.max(ans[mark], res);
        if (mark == end) return;
        for (int i = 0; i < n; i++) {
            if (((mark >> i) & 1) == 0) {
                for (int j = 0; j < n; j++) {
                    if (i != j && ((mark >> j) & 1) == 0) {
                        dfs(mark | (1 << i) | (1 << j), step + 1, res + step * gcd(nums[i], nums[j]));
                    }
                }
            }
        }
    }

    int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}