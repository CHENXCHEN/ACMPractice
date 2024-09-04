package leetcode.normal.j2860;

import java.util.*;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/happy-students/">2860. 让所有学生保持开心的分组方法数</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int countWays(List<Integer> nums) {
        nums.sort((x, y) -> x - y);
        int ans = 0;
        for (int i = 0; i <= nums.size(); i++) {
            // 前 i 个元素的是否小于 i
            if (i > 0 && nums.get(i - 1) >= i) continue;
            // 后 n - k 个元素是否大于 i
            if (i < nums.size() && nums.get(i) <= i) continue;
            ++ans;
        }
        return ans;
    }
}