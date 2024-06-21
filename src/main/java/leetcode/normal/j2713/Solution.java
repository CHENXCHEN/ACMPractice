package leetcode.normal.j2713;

import java.util.*;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/maximum-strictly-increasing-cells-in-a-matrix/description/">2713. 矩阵中严格递增的单元格数</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int maxIncreasingCells(int[][] mat) {
        int rows = mat.length, cols = mat[0].length;
        int ans = 1;
        TreeMap<Integer, ArrayList<int[]>> tMap = new TreeMap<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                tMap.computeIfAbsent(mat[i][j], x -> new ArrayList<>());
                tMap.get(mat[i][j]).add(new int[]{i, j});
            }
        }
        int[] rowMx = new int[rows], colMx = new int[cols];
        for (Map.Entry<Integer, ArrayList<int[]>> entry : tMap.entrySet()) {
            ArrayList<int[]> pos = entry.getValue();
            List<Integer> res = new ArrayList<>();
            for (int[] arr : pos) {
                // 计算走到每一个节点的最大步数
                res.add(Math.max(rowMx[arr[0]], colMx[arr[1]]) + 1);
            }
            // 更新每个节点的行列为最大步数
            for (int i = 0; i < pos.size(); i++) {
                int[] arr = pos.get(i);
                int d = res.get(i);
                rowMx[arr[0]] = Math.max(rowMx[arr[0]], d);
                colMx[arr[1]] = Math.max(colMx[arr[1]], d);
            }
        }
        return Arrays.stream(rowMx).max().getAsInt();
    }
}