package leetcode.normal.j2300;

import java.util.Arrays;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/successful-pairs-of-spells-and-potions/description/">2300. 咒语和药水的成功对数</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution2 {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int n = spells.length, m = potions.length;
        Arrays.sort(potions);
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = m - query(potions, (int) Math.ceil(1.0 * success / spells[i]));
        }
        return ans;
    }

    int query(int[] potions, int query) {
        int left = 0, right = potions.length - 1, ans = potions.length;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (potions[mid] >= query) {
                ans = mid;
                right = mid - 1;
            } else left = mid + 1;
        }
        return ans;
    }
}