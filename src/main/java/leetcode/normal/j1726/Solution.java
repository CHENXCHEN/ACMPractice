package leetcode.normal.j1726;

import java.util.HashMap;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/tuple-with-same-product/description/">1726. 同积元组</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int tupleSameProduct(int[] nums) {
        HashMap<Integer, Integer> cnt = new HashMap<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int cur = nums[i] * nums[j];
                cnt.put(cur, cnt.getOrDefault(cur, 0) + 1);
            }
        }
        int ans = 0;
        for (Integer vv : cnt.values()) {
            ans += vv * (vv - 1) * 4;
        }
        return ans;
    }
}