package leetcode.normal.j523;

import java.util.TreeMap;

/**
 * Created by CHENXCHEN
 * https://leetcode-cn.com/problems/continuous-subarray-sum/solution/lian-xu-de-zi-shu-zu-he-by-leetcode-solu-rdzi/
 * 523. 连续的子数组和
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
public class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        TreeMap<Integer, Integer> mm = new TreeMap<Integer, Integer>() {{
            put(0, -1);
        }};
        int ss = 0;
        for (int i = 0; i < nums.length; i++) {
            ss = (ss + nums[i]) % k;
            if (mm.containsKey(ss)) {
                if (i - mm.get(ss) >= 2) return true;
            } else mm.put(ss, i);
        }
        return false;
    }
}
