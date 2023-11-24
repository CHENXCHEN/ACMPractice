package leetcode.normal.j2824;

import java.util.List;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/count-pairs-whose-sum-is-less-than-target/description/">2824. 统计和小于目标的下标对数目</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution2 {
    public int countPairs(List<Integer> nums, int target) {
        nums.sort((x, y) -> x - y);
        int ans = 0;
        int i = 0, j = nums.size() - 1;
        while (i < j) {
            while (j > i && nums.get(i) + nums.get(j) >= target) {
                j--;
            }
            ans += j - i;
            i++;
        }
        return ans;
    }
}