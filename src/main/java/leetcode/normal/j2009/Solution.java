package leetcode.normal.j2009;

import java.util.ArrayList;
import java.util.TreeSet;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/minimum-number-of-operations-to-make-array-continuous/description/">2009. 使数组连续的最少操作数</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int minOperations(int[] nums) {
        TreeSet<Integer> tSet = new TreeSet<>();
        for (int num : nums) tSet.add(num);
        ArrayList<Integer> arr = new ArrayList<>(tSet);
        int n = nums.length, ans = n - 1;
        for (int i = 0; i < arr.size(); i++) {
            int idx = bs(arr, arr.get(i) + n - 1);
            ans = Math.min(ans, n - (idx - i + 1));
        }
        return ans;
    }

    int bs(ArrayList<Integer> arr, int target) {
        int left = 0, right = arr.size() - 1, ans = -1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (arr.get(mid) <= target) {
                ans = mid;
                left = mid + 1;
            } else right = mid - 1;
        }
        return ans;
    }
}