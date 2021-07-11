package leetcode.normal.j930;

import java.util.TreeMap;

/**
 * Created by CHENXCHEN
 * https://leetcode-cn.com/problems/binary-subarrays-with-sum/
 * 930. 和相同的二元子数组
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
public class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        int sum = 0;
        int ans = 0;
        for (int num : nums) {
            treeMap.put(sum, treeMap.getOrDefault(sum, 0) + 1);
            sum += num;
            ans += treeMap.getOrDefault(sum - goal, 0);
        }
        return ans;
    }
}
