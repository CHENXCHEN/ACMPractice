package leetcode.normal.j3258;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/count-substrings-that-satisfy-k-constraint-i/description/">3258. 统计满足 K 约束的子字符串数量 I</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    int[] preSum;

    public int countKConstraintSubstrings(String s, int k) {
        int n = s.length();
        preSum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            preSum[i + 1] = preSum[i] + (s.charAt(i) - '0');
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int pos = binarySearch(i, k);
//            System.out.printf("%d, %d\n", i, pos);
            ans += i - pos + 1;
        }
        return ans;
    }

    int binarySearch(int end, int k) {
        int left = 0, right = end, ans = -1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            int len = end - mid + 1;
            int sum1 = preSum[end + 1] - preSum[mid];
            int sum0 = len - sum1;
            if (sum0 <= k || sum1 <= k) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }
}