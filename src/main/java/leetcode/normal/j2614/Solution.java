package leetcode.normal.j2614;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/prime-in-diagonal/description/">2614. 对角线上的质数</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int diagonalPrime(int[][] nums) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            if (isPrime(nums[i][i])) ans = Math.max(ans, nums[i][i]);
            if (isPrime(nums[i][nums.length - i - 1])) ans = Math.max(ans, nums[i][nums.length - i - 1]);
        }
        return ans;
    }

    boolean isPrime(int num) {
        if (num < 2) return false;
        int mx = (int) Math.sqrt(num) + 1;
        for (int i = 2; i <= mx && i < num; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }

}