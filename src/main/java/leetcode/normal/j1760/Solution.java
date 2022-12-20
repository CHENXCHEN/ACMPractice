package leetcode.normal.j1760;

import java.util.Arrays;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/minimum-limit-of-balls-in-a-bag/">1760. 袋子里最少数目的球</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int minimumSize(int[] nums, int maxOperations) {
        int left = 1, right = Arrays.stream(nums).max().getAsInt(), ans = right;
        while (left <= right) {
            int mid = (left + right) >> 1;
            int predict = predict(nums, mid);
            if (predict <= maxOperations) {
                ans = Math.min(mid, ans);
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

    int predict(int[] nums, int maxNum) {
        int ans = 0;
        for (int num : nums) {
            ans += (num - 1) / maxNum;
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.minimumSize(new int[]{9}, 2);
    }
}