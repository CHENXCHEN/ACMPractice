package leetcode.normal.j1105;

import java.util.Arrays;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/filling-bookcase-shelves/">1105. 填充书架</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int minHeightShelves(int[][] books, int shelfWidth) {
        int n = books.length;
        // dp[i] 为前 i 本书的最低高度是多少
        // 枚举以 i 结尾的最后一层的最高高度，然后取最小化 dp[i]
        int[] dp = new int[n + 1];
        Arrays.fill(dp, 2000000);
        dp[0] = 0;
        for (int i = 0; i < n; i++) {
            int maxHeight = 0, curWidth = 0;
            for (int j = i; j >= 0; j--) {
                curWidth += books[j][0];
                if (curWidth > shelfWidth) break;
                maxHeight = Math.max(maxHeight, books[j][1]);
                dp[i + 1] = Math.min(dp[i + 1], maxHeight + dp[j]);
            }
        }
        return dp[n];
    }
}