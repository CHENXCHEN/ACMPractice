package leetcode.normal.j15;

import javafx.util.Pair;

import java.util.*;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/3sum/">15. 三数之和</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        Set<Pair<Integer, Pair<Integer, Integer>>> ss = new HashSet<>();
        int n = nums.length;
        for (int i = 2; i < n; i++) {
            int left = 0, right = i - 1;
            while (left < right) {
                int cmp = (nums[left] + nums[right]) + nums[i];
                // 如果加起来大于目标值，那么代表 [left, right-1] 这些位置和 right 加起来都会大于目标
                if (cmp > 0) right--;
                    // 如果加起来小于目标值，那么代表 [left+1, right] 这些位置和 left 加起来都会小于目标
                else if (cmp < 0) left++;
                else {
                    ss.add(new Pair<>(nums[left], new Pair<>(nums[right], nums[i])));
                    right--;
                }
            }
        }
        List<List<Integer>> ans = new ArrayList<>();
        for (Pair<Integer, Pair<Integer, Integer>> s : ss) {
            ArrayList<Integer> item = new ArrayList<>();
            item.add(s.getKey());
            item.add(s.getValue().getKey());
            item.add(s.getValue().getValue());
            ans.add(item);
        }
        return ans;
    }
}