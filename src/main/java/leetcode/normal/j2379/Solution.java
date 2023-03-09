package leetcode.normal.j2379;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/minimum-recolors-to-get-k-consecutive-black-blocks/">2379. 得到 K 个黑块的最少涂色次数</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int minimumRecolors(String blocks, int k) {
        int[] cnt = new int[2];
        for (int i = 0; i < k; i++) {
            if (blocks.charAt(i) == 'W') ++cnt[1];
        }
        int ans = cnt[1];
        for (int i = k; i < blocks.length(); i++) {
            if (blocks.charAt(i) == 'W') ++cnt[1];
            if (blocks.charAt(i - k) == 'W') ++cnt[0];
            ans = Math.min(cnt[1] - cnt[0], ans);
        }
        return ans;
    }
}