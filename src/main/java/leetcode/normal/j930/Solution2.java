package leetcode.normal.j930;

/**
 * Created by CHENXCHEN
 * https://leetcode-cn.com/problems/binary-subarrays-with-sum/
 * 930. 和相同的二元子数组
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
public class Solution2 {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int left1 = 0, left2 = 0, s1 = 0, s2 = 0, right = 0, ans = 0;
        while (right < nums.length) {
            s1 += nums[right];
            while (left1 <= right && s1 > goal) {
                s1 -= nums[left1];
                left1++;
            }
            s2 += nums[right];
            while (left2 <= right && s2 >= goal) {
                s2 -= nums[left2];
                left2++;
            }
            ans += left2 - left1;
            right++;
        }
        return ans;
    }
}
