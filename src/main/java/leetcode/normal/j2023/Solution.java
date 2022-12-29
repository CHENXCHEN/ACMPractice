package leetcode.normal.j2023;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/two-out-of-three/"></a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    int[] vis;

    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        vis = new int[101];
        mark(nums1, 0);
        mark(nums2, 1);
        mark(nums3, 2);
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 1; i <= 100; i++) {
            if (Integer.bitCount(vis[i]) > 1) {
                ans.add(i);
            }
        }
        return ans;
    }

    void mark(int[] nums, int pos) {
        for (int num : nums) {
            vis[num] |= 1 << pos;
        }
    }
}