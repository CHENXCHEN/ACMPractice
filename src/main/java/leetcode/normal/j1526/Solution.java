package leetcode.normal.j1526;

import java.util.ArrayDeque;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/minimum-number-of-increments-on-subarrays-to-form-a-target-array/description/">1526. 形成目标数组的子数组最少增加次数</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int minNumberOperations(int[] target) {
        int n = target.length;
        // 单调栈，从左往右遍历，当栈内有比当前大的，那么栈内大的部分一定要操作，操作次数由其值和当前值差的最大值
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int ans = 1;
        for (int i = 0; i < n; i++) {
            int res = 0;
            while (!stack.isEmpty() && stack.peek() > target[i]) {
                res = Math.max(res, stack.pop() - target[i]);
            }
            ans += res;
            stack.push(target[i]);
        }
        int res = 0;
        while (!stack.isEmpty()) {
            res = Math.max(res, stack.pop() - 1);
        }
        ans += res;
        return ans;
    }
}