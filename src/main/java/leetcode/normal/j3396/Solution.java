package leetcode.normal.j3396;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/minimum-number-of-operations-to-make-elements-in-array-distinct/description/">3396. 使数组元素互不相同所需的最少操作次数</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int minimumOperations(int[] nums) {
        int[] cnt = new int[101];
        for (int num : nums) {
            cnt[num]++;
        }
        int ans = 0;
        if (!isValid(cnt)) {
            for (int i = 0; i < nums.length; i += 3) {
                if (i + 3 >= nums.length) {
                    ans++;
                    break;
                }
                cnt[nums[i]]--;
                cnt[nums[i + 1]]--;
                cnt[nums[i + 2]]--;
                ans++;
                if (isValid(cnt)) break;
            }
        }
        return ans;
    }

    boolean isValid(int[] cnt) {
        for (int num : cnt) {
            if (num > 1) return false;
        }
        return true;
    }
}