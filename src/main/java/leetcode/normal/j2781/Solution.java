package leetcode.normal.j2781;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/missing-two-lcci/">面试题 17.19. 消失的两个数字</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int[] missingTwo(int[] nums) {
        boolean isN1 = false, isN2 = false;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int pos = i;
            while (nums[pos] != pos + 1 && nums[pos] != -1) {
                if (nums[pos] == n + 1) {
                    isN1 = true;
                    nums[pos] = -1;
                    break;
                } else if (nums[pos] == n + 2) {
                    isN2 = true;
                    nums[pos] = -1;
                    break;
                } else swap(nums, pos, nums[pos] - 1);
            }
        }
        int[] ans = new int[2];
        int idx = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == -1) ans[idx++] = i + 1;
        }
        if (!isN1) ans[idx++] = n + 1;
        if (!isN2) ans[idx++] = n + 2;
        return ans;
    }

    void swap(int[] nums, int pos1, int pos2) {
        int tmp = nums[pos1];
        nums[pos1] = nums[pos2];
        nums[pos2] = tmp;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.missingTwo(new int[]{2, 3});
    }
}