package leetcode.normal.j3477;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/fruits-into-baskets-ii/description/">3477. 水果成篮 II</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int n = fruits.length, ans = 0;
        boolean[] marked = new boolean[n];
        for (int i = 0; i < n; i++) {
            boolean check = true;
            for (int j = 0; j < n; j++) {
                if (baskets[i] >= fruits[j] && !marked[j]) {
                    check = false;
                    marked[j] = true;
                    break;
                }
            }
            if (check) {
                ++ans;
            }
        }
        return ans;
    }
}