package leetcode.normal.j1738;

import java.util.PriorityQueue;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/find-kth-largest-xor-coordinate-value/description/">1738. 找出第 K 大的异或坐标值</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int kthLargestValue(int[][] matrix, int k) {
        int rows = matrix.length, cols = matrix[0].length;
        int[][] xor = new int[rows + 1][cols + 1];
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                xor[i + 1][j + 1] = matrix[i][j] ^ xor[i][j + 1] ^ xor[i + 1][j] ^ xor[i][j];
                pq.add(xor[i + 1][j + 1]);
                if (pq.size() > k) pq.poll();
            }
        }
        return pq.peek();
    }
}