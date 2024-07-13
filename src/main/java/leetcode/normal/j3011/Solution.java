package leetcode.normal.j3011;

import java.util.Arrays;

/**
 * Created by CHENXCHEN
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    int[] nums;

    public boolean canSortArray(int[] nums) {
        this.nums = nums;
        int n = nums.length;
        Integer[] pos = new Integer[n];
        for (int i = 0; i < n; i++) pos[i] = i;
        Arrays.sort(pos, (x, y) -> Integer.compare(nums[x], nums[y]));
        for (int i = 0; i < n; i++) {
            int idx = pos[i];
            if (idx > i && !check(i, idx)) return false;
            if (idx < i && !check(idx, i)) return false;
        }
        return true;
    }

    boolean check(int left, int right) {
        int cnt = Integer.bitCount(nums[left]);
        for (int i = left + 1; i <= right; i++) {
            if (Integer.bitCount(nums[i]) != cnt) return false;
        }
        return true;
    }
}