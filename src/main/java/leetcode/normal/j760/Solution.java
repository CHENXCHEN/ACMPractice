package leetcode.normal.j760;

import java.util.ArrayDeque;
import java.util.TreeMap;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/find-anagram-mappings/">760. 找出变位映射</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int[] anagramMappings(int[] nums1, int[] nums2) {
        TreeMap<Integer, ArrayDeque<Integer>> tMap = new TreeMap<>();
        int n = nums1.length;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            if (nums1[i] != nums2[i]) {
                tMap.compute(nums2[i], (k, v) -> v == null ? new ArrayDeque<>() : v).add(i);
            }
            ans[i] = i;
        }
        for (int i = 0; i < n; i++) {
            if (nums1[i] != nums2[i]) {
                ArrayDeque<Integer> pos = tMap.get(nums1[i]);
                ans[i] = pos.poll();
            }
        }
        return ans;
    }
}