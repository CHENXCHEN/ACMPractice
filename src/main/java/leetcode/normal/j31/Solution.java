package leetcode.normal.j31;

/**
 * Created by CHENXCHEN
 * https://leetcode-cn.com/problems/next-permutation/
 * 31. 下一个排列
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
public class Solution {
    public void swap(int[] nums, int posI, int posJ) {
        int tmp = nums[posI];
        nums[posI] = nums[posJ];
        nums[posJ] = tmp;
    }

    public void reverseInPlace(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start, end);
            start += 1;
            end -= 1;
        }
    }

    public void nextPermutation(int[] nums) {
        int leftPos = -1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] < nums[i + 1]) leftPos = i;
        }
        if (leftPos == -1) {
            reverseInPlace(nums, 0, nums.length - 1);
        } else {
            int rightPos = -1;
            for (int i = nums.length - 1; i > leftPos; i--) {
                if (nums[i] > nums[leftPos]) {
                    rightPos = i;
                    break;
                }
            }
            swap(nums, leftPos, rightPos);
            reverseInPlace(nums, leftPos + 1, nums.length - 1);
        }
    }
}
