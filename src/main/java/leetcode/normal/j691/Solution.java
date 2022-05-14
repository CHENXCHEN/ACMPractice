package leetcode.normal.j691;

import java.util.ArrayDeque;
import java.util.Arrays;

/**
 * Created by CHENXCHEN
 * https://leetcode.cn/problems/stickers-to-spell-word/
 * 691. 贴纸拼词
 * 记忆化搜索 + 状态压缩
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int minStickers(String[] stickers, String target) {
        int[] vis = new int[1 << target.length()];
        int[][] stickCnt = new int[stickers.length][26];
        for (int i = 0; i < stickers.length; i++) {
            getCharCnt(stickers[i], stickCnt[i]);
        }
        Arrays.fill(vis, Integer.MAX_VALUE);
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.add(0);
        vis[0] = 0;
        while (!queue.isEmpty()) {
            Integer mask = queue.removeFirst();
            if (mask == vis.length) break;
            for (int i = 0; i < stickers.length; i++) {
                int nextMask = mask;
                int[] sCnt = Arrays.copyOf(stickCnt[i], 26);
                for (int j = 0; j < target.length(); j++) {
                    int bitPos = 1 << j;
                    int charPos = target.charAt(j) - 'a';
                    if (sCnt[charPos] > 0 && (nextMask & bitPos) == 0) {
                        nextMask ^= bitPos;
                        sCnt[charPos]--;
                    }
                }
                if (vis[mask] + 1 < vis[nextMask]) {
                    vis[nextMask] = vis[mask] + 1;
                    queue.addLast(nextMask);
                }
            }
        }
        return vis[vis.length - 1] == Integer.MAX_VALUE ? -1 : vis[vis.length - 1];
    }

    void getCharCnt(String sticker, int[] cnts) {
        for (int i = 0; i < sticker.length(); i++) {
            cnts[sticker.charAt(i) - 'a'] += 1;
        }
    }
}