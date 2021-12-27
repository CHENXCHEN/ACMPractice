package leetcode.normal.j825;

/**
 * Created by CHENXCHEN
 * https://leetcode-cn.com/problems/friends-of-appropriate-ages/
 * 825. 适龄的朋友
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int numFriendRequests(int[] ages) {
        int[] has = new int[121];
        int[] pSum = new int[121];
        for (int age : ages) has[age]++;
        for (int i = 1; i < 121; i++) pSum[i] = pSum[i - 1] + has[i];
        int ans = 0;
        for (int age : ages) {
            // y > 0.5 * age + 7 && y <= age && (y <= 100 || age >= 100)
            int left = (age >> 1) + 7 + 1;
            int right = age;
            int lag = has[age] >= 1 ? 1 : 0;
            if (right >= left)
                ans += pSum[right] - pSum[left - 1] - lag;
        }
        return ans;
    }
}