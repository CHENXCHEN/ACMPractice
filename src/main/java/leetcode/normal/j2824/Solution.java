package leetcode.normal.j2824;

import java.util.List;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/count-pairs-whose-sum-is-less-than-target/description/">2824. 统计和小于目标的下标对数目</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int countPairs(List<Integer> nums, int target) {
        nums.sort((x, y) -> x - y);
        int ans = 0;
        for (int i = 0; i < nums.size(); i++) {
            int now = nums.get(i);
            int next = target - now;
            if (next > now) {
                int pos = query(nums, next);
                if (pos > i) {
                    ans += pos - i;
                }
            }
        }
        return ans;
    }

    int query(List<Integer> nums, int target) {
        int left = 0, right = nums.size() - 1, ans = 0;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (nums.get(mid) < target) {
                ans = mid;
                left = mid + 1;
            } else right = mid - 1;
        }
        return ans;
    }
}