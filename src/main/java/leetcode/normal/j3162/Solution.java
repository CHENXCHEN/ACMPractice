package leetcode.normal.j3162;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/find-the-number-of-good-pairs-i/description/">3162. 优质数对的总数 I</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int numberOfPairs(int[] nums1, int[] nums2, int k) {
        int ans = 0;
        for (int n1 : nums1) {
            for (int n2 : nums2) {
                if (isBeautifulPair(n1, n2, k)) ++ans;
            }
        }
        return ans;
    }

    boolean isBeautifulPair(int n1, int n2, int k) {
        return n1 % (n2 * k) == 0;
    }
}