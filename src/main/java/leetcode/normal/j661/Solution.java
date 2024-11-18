package leetcode.normal.j661;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/image-smoother/description/">661. 图片平滑器</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int[][] imageSmoother(int[][] img) {
        int rows = img.length, cols = img[0].length;
        int[][] ans = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int cnt = 0;
                for (int k = -1; k <= 1; k++) {
                    for (int l = -1; l <= 1; l++) {
                        int x = i + k, y = j + l;
                        if (x >= 0 && x < rows && y >= 0 && y < cols) {
                            ans[i][j] += img[x][y];
                            ++cnt;
                        }
                    }
                }
                ans[i][j] /= cnt;
            }
        }
        return ans;
    }
}