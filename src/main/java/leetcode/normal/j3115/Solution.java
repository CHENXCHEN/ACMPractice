package leetcode.normal.j3115;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/maximum-prime-difference/description/">3115. 质数的最大距离</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int maximumPrimeDifference(int[] nums) {
        boolean[] isPrime = new boolean[101];
        isPrime[2] = isPrime[3] = true;
        for (int i = 4; i <= 100; i++) {
            if (checkPrime(i)) isPrime[i] = true;
        }
        int minPrimePos = -1, maxPrimePos = -1;
        for (int i = 0; i < nums.length; i++) {
            if (isPrime[nums[i]]) {
                if (minPrimePos == -1) minPrimePos = i;
                maxPrimePos = i;
            }
        }
        return maxPrimePos - minPrimePos;
    }

    boolean checkPrime(int x) {
        int dx = (int) Math.sqrt(x);
        for (int i = 2; i <= dx; i++) {
            if (x % i == 0) return false;
        }
        return true;
    }
}