package leetcode.normal.j1921;

import java.util.Arrays;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/eliminate-maximum-number-of-monsters/">1921. 消灭怪物的最大数量</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int eliminateMaximum(int[] dist, int[] speed) {
        int n = dist.length;
        // cnt[i] -> 表示这个怪兽会在第几分钟之后到达
        int[] cnt = new int[n];
        for (int i = 0; i < n; i++) {
            cnt[i] = (dist[i] - 1) / speed[i] + 1;
        }
        // 排序之后，从最快到达的开始枚举，如果怪兽到达，则游戏结束
        Arrays.sort(cnt);
        for (int i = 0; i < n; i++) {
            if (cnt[i] <= i) return i;
        }
        return n;
    }
}