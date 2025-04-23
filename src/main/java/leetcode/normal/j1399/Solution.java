package leetcode.normal.j1399;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/count-largest-group/description/">1399. 统计最大组的数目</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int countLargestGroup(int n) {
        int[] cnt = new int[38];
        int max = 0, ans = 0;
        for (int i = 1; i <= n; i++) {
            int res = calc(i);
            cnt[res]++;
            if (cnt[res] > max) {
                max = cnt[res];
            }
        }
        for (int i = 0; i < cnt.length; i++) {
            if (cnt[i] == max) ++ans;
        }
        return ans;
    }

    int calc(int x) {
        int ans = 0;
        while (x > 0) {
            ans += x % 10;
            x /= 10;
        }
        return ans;
    }
}