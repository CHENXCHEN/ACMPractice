package leetcode.normal.j3233;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/find-the-count-of-numbers-which-are-not-special/description/">3233. 统计不是特殊数字的数字数量</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int nonSpecialCount(int l, int r) {
        ArrayList<Integer> prime = getPrime(r);
        int leftPos = binarySearchGreaterOrEqual(prime, l);
        int rightPos = binarySearchLessOrEqual(prime, r);
        if (leftPos == -1 || rightPos == -1 || prime.get(leftPos) * prime.get(leftPos) > r || prime.get(rightPos) * prime.get(rightPos) < l) {
            return r - l + 1;
        } else {
            return r - l + 1 - (rightPos - leftPos + 1);
        }
    }

    int binarySearchGreaterOrEqual(ArrayList<Integer> prime, int x) {
        int l = 0, r = prime.size() - 1, ans = -1;
        while (l <= r) {
            int mid = (l + r) >> 1;
            if (prime.get(mid) * prime.get(mid) >= x) {
                ans = mid;
                r = mid - 1;
            } else l = mid + 1;
        }
        return ans;
    }

    int binarySearchLessOrEqual(ArrayList<Integer> prime, int x) {
        int l = 0, r = prime.size() - 1, ans = -1;
        while (l <= r) {
            int mid = (l + r) >> 1;
            if (prime.get(mid) * prime.get(mid) <= x) {
                ans = mid;
                l = mid + 1;
            } else r = mid - 1;
        }
        return ans;
    }

    ArrayList<Integer> getPrime(int n) {
        n = (int) Math.sqrt(n) + 2;
        ArrayList<Integer> primes = new ArrayList<>();
        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;
        for (int i = 2; i * i < n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j < n; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        for (int i = 2; i < n; i++) {
            if (isPrime[i]) primes.add(i);
        }
        return primes;
    }
}