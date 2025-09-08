package leetcode.normal.j1133;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/largest-unique-number/description/">1133. 最大唯一数</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int largestUniqueNumber(int[] nums) {
        int[] cnt = new int[1001];
        for (int num : nums) {
            cnt[num]++;
        }
        for (int i = 1000;i >= 0;i--) {
            if (cnt[i] == 1) return i;
        }
        return -1;
    }
}