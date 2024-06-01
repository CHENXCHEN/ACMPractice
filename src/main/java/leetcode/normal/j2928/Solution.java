package leetcode.normal.j2928;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/distribute-candies-among-children-i/description/">2928. 给小朋友们分糖果 I</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int distributeCandies(int n, int limit) {
        int ans = 0;
        for (int i = 0; i <= limit && i <= n; i++) {
            int left = n - i;
            for (int j = 0; j <= limit && j <= left; j++) {
                int k = left - j;
                if (k <= limit) ++ans;
            }
        }
        return ans;
    }
}