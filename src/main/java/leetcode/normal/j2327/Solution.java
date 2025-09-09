package leetcode.normal.j2327;

import java.util.ArrayDeque;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/number-of-people-aware-of-a-secret/description/">2327. 知道秘密的人数</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    final static int MOD = (int) 1e9 + 7;

    public int peopleAwareOfSecret(int n, int delay, int forget) {
        // 记录第 i 天有多少知道不能分享，有多少知道可以分享
        ArrayDeque<int[]> know = new ArrayDeque<>(), share = new ArrayDeque<>();
        know.add(new int[]{1, 1});
        // 记录当前天数，有多少知道不能分享，有多少知道可以分享
        int knowCnt = 1, shareCnt = 0;
        for (int i = 2; i <= n; i++) {
            // 第 i - delay 天知道的人，他们可以分享了
            if (!know.isEmpty() && know.peekFirst()[0] == i - delay) {
                int[] first = know.pollFirst();
                knowCnt = (knowCnt - first[1] + MOD) % MOD;
                shareCnt = (shareCnt + first[1]) % MOD;
                share.add(first);
            }
            // 第 i - forget 天可以分享的人，他们必须要忘记了
            if (!share.isEmpty() && share.peekFirst()[0] == i - forget) {
                int[] first = share.pollFirst();
                shareCnt = (shareCnt - first[1] + MOD) % MOD;
            }
            // 如果存在可以分享的人，现在他们要分享了，知道的人多了这部分
            if (!share.isEmpty()) {
                knowCnt = (knowCnt + shareCnt) % MOD;
                know.add(new int[]{i, shareCnt});
            }
        }
        return (knowCnt + shareCnt) % MOD;
    }
}