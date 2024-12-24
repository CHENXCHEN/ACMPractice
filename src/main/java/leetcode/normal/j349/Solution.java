package leetcode.normal.j349;

import java.util.ArrayList;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/intersection-of-two-arrays/description/">349. 两个数组的交集</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        boolean[] vis = new boolean[1001];
        for (int num : nums1) {
            vis[num] = true;
        }
        ArrayList<Integer> res = new ArrayList<>();
        for (int num : nums2) {
            if (vis[num]) {
                vis[num] = false;
                res.add(num);
            }
        }
        int[] ans = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            ans[i] = res.get(i);
        }
        return ans;
    }
}