package leetcode.normal.j3005;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/count-elements-with-maximum-frequency/description/">3005. 最大频率元素计数</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int maxFrequencyElements(int[] nums) {
        int[] cnt = new int[101];
        int ans = 0, max = 0;
        for (int num : nums) {
            cnt[num]++;
        }
        for (int cc: cnt) {
            if (cc > max) {
                max = cc;
                ans = cc;
            } else if (cc == max) {
                ans += cc;
            }
        }
        return ans;
    }
}