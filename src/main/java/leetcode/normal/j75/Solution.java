package leetcode.normal.j75;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/sort-colors/description/">75. 颜色分类</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int[] cnt = new int[3];
        for (int i = 0; i < n; i++) {
            ++cnt[nums[i]];
        }
        int idx = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < cnt[i]; j++) {
                nums[idx++] = i;
            }
        }
    }
}