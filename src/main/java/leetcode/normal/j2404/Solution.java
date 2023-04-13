package leetcode.normal.j2404;

import java.util.HashMap;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/most-frequent-even-element/">2404. 出现最频繁的偶数元素</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int mostFrequentEven(int[] nums) {
        HashMap<Integer, Integer> mm = new HashMap<>();
        int ans = -1, lastCnt = 0;
        for (int num : nums) {
            if ((num & 1) == 0) {
                int cnt = mm.compute(num, (kk, vv) -> vv == null ? 1 : vv + 1);
                if (cnt > lastCnt || (cnt == lastCnt && ans > num)) {
                    ans = num;
                    lastCnt = cnt;
                }
            }
        }
        return ans;
    }
}