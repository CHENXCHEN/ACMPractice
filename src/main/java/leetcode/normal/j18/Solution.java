package leetcode.normal.j18;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/4sum/">18. 四数之和</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        HashSet<Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>> ss = new HashSet<>();
        for (int i = 0; i < n - 3; i++) {
            for (int j = i + 1; j < n - 2; j++) {
                long preSum = nums[i] + nums[j];
                int left = j + 1, right = n - 1;
                while (left < right) {
                    long curSum = preSum + nums[left] + nums[right];
                    if (curSum < target) {
                        left++;
                    } else if (curSum > target) {
                        right--;
                    } else {
                        ss.add(new Pair<>(new Pair<>(nums[i], nums[j]), new Pair<>(nums[left], nums[right])));
                        while (left < right && nums[left + 1] == nums[left]) left++;
                        while (left < right && nums[right - 1] == nums[right]) right--;
                        left++;
                        right--;
                    }
                }
            }
        }
        List<List<Integer>> ans = new ArrayList<>();
        for (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>> s : ss) {
            ArrayList<Integer> cur = new ArrayList<>();
            cur.add(s.getKey().getKey());
            cur.add(s.getKey().getValue());
            cur.add(s.getValue().getKey());
            cur.add(s.getValue().getValue());
            ans.add(cur);
        }
        return ans;
    }
}