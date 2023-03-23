package leetcode.normal.j1630;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/arithmetic-subarrays/">1630. 等差子数组</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        int m = l.length;
        ArrayList<Boolean> ans = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int start = l[i], end = r[i];
            // 等差数列的特性，如果知道首位的话，那么就可以算出 d
            int minNum = nums[start], maxNum = nums[start];
            for (int j = start + 1; j <= end; j++) {
                minNum = Math.min(nums[j], minNum);
                maxNum = Math.max(nums[j], maxNum);
            }
            if (minNum == maxNum) {
                ans.add(true);
                continue;
            }
            int qLen = end - start + 1;
            if ((maxNum - minNum) % (qLen - 1) != 0) {
                ans.add(false);
                continue;
            }
            int d = (maxNum - minNum) / (qLen - 1);
            boolean[] vis = new boolean[qLen];
            boolean flag = true;
            for (int j = start; j <= end; j++) {
                if ((nums[j] - minNum) % d != 0) {
                    flag = false;
                    break;
                }
                int t = (nums[j] - minNum) / d;
                if (!vis[t]) {
                    vis[t] = true;
                } else {
                    flag = false;
                    break;
                }
            }
            ans.add(flag);
        }
        return ans;
    }
}