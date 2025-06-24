package leetcode.normal.j2200;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/find-all-k-distant-indices-in-an-array/description/">2200. 找出数组中的所有 K 近邻下标</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        List<Integer> ans = new ArrayList<>();
        int left = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == key) {
                left = Math.max(left, Math.max(0, i - k));
                while (left <= i + k && left < nums.length) {
                    ans.add(left);
                    left++;
                }
            }
        }
        return ans;
    }
}