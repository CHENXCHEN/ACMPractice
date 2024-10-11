package leetcode.normal.j3164;

import java.util.TreeMap;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/find-the-number-of-good-pairs-ii/description/">3164. 优质数对的总数 II</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public long numberOfPairs(int[] nums1, int[] nums2, int k) {
        TreeMap<Integer, Integer> count1 = new TreeMap<>(), count2 = new TreeMap<>();
        int max = 0;
        for (int num : nums1) {
            count1.compute(num, (kk, vv) -> (vv == null ? 0 : vv) + 1);
            max = Math.max(max, num);
        }
        for (int num : nums2) {
            count2.compute(num, (kk, vv) -> (vv == null ? 0 : vv) + 1);
        }
        long ans = 0L;
        for (int num : count2.keySet()) {
            int base = num * k;
            for (int i = base; i <= max; i += base) {
                if (count1.containsKey(i)) {
                    ans += (long) count1.get(i) * count2.get(num);
                }
            }
        }
        return ans;
    }
}