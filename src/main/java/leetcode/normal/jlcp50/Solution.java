package leetcode.normal.jlcp50;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/WHnhjV/">LCP 50. 宝石补给</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int giveGem(int[] gem, int[][] operations) {
        for (int[] operation : operations) {
            int need = gem[operation[0]] / 2;
            gem[operation[0]] -= need;
            gem[operation[1]] += need;
        }
        int min = gem[0], max = gem[0];
        for (int item : gem) {
            min = Math.min(min, item);
            max = Math.max(max, item);
        }
        return max - min;
    }
}