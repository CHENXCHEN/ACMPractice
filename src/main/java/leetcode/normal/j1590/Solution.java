package leetcode.normal.j1590;

import java.util.*;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/make-sum-divisible-by-p/"></a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int minSubarray(int[] nums, int p) {
        // 前缀和 % p + 后缀和 % p = 0 or p 即可
        // 那么枚举前缀 i，判断后缀是否存在，然后取大于 i 的最小值即可
        int ans = Integer.MAX_VALUE;
        Map<Integer, TreeSet<Integer>> mm = new HashMap<>();
        int n = nums.length;
        mm.put(0, new TreeSet<Integer>() {{
            add(n);
        }});
        int ss = 0;
        for (int i = n - 1; i >= 0; i--) {
            ss = (ss + nums[i]) % p;
            mm.computeIfAbsent(ss, k -> new TreeSet<>());
            mm.get(ss).add(i);
        }
        if (ss % p == 0) return 0;
        ss = 0;
        for (int i = 0; i < n; i++) {
            ss = (ss + nums[i]) % p;
            int key = (p - ss) % p;
            TreeSet<Integer> subSet = mm.get(key);
            if (subSet != null) {
                Integer higher = subSet.higher(i);
                if (higher != null) {
                    ans = Math.min(ans, higher - i - 1);
                }
            }
        }
        TreeSet<Integer> subSet = mm.get(0);
        Integer lower = subSet.lower(n);
        if (lower != null && lower != 0) {
            ans = Math.min(ans, lower);
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}