package leetcode.normal.j1818;

import java.util.TreeSet;

/**
 * Created by CHENXCHEN
 * https://leetcode-cn.com/problems/minimum-absolute-sum-difference/
 * 1818. 绝对差值和
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
public class Solution {
    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        TreeSet<Integer> tSet = new TreeSet<>();
        for (int num : nums1) {
            tSet.add(num);
        }
        int mod = 1000000000 + 7;
        int absSum = 0;
        for (int i = 0; i < nums1.length; i++) {
            absSum = (absSum + Math.abs(nums1[i] - nums2[i])) % mod;
        }

        int ans = absSum;
        for (int i = 0; i < nums1.length; i++) {
            Integer left = tSet.floor(nums2[i]);
            Integer right = tSet.ceiling(nums2[i]);
            int before = absSum - Math.abs(nums1[i] - nums2[i]);
            if (left != null) {
                int changed = (before + Math.abs(left - nums2[i])) % mod;
                if (changed < ans) ans = changed;
            }
            if (right != null) {
                int changed = (before + Math.abs(right - nums2[i])) % mod;
                if (changed < ans) ans = changed;
            }
        }
        return (ans + mod) % mod;
    }
}
