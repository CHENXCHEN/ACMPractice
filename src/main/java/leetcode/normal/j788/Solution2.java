package leetcode.normal.j788;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/rotated-digits/">788. 旋转数字</a>
 * 数位 DP，我们要求的好数不受前导0的影响，因此我们只需要考虑所有位数与 n 相同并且小于等于 n 的数即可（允许前导0）
 * 假设 vis[pos][bound][diff] 为：选定 pos 位，bound 为是否边界，diff 为是否包含 2/5/6/9 时的好数个数
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
public class Solution2 {
    int[] check = {0, 0, 1, -1, -1, 1, 1, -1, 0, 1};
    int[][][] vis;
    ArrayList<Integer> digit;

    public int rotatedDigits(int n) {
        digit = new ArrayList<>();
        while (n > 0) {
            int cur = n % 10;
            digit.add(cur);
            n /= 10;
        }
        Collections.reverse(digit);
        vis = new int[digit.size()][2][2];
        for (int i = 0; i < digit.size(); i++)
            for (int j = 0; j < 2; j++)
                Arrays.fill(vis[i][j], -1);
        return dfs(0, 1, 0);
    }

    int dfs(int pos, int bound, int diff) {
        if (pos == digit.size()) return diff;
        if (vis[pos][bound][diff] != -1) return vis[pos][bound][diff];
        int ret = 0;
        int maxNum = bound == 1 ? digit.get(pos) : 9;
        for (int i = 0; i <= maxNum; i++) {
            if (check[i] != -1) {
                ret += dfs(pos + 1, bound == 1 && i == digit.get(pos) ? 1 : 0, diff == 1 || check[i] == 1 ? 1 : 0);
            }
        }
        vis[pos][bound][diff] = ret;
        return ret;
    }
}
