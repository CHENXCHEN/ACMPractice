package leetcode.normal.j3479;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/fruits-into-baskets-iii/description/">3479. 水果成篮 III</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int n = baskets.length;
        // 分块统计， 每个区有 m 个元素
        int m = (int) Math.sqrt(n);
        int parts = (n + m - 1) / m;
        int ans = 0;
        // 每个块保存当前的最大值
        int[] maxV = new int[parts];
        for (int i = 0; i < n; i++) {
            maxV[i / m] = Math.max(maxV[i / m], baskets[i]);
        }

        for (int fruit : fruits) {
            int unset = 1;
            for (int i = 0; i < parts; i++) {
                if (maxV[i] < fruit) continue;
                int choose = 0;
                maxV[i] = 0;
                for (int j = 0; j < m; j++) {
                    int pos = i * m + j;
                    if (pos < n && baskets[pos] >= fruit && choose == 0) {
                        choose = 1;
                        baskets[pos] = 0;
                    }
                    if (pos < n) maxV[i] = Math.max(maxV[i], baskets[pos]);
                }
                unset = 0;
                break;
            }
            ans += unset;
        }
        return ans;
    }
}