package leetcode.normal.j1151;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/minimum-swaps-to-group-all-1s-together/description/">1151. 最少交换次数来组合所有的 1</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int minSwaps(int[] data) {
        int wide = 0;
        for (int num : data) {
            wide += num;
        }
        int ans = data.length, res = 0;
        for (int i = 0; i < data.length; i++) {
            res += data[i];
            if (i >= wide) {
                res -= data[i - wide];
            }
            if (i >= wide - 1) {
                ans = Math.min(ans, wide - res);
            }
        }
        return ans;
    }
}