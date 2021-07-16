package leetcode.normal.j2028;

/**
 * Created by CHENXCHEN
 * https://leetcode-cn.com/problems/zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-lcof/
 * 剑指 Offer 53 - I. 在排序数组中查找数字 I
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
public class Solution {
    public int search(int[] nums, int target) {
        if (nums.length == 0) return 0;
        int leftPos = findLeft(nums, target);
        int rightPos = findRight(nums, target);
        if (leftPos == -1) {
            return 0;
        } else return rightPos - leftPos + 1;
    }

    int findLeft(int[] num, int target) {
        int l = 0, r = num.length - 1;
        int ans = -1;
        while (l <= r) {
            int m = (l + r) >> 1;
            if (num[m] == target) {
                ans = m;
                r = m - 1;
            } else if (num[m] > target) {
                r = m - 1;
            } else l = m + 1;
        }
        return ans;
    }

    int findRight(int[] num, int target) {
        int l = 0, r = num.length - 1;
        int ans = -1;
        while (l <= r) {
            int m = (l + r) >> 1;
            if (num[m] == target) {
                ans = m;
                l = m + 1;
            } else if (num[m] > target) {
                r = m - 1;
            } else l = m + 1;
        }
        return ans;
    }
}
