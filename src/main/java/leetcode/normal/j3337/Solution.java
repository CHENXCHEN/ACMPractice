package leetcode.normal.j3337;

import java.util.List;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/total-characters-in-string-after-transformations-ii/description/">3337. 字符串转换后的长度 II</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    private static final int MOD = (int) 1e9 + 7;

    public int lengthAfterTransformations(String s, int t, List<Integer> nums) {
        int[] cnt = new int[26];
        for (char c : s.toCharArray()) {
            cnt[c - 'a']++;
        }
        // 构建映射矩阵
        // 对于字母 c，它会映射到 [c+1,c+nums[c]] 处，因此 cnt[c+1]+=cnt[c], cnt[c+2]+=cnt[c], ..., cnt[c+nums[c]]+=cnt[c]
        // 表示变换矩阵，matrix[v][u] 表示 v 由 u 变换而来
        int[][] matrix = new int[26][26];
        for (int u = 0; u < 26; u++) {
            for (int j = 0, v = u + 1; j < nums.get(u); j++, v++) {
                v %= 26;
                matrix[v][u]++;
            }
        }
        int[][] res = fastPow(matrix, t);
        int ans = 0;
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {
                ans = (int) ((ans + (long) res[i][j] * cnt[j]) % MOD);
            }
        }
        return ans;
    }

    int[][] fastPow(int[][] matrix, int n) {
        int[][] ans = getMatrixI();
        int[][] cur = new int[26][26];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                cur[i][j] = matrix[i][j];
            }
        }
        while (n > 0) {
            if ((n & 1) == 1) {
                ans = mulMatrix(ans, cur);
            }
            cur = mulMatrix(cur, cur);
            n >>= 1;
        }
        return ans;
    }

    int[][] mulMatrix(int[][] matrix1, int[][] matrix2) {
        int[][] result = new int[matrix1.length][matrix2[0].length];
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix2[0].length; j++) {
                for (int k = 0; k < matrix1[0].length; k++) {
                    result[i][j] = (int) ((result[i][j] + (long) matrix1[i][k] * matrix2[k][j]) % MOD);
                }
            }
        }
        return result;
    }

    int[][] getMatrixI() {
        int[][] matrix = new int[26][26];
        for (int u = 0; u < 26; u++) {
            matrix[u][u] = 1;
        }
        return matrix;
    }
}