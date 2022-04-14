package leetcode.normal.j1672;

import java.util.Arrays;

/**
 * Created by CHENXCHEN
 * https://leetcode-cn.com/problems/richest-customer-wealth/
 * 1672. 最富有客户的资产总量
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int maximumWealth(int[][] accounts) {
        int ans = 0;
        for (int[] account : accounts) {
            ans = Math.max(ans, Arrays.stream(account).sum());
        }
        return ans;
    }
}