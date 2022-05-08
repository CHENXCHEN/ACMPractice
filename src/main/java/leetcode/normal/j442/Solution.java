package leetcode.normal.j442;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by CHENXCHEN
 * https://leetcode-cn.com/problems/find-all-duplicates-in-an-array/
 * 442. 数组中重复的数据
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        ArrayList<Integer> ans = new ArrayList<>();
        boolean[] vis = new boolean[nums.length];
        for (int num: nums) {
            if (!vis[num - 1]) vis[num - 1] = true;
            else ans.add(num);
        }
        return ans;
    }
}