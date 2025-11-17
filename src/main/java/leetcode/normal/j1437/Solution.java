package leetcode.normal.j1437;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/check-if-all-1s-are-at-least-length-k-places-away/description/">1437. 是否所有 1 都至少相隔 k 个元素</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public boolean kLengthApart(int[] nums, int k) {
        int lastIdx = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                if (lastIdx >= 0 && i - lastIdx - 1 < k) return false;
                lastIdx = i;
            }
        }
        return true;
    }
}