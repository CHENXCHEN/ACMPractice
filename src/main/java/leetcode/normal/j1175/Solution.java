package leetcode.normal.j1175;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/prime-arrangements/">1175. 质数排列</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    long mod = 1000000000 + 7;

    public int numPrimeArrangements(int n) {
        int primCnt = 0;
        for (int i = 2; i <= n; i++) {
            if (isPrime(i)) primCnt++;
        }
        return (int) (multi(primCnt) * multi(n - primCnt) % mod);
    }

    long multi(long cnt) {
        long ans = 1;
        for (int i = 2; i <= cnt; i++) {
            ans = (ans * i) % mod;
        }
        return ans;
    }

    boolean isPrime(int n) {
        int sqrt = (int) Math.sqrt(n);
        for (int i = 2; i <= sqrt; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}