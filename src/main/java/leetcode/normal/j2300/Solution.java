package leetcode.normal.j2300;

import java.util.Arrays;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/successful-pairs-of-spells-and-potions/description/">2300. 咒语和药水的成功对数</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int n = spells.length, m = potions.length;
        Integer[] pos = new Integer[n];
        for (int i = 0; i < n; i++) pos[i] = i;
        Arrays.sort(pos, (x, y) -> Integer.compare(spells[x], spells[y]));
        Arrays.sort(potions);
        int left = 0, right = m - 1;
        int[] ans = new int[n];
        while (left < n) {
            while (right >= 0 && (long) spells[pos[left]] * potions[right] >= success) --right;
            ans[pos[left]] = m - 1 - right;
            ++left;
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] spells = {5, 1, 3};
        int[] potions = {1, 2, 3, 4, 5};
        solution.successfulPairs(spells, potions, 7);
    }
}