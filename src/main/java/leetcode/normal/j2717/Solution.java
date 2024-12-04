package leetcode.normal.j2717;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/semi-ordered-permutation/description/">2717. 半有序排列</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int semiOrderedPermutation(int[] nums) {
        int firstIdx = 0, lastIdx = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) firstIdx = i;
            else if (nums[i] == n) lastIdx = i;
        }
        int ans = firstIdx + (n - lastIdx - 1);
        if (lastIdx < firstIdx) --ans;
        return ans;
    }
}