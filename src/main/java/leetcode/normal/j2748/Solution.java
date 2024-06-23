package leetcode.normal.j2748;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/number-of-beautiful-pairs/description/">2748. 美丽下标对的数目</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int countBeautifulPairs(int[] nums) {
        int n = nums.length, ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (isBeautiful(nums[i], nums[j])) ++ans;
            }
        }
        return ans;
    }

    boolean isBeautiful(int a, int b) {
        int c = String.valueOf(a).charAt(0) - '0';
        int d = b % 10;
        return gcd(c, d) == 1;
    }

    int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}