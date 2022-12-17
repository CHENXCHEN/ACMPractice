package leetcode.normal.j1764;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/form-array-by-concatenating-subarrays-of-another-array/">1764. 通过连接另一个数组的子数组得到一个数组</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public boolean canChoose(int[][] groups, int[] nums) {
        int i = 0;
        for (int[] group : groups) {
            i = findNextGroup(group, nums, i);
            if (i == -1) return false;
        }
        return true;
    }

    int findNextGroup(int[] group, int[] nums, int start) {
        for (int i = start; i + group.length - 1 < nums.length; i++) {
            int idx1 = i, idx2 = 0;
            while (idx1 < nums.length && idx2 < group.length && nums[idx1] == group[idx2]) {
                ++idx1;
                ++idx2;
            }
            if (idx2 == group.length) return i + group.length;
        }
        return -1;
    }
}