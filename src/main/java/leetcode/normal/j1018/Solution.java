package leetcode.normal.j1018;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/binary-prefix-divisible-by-5/description/">1018. 可被 5 整除的二进制前缀</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public List<Boolean> prefixesDivBy5(int[] nums) {
        int n = nums.length;
        List<Boolean> ans = new ArrayList<>();
        int cur = 0;
        for (int num : nums) {
            cur = (cur * 2 + num) % 5;
            ans.add(cur == 0);
        }
        return ans;
    }
}