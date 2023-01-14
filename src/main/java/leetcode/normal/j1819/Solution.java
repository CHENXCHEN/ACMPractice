package leetcode.normal.j1819;

import java.util.Arrays;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/number-of-different-subsequences-gcds/description/">1819. 序列中不同最大公约数的数目</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int countDifferentSubsequenceGCDs(int[] nums) {
        int maxNum = Arrays.stream(nums).max().getAsInt();
        boolean[] vis = new boolean[200001];
        for (int num : nums) {
            vis[num] = true;
        }
        int ans = 0;
        // 如果 gcd(a1,a2,a3,...,an) = 1，那么任意加一个元素 c，那么 gcd(a1,...,an,c) = 1 也是成立的
        // 因为相当于 gcd(a,b,c) = gcd(gcd(a,b),c), 上述则相当于 gcd(1, c) = 1
        // 如果 一个序列的 gcd(...) = 1，我们要它的最大公约数为 k，那么这些数应该都是 k 的倍数,使得 k*gcd(...) = k
        // 找出 k 的倍数的数，求它们的最大公约数，如果为 k，那么就可以组成这个因数
        for (int i = 1; i <= maxNum; i++) {
            int commGcd = 0;
            for (int j = i; j <= maxNum; j += i) {
                if (vis[j]) {
                    if (commGcd == 0) commGcd = j;
                    else commGcd = gcd(commGcd, j);
                    if (commGcd == i) {
                        ans++;
                        break;
                    }
                }
            }
        }
        return ans;
    }

    int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}