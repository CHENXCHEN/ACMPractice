package leetcode.normal.j930;

/**
 * Created by CHENXCHEN
 * https://leetcode-cn.com/problems/binary-subarrays-with-sum/
 * 930. 和相同的二元子数组
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
public class Solution3 {
    public int numSubarraysWithSum(int[] nums, int goal) {
        return atMostK(nums, goal) - atMostK(nums, goal - 1);
    }

    private int atMostK(int[] nums, int k) {
        if (k < 0) return 0;
        int i = 0, j = 0, res = 0;
        for (; i < nums.length; i++) {
            k -= nums[i];
            while (k < 0) {
                k += nums[j];
                j++;
            }
            res += i - j + 1;
        }
        return res;
    }
}
