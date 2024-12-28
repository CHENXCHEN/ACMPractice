package leetcode.normal.j3046;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/split-the-array/description/">3046. 分割数组</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public boolean isPossibleToSplit(int[] nums) {
        int[] cnt = new int[101];
        for (int num : nums) {
            cnt[num]++;
            if (cnt[num] > 2) return false;
        }
        return true;
    }
}