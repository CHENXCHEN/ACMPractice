package leetcode.normal.j350;

import java.util.ArrayList;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/intersection-of-two-arrays-ii/description/">350. 两个数组的交集 II</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int[] hash = new int[1001];
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums1.length; i++) {
            hash[nums1[i]]++;
        }
        for (int i = 0; i < nums2.length; i++) {
            if (hash[nums2[i]] > 0) {
                list.add(nums2[i]);
            }
            hash[nums2[i]]--;
        }
        return list.stream().mapToInt(x -> x).toArray();
    }
}