package leetcode.normal.j1010;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/pairs-of-songs-with-total-durations-divisible-by-60/">1010. 总持续时间可被 60 整除的歌曲</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int[] cnt = new int[60];
        int ans = 0;
        for (int i = time.length - 1; i >= 0; i--) {
            int mod = time[i] % 60;
            int other = (60 - mod) % 60;
            ans += cnt[other];
            cnt[mod]++;
        }
        return ans;
    }
}