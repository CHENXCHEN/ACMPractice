package leetcode.normal.j3542;

import java.util.*;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/minimum-operations-to-convert-all-elements-to-zero/description/">3542. 将所有元素变为 0 的最少操作次数</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int minOperations(int[] nums) {
        TreeMap<Integer, List<Integer>> map = new TreeMap<>();
        TreeSet<Integer> zeroSet = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
            else zeroSet.add(i);
        }
        int ans = 0;
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            List<Integer> lst = entry.getValue();
            int i = 0;
            while (i < lst.size()) {
                int j = i + 1;
                while (j < lst.size()) {
                    Integer lower = zeroSet.lower(lst.get(j));
                    if (lower != null && lower > lst.get(i)) break;
                    j++;
                }
                for (int k = i; k < j; k++) zeroSet.add(lst.get(k));
                ++ans;
                i = j;
            }
        }
        return ans;
    }
}