package leetcode.normal.j215;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/kth-largest-element-in-an-array/">215. 数组中的第K个最大元素</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int findKthLargest(int[] nums, int k) {
        int[] has = new int[20002];
        for (int num : nums) has[num + 10000]++;
        for (int i = has.length - 1, s = 0; i >= 0; i--) {
            s += has[i];
            if (s >= k) {
                return i - 10000;
            }
        }
        return 0;
    }
}