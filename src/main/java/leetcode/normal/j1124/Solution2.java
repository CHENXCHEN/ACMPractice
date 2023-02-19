package leetcode.normal.j1124;

import java.util.HashMap;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/longest-well-performing-interval/">1124. 表现良好的最长时间段</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution2 {
    public int longestWPI(int[] hours) {
        HashMap<Integer, Integer> tMap = new HashMap<>();
        int s = 0, ans = 0;
        // 若 hours[i] > 8，那么我们令 a[i] = 1，否则令 a[i] = -1
        // s[i] -> a[0] + ... + a[i]
        // 如果 s[i] > 0，那么长度 i + 1 可能为答案
        // 如果 s[i] < 0，我们需要在 i 左边找一个下标 j，使得 s[i] - s[j - 1] > 0，那么 [j,i] 则为可能的答案
        //      我们在 i 左边找到一个下标 j，使得 s[j] < s[i]，那么 [j+1,i] 则为可能的答案
        //      我们需要找到最小的 j，使得 [j+1,i] 区间长度尽可能的大
        //      我们可以找 s[i] - 1 在 s 中出现的第一个位置 j，因为想要到达 s[i] 必须要经过它(只有 1 和 -1)
        //      想要比 s[i] 小的数字，都必须经过 s[i] - 1 才能使得它更小，因此找到第一个 s[i] - 1
        //      令 s[j] = s[i] - 1，j 是出现的第一个位置，那么答案则为 [j+1,i]
        for (int i = 0; i < hours.length; i++) {
            s += hours[i] > 8 ? 1 : -1;
            if (s > 0) {
                ans = Math.max(ans, i + 1);
            } else {
                Integer lower = tMap.get(s - 1);
                if (lower != null) {
                    ans = Math.max(ans, i - lower);
                }
            }
            tMap.putIfAbsent(s, i);
        }
        return ans;
    }
}