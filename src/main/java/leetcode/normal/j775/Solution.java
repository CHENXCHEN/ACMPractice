package leetcode.normal.j775;

import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/global-and-local-inversions/description/">775. 全局倒置与局部倒置</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public boolean isIdealPermutation(int[] nums) {
        TreeSet<Integer> tSet = new TreeSet<>();
        int ans1 = 0, ans2 = 0, n = nums.length;
        for (int i = 0; i < n; i++) {
            SortedSet<Integer> subSet = tSet.subSet(nums[i], n);
            ans1 += subSet.size();
            if (subSet.size() > 1 || ans1 > n) return false;
            tSet.add(nums[i]);
            if (i > 0 && nums[i] < nums[i - 1]) {
                ans2++;
            }
        }
        return ans1 == ans2;
    }
}