package leetcode.normal.j573;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/squirrel-simulation/description/">573. 松鼠模拟</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int minDistance(int height, int width, int[] tree, int[] squirrel, int[][] nuts) {
        // sum 表示所有坚果到树所需要的距离
        // res 表示min(松鼠到坚果的距离 - 坚果到树的距离)
        // 最终答案为 sum + res
        int sum = 0, res = Integer.MAX_VALUE;
        for (int[] nut : nuts) {
            int nutToTreeDis = dis(nut, tree);
            sum += nutToTreeDis << 1;
            res = Math.min(res, -nutToTreeDis + dis(nut, squirrel));
        }
        return sum + res;
    }

    int dis(int[] pos1, int[] pos2) {
        return Math.abs(pos1[0] - pos2[0]) + Math.abs(pos1[1] - pos2[1]);
    }
}