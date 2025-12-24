package leetcode.normal.j3074;

import java.util.Arrays;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/apple-redistribution-into-boxes/description/">3074. 重新分装苹果</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        Arrays.sort(capacity);
        int sum = Arrays.stream(apple).sum();
        int ans = 0, cnt = 0;
        for (int i = capacity.length - 1; i >= 0; i--) {
            ans += capacity[i];
            ++cnt;
            if (ans >= sum) break;
        }
        return cnt;
    }
}