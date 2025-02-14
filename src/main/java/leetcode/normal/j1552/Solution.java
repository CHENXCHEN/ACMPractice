package leetcode.normal.j1552;

import java.util.Arrays;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/magnetic-force-between-two-balls/description/">1552. 两球之间的磁力</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int left = 1, right = position[position.length - 1] - position[0], ans = 1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (check(position, m, mid)) {
                ans = mid;
                left = mid + 1;
            } else right = mid - 1;
        }
        return ans;
    }

    boolean check(int[] position, int m, int dis) {
        int last = position[0];
        m--;
        for (int i = 1; i < position.length && m > 0; i++) {
            if (position[i] - last >= dis) {
                m--;
                last = position[i];
            }
        }
        return m == 0;
    }
}